package studentHelper.dao;

import studentHelper.model.Mark;
import studentHelper.model.Professor;

import java.util.List;

/**
 * Created by Evgeny on 4/9/17.
 */
public interface MarkDao {
    public void addMark(Mark mark);
    public List<Mark> getAllMarks();
    public void removeMark(int id);
    public void editMark(int id, Mark mark);
    public Mark getMarkById(int id);
}
