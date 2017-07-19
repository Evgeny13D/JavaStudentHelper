package studentHelper.controller;

import studentHelper.daoImpl.GroupDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Evgeny on 4/10/17.
 */
public class GroupsListController extends HttpServlet {
    private GroupDaoImpl groupDao = new GroupDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("groupsList", groupDao.listOfGroups());
        request.getRequestDispatcher("WEB-INF/pages/listOfGroups.jsp").forward(request, response);
    }
}
