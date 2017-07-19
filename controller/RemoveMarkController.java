package studentHelper.controller;

import studentHelper.daoImpl.MarkDaoImpl;
import studentHelper.model.Mark;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Evgeny on 4/17/17.
 */
@WebServlet(name = "RemoveMarkController")
public class RemoveMarkController extends HttpServlet {
    private MarkDaoImpl markDao = new MarkDaoImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        markDao.removeMark(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("marksList", markDao.getAllMarks());
        request.getRequestDispatcher("WEB-INF/pages/listOfMarks.jsp").forward(request, response);
    }
}
