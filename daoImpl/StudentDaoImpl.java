package studentHelper.daoImpl;

import studentHelper.dao.StudentDao;
import studentHelper.model.Student;
import studentHelper.services.ConnectionToDB;

import java.sql.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Evgeny on 4/9/17.
 */
public class StudentDaoImpl extends ConnectionToDB implements StudentDao{
    private static final String SELECT_ALL = "SELECT *FROM student_helper.student_list";
    private static final String INSERT = "INSERT INTO student_helper.student_list(first_name, second_name, avg_mark, group_number) values(?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE student_helper.student_list SET first_name = ?, second_name = ?,  avg_mark = ?, group_number = ? WHERE id=?;";
    private static final String DELETE = "DELETE FROM student_helper.student_list  WHERE id=? ";

    public void addStudent(Student student) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(INSERT);
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getSecondName());
            statement.setDouble(3, student.getAvgMark());
            statement.setInt(4, student.getGroupNumber());
            statement.executeUpdate();

            connection.commit();
            connection.setAutoCommit(true);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void removeStudent(int id) {
        Student student = new Student();

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
    public List<Student> listStudents() {

        List<Student> studentList = new LinkedList<Student>();
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
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setSecondName(resultSet.getString("second_name"));
                student.setAvgMark(resultSet.getDouble("avg_mark"));
                student.setGroupNumber(resultSet.getInt("group_number"));

                studentList.add(student);
            }
            connection.setAutoCommit(true);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public void editStudent(int id, Student student) {
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = getConnection();
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getSecondName());
            statement.setDouble(3, student.getAvgMark());
            statement.setInt(4, student.getGroupNumber());
            statement.setInt(5, id);
            statement.executeUpdate();

            connection.commit();
            connection.setAutoCommit(true);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}