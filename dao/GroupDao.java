package studentHelper.dao;

import studentHelper.model.Group;

import java.util.List;

/**
 * Created by Evgeny on 4/9/17.
 */
public interface GroupDao {
    public void removeGroup(int id);
    public void addGroup(Group group);
    public List<Group> listOfGroups();
    public void editGroup(int id, Group group);
}
