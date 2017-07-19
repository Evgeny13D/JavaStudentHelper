package studentHelper.daoImpl;

import studentHelper.dao.GroupDao;
import studentHelper.model.Group;
import studentHelper.model.Student;
import studentHelper.services.ConnectionToDB;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Evgeny on 4/17/17.
 */
public class GroupDaoImpl extends ConnectionToDB implements GroupDao {
    private static final String SELECT_ALL = "SELECT *FROM student_helper.groups";
    private static final String INSERT = "INSERT INTO student_helper.groups(group_number, avg_mark) values(?, ?)";
    private static final String UPDATE = "UPDATE student_helper.groups SET group_number = ?, avg_mark = ? WHERE id=?;";
    private static final String DELETE = "DELETE FROM student_helper.groups  WHERE id=? ";

    @Override
    public void removeGroup(int id) {
        Group group = new Group();

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
    public void addGroup(Group group) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(INSERT);
            statement.setString(1, group.getGroup_number());
            statement.setDouble(2, group.getAvg_mark());
            statement.executeUpdate();

            connection.commit();
            connection.setAutoCommit(true);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Group> listOfGroups() {
        List<Group> groupList = new LinkedList<Group>();

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
                Group group = new Group();
                group.setId(resultSet.getInt("id"));
                group.setGroup_number(resultSet.getString("group_number"));
                group.setAvg_mark(resultSet.getDouble("avg_mark"));

                groupList.add(group);
            }
            connection.setAutoCommit(true);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groupList;
    }

    @Override
    public void editGroup(int id, Group group) {
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = getConnection();
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, group.getGroup_number());
            statement.setDouble(2, group.getAvg_mark());
            statement.setInt(3, id);
            statement.executeUpdate();

            connection.commit();
            connection.setAutoCommit(true);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
