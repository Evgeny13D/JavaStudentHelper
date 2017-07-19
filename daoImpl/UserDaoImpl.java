package studentHelper.daoImpl;

import studentHelper.dao.UserDao;
import studentHelper.model.Role;
import studentHelper.model.Student;
import studentHelper.model.User;
import studentHelper.services.ConnectionToDB;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Evgeny on 4/10/17.
 */
public class UserDaoImpl extends ConnectionToDB implements UserDao {
    private static final String SELECT_ALL = "SELECT *FROM student_helper.user";
    private static final String INSERT = "INSERT INTO student_helper.user(userName, password, role) values(?, ?, ?)";
    private static final String UPDATE = "UPDATE student_helper.user SET userName = ?, password = ?,  role = ? WHERE id=?;";
    private static final String DELETE = "DELETE FROM student_helper.user  WHERE id=? ";

    public List<User> getAllUsers() {
        List<User> userList = new LinkedList<User>();

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
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUser(resultSet.getString("userName"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(Role.valueOf(resultSet.getString("role")));

                userList.add(user);
            }
            connection.setAutoCommit(true);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    public User getUserbyId(String id) {
        return null;
    }

    public void updateUser(int id, User user) {
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = getConnection();
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, user.getUser());
            statement.setString(2, user.getPassword());
            statement.setString(3, String.valueOf(user.getRole()));
            statement.setInt(4, id);
            statement.executeUpdate();

            connection.commit();
            connection.setAutoCommit(true);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUserById(int id) {
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

    public void addUser(User user) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(INSERT);
            statement.setString(1, user.getUser());
            statement.setString(2, user.getPassword());
            statement.setString(3, String.valueOf(user.getRole()));
            statement.executeUpdate();

            connection.commit();
            connection.setAutoCommit(true);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserbyIdAndPassword(String id, String password) {
        return null;
    }
}
