package studentHelper.controller;

import studentHelper.daoImpl.StudyDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Evgeny on 4/17/17.
 */
@WebServlet(name = "RemoveStudyController")
public class RemoveStudyController extends HttpServlet {
    private StudyDaoImpl studyDao = new StudyDaoImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        studyDao.deleteStudyById(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("studiesList", studyDao.getAllStudies());
        request.getRequestDispatcher("WEB-INF/pages/listOfStudies.jsp").forward(request, response);
    }
}
