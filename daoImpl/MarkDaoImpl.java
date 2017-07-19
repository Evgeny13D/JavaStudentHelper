package studentHelper.daoImpl;

import studentHelper.dao.MarkDao;
import studentHelper.model.Mark;
import studentHelper.model.Professor;
import studentHelper.services.ConnectionToDB;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Evgeny on 4/17/17.
 */
public class MarkDaoImpl extends ConnectionToDB implements MarkDao {
    private static final String SELECT_ALL = "SELECT *FROM student_helper.marks";
    private static final String INSERT = "INSERT INTO student_helper.marks(study_id, student_id, date, professor_id, mark, comments) values(?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE student_helper.marks SET student_id = ?, student_id = ?,  date = ?, professor_id = ?, mark = ?, comments = ? WHERE id=?;";
    private static final String DELETE = "DELETE FROM student_helper.marks  WHERE id=? ";

    @Override
    public void addMark(Mark mark) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(INSERT);
            statement.setInt(1, mark.getStudy_id());
            statement.setInt(2, mark.getStudent_id());
            statement.setString(3, mark.getDate());
            statement.setInt(4, mark.getProfessor_id());
            statement.setInt(5, mark.getMark());
            statement.setString(6, mark.getComments());
            statement.executeUpdate();

            connection.commit();
            connection.setAutoCommit(true);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Mark> getAllMarks() {
        List<Mark> markList = new LinkedList<Mark>();

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
                Mark mark = new Mark();
                mark.setId(resultSet.getInt("id"));
                mark.setStudy_id(resultSet.getInt("study_id"));
                mark.setStudent_id(resultSet.getInt("student_id"));
                mark.setDate(resultSet.getString("date"));
                mark.setProfessor_id(resultSet.getInt("professor_id"));
                mark.setMark(resultSet.getInt("mark"));
                mark.setComments(resultSet.getString("comments"));

                markList.add(mark);
            }
            connection.setAutoCommit(true);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return markList;
    }

    @Override
    public void removeMark(int id) {
        Mark mark = new Mark();

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
    public void editMark(int id, Mark mark) {
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = getConnection();
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(UPDATE);
            statement.setInt(1, mark.getStudy_id());
            statement.setInt(2, mark.getStudent_id());
            statement.setString(3, mark.getDate());
            statement.setInt(4, mark.getProfessor_id());
            statement.setInt(5, mark.getMark());
            statement.setString(6, mark.getComments());
            statement.setInt(7, id);
            statement.executeUpdate();

            connection.commit();
            connection.setAutoCommit(true);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Mark getMarkById(int id) {
        return null;
    }
}
