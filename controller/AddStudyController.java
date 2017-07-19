package studentHelper.controller;

import studentHelper.daoImpl.StudentDaoImpl;
import studentHelper.daoImpl.StudyDaoImpl;
import studentHelper.model.Student;
import studentHelper.model.Study;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Evgeny on 4/17/17.
 */
@WebServlet(name = "AddStudyController")
public class AddStudyController extends HttpServlet {
    private StudyDaoImpl studyDao = new StudyDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Study study = new Study();

        study.setName(request.getParameter("name"));
        study.setHours(request.getParameter("hours"));
        study.setProfessor_id(Integer.parseInt(request.getParameter("professor_id")));
        study.setAvg_mark(Integer.parseInt(request.getParameter("avg_mark")));

        studyDao.addStudy(study);

        request.setAttribute("studiesList", studyDao.getAllStudies());
        request.getRequestDispatcher("WEB-INF/pages/listOfStudies.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/pages/addStudyForm.jsp").forward(request, response);
    }
}
