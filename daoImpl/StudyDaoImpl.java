package studentHelper.daoImpl;

import studentHelper.dao.StudyDao;
import studentHelper.model.Role;
import studentHelper.model.Study;
import studentHelper.model.User;
import studentHelper.services.ConnectionToDB;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Evgeny on 4/17/17.
 */
public class StudyDaoImpl extends ConnectionToDB implements StudyDao {
    private static final String SELECT_ALL = "SELECT *FROM student_helper.studies";
    private static final String INSERT = "INSERT INTO student_helper.studies(name, hours, professor_id, avg_mark) values(?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE student_helper.studies SET name = ?, hours = ?,  professor_id = ?, avg_mark = ? WHERE id=?;";
    private static final String DELETE = "DELETE FROM student_helper.studies  WHERE id=? ";
    @Override
    public List<Study> getAllStudies() {
        List<Study> studyList = new LinkedList<Study>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SELECT_ALL);

            while (resultSet.next()){
                Study study = new Study();
                study.setId(resultSet.getInt("id"));
                study.setName(resultSet.getString("name"));
                study.setHours(resultSet.getString("hours"));
                study.setProfessor_id(resultSet.getInt("professor_id"));
                study.setAvg_mark(resultSet.getDouble("avg_mark"));

                studyList.add(study);
            }
            connection.setAutoCommit(true);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studyList;
    }

    @Override
    public User getStudybyId(String id) {
        return null;
    }

    @Override
    public void updateStudy(int id, Study study) {
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = getConnection();
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, study.getName());
            statement.setString(2, study.getHours());
            statement.setInt(3, study.getProfessor_id());
            statement.setDouble(4, study.getAvg_mark());
            statement.setInt(5, id);
            statement.executeUpdate();

            connection.commit();
            connection.setAutoCommit(true);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudyById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(DELETE);
            statement.setInt(1, id);
            statement.executeUpdate();

            connection.commit();
            connection.setAutoCommit(true);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addStudy(Study study) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(INSERT);
            statement.setString(1, study.getName());
            statement.setString(2, study.getHours());
            statement.setDouble(3, study.getProfessor_id());
            statement.setDouble(4, study.getAvg_mark());
            statement.executeUpdate();

            connection.commit();
            connection.setAutoCommit(true);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
