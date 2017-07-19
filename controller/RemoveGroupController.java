package studentHelper.controller;

import studentHelper.daoImpl.GroupDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Evgeny on 4/17/17.
 */
@WebServlet(name = "RemoveGroupController")
public class RemoveGroupController extends HttpServlet {
    private GroupDaoImpl groupDao = new GroupDaoImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        groupDao.removeGroup(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("groupsList", groupDao.listOfGroups());
        request.getRequestDispatcher("WEB-INF/pages/listOfGroups.jsp").forward(request, response);
    }
}
