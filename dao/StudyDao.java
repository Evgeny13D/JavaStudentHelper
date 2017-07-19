package studentHelper.dao;

import studentHelper.model.Study;
import studentHelper.model.User;

import java.util.List;

/**
 * Created by Evgeny on 4/9/17.
 */
public interface StudyDao {
    List<Study> getAllStudies();
    User getStudybyId(String id);
    void updateStudy(int id, Study study);
    void deleteStudyById(int id);
    void addStudy(Study study);
}
