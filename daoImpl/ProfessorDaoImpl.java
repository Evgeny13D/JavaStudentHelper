package studentHelper.daoImpl;

import studentHelper.dao.ProfessorDao;
import studentHelper.model.Professor;
import studentHelper.model.Student;
import studentHelper.services.ConnectionToDB;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Evgeny on 4/16/17.
 */
public class ProfessorDaoImpl extends ConnectionToDB implements ProfessorDao {
    private static final String SELECT_ALL = "SELECT *FROM student_helper.professors";
    private static final String INSERT = "INSERT INTO student_helper.professors(first_name, second_name, father_name, birth_date, avg_mark) values(?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE student_helper.professors SET first_name = ?, second_name = ?,  father_name = ?, birth_date = ?, avg_mark = ? WHERE id=?;";
    private static final String DELETE = "DELETE FROM student_helper.professors  WHERE id=? ";
    @Override
    public void addProffesor(Professor professor) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(INSERT);
            statement.setString(1, professor.getFirst_name());
            statement.setString(2, professor.getSecond_name());
            statement.setString(3, professor.getFather_name());
            statement.setString(4, professor.getBirth_date());
            statement.setDouble(5, professor.getAvg_mark());
            statement.executeUpdate();

            connection.commit();
            connection.setAutoCommit(true);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Professor> getAllProfessors() {
        List<Professor> professorList = new LinkedList<Professor>();

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
                Professor professor = new Professor();
                professor.setId(resultSet.getInt("id"));
                professor.setFirst_name(resultSet.getString("first_name"));
                professor.setSecond_name(resultSet.getString("second_name"));
                professor.setFather_name(resultSet.getString("father_name"));
                professor.setBirth_date(resultSet.getString("birth_date"));
                professor.setAvg_mark(resultSet.getDouble("avg_mark"));

                professorList.add(professor);
            }
            connection.setAutoCommit(true);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professorList;
    }

    @Override
    public void removeProfessor(int id) {
        Professor professor = new Professor();

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
    public void editProfessor(int id, Professor professor) {
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = getConnection();
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, professor.getFirst_name());
            statement.setString(2, professor.getSecond_name());
            statement.setString(3, professor.getFather_name());
            statement.setString(4, professor.getBirth_date());
            statement.setDouble(5, professor.getAvg_mark());
            statement.setInt(6, id);
            statement.executeUpdate();

            connection.commit();
            connection.setAutoCommit(true);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Professor getProfessorById(int id) {
        return null;
    }
}
