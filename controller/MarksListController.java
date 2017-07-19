package studentHelper.controller;

import studentHelper.daoImpl.MarkDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Evgeny on 4/10/17.
 */
public class MarksListController extends HttpServlet {
    private MarkDaoImpl markDao = new MarkDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("marksList", markDao.getAllMarks());
        request.getRequestDispatcher("WEB-INF/pages/listOfMarks.jsp").forward(request, response);
    }
}
