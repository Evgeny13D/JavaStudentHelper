package studentHelper.dao;

import studentHelper.model.Student;

import java.util.List;

/**
 * Created by Evgeny on 4/9/17.
 */
public interface StudentDao {
    public void addStudent(Student student);
    public void removeStudent(int id);
    public List<Student> listStudents();
    public void editStudent(int id, Student student);
}
