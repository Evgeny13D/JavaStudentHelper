package studentHelper.controller;

import studentHelper.dao.MarkDao;
import studentHelper.daoImpl.MarkDaoImpl;
import studentHelper.model.Mark;
import studentHelper.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Evgeny on 4/17/17.
 */
@WebServlet(name = "EditMarkController")
public class EditMarkController extends HttpServlet {
    private MarkDaoImpl markDao = new MarkDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Mark mark = new Mark();
        mark.setStudy_id(Integer.parseInt(request.getParameter("study_id")));
        mark.setStudent_id(Integer.parseInt(request.getParameter("student_id")));
        mark.setDate(request.getParameter("date"));
        mark.setProfessor_id(Integer.parseInt(request.getParameter("professor_id")));
        mark.setMark(Integer.parseInt(request.getParameter("mark")));
//        mark.setComments(request.getParameter("comments"));

        int id = Integer.parseInt(request.getParameter("id"));

        markDao.editMark(id, mark);
        request.setAttribute("studentsList", markDao.getAllMarks());
        request.getRequestDispatcher("WEB-INF/pages/listOfMarks.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
