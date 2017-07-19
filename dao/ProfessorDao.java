package studentHelper.dao;

import studentHelper.model.Professor;

import java.util.List;

/**
 * Created by Evgeny on 4/9/17.
 */
public interface ProfessorDao {
    public void addProffesor(Professor professor);
    public List<Professor> getAllProfessors();
    public void removeProfessor(int id);
    public void editProfessor(int id, Professor professor);
    public Professor getProfessorById(int id);
}
