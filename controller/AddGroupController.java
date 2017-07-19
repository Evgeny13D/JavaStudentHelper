package studentHelper.controller;

import studentHelper.daoImpl.GroupDaoImpl;
import studentHelper.model.Group;
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
@WebServlet(name = "AddGroupController")
public class AddGroupController extends HttpServlet {
    private GroupDaoImpl groupDao = new GroupDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Group group = new Group();

        group.setGroup_number(request.getParameter("group_number"));
        group.setAvg_mark(Double.valueOf(request.getParameter("avg_mark")));

        groupDao.addGroup(group);

        request.setAttribute("groupsList", groupDao.listOfGroups());
        request.getRequestDispatcher("WEB-INF/pages/listOfGroups.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/pages/addGroupForm.jsp").forward(request, response);
    }
}
