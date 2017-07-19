package studentHelper.dao;

import studentHelper.model.User;

import java.util.List;

/**
 * Created by Evgeny on 4/9/17.
 */
public interface UserDao {
    List<User> getAllUsers();
    User getUserbyId(String id);
    void updateUser(int id, User user);
    void deleteUserById(int id);
    void addUser(User user);
    User getUserbyIdAndPassword(String id, String password);
}
