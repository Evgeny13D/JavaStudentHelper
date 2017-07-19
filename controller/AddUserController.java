package studentHelper.controller;

import studentHelper.daoImpl.UserDaoImpl;
import studentHelper.model.Role;
import studentHelper.model.Student;
import studentHelper.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Evgeny on 4/16/17.
 */
@WebServlet(name = "AddUserController")
public class AddUserController extends HttpServlet {
    private UserDaoImpl userDao = new UserDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();

        user.setUser(request.getParameter("userName"));
        user.setPassword(request.getParameter("password"));
        user.setRole(Role.valueOf(request.getParameter("role")));

        userDao.addUser(user);

        request.setAttribute("usersList", userDao.getAllUsers());
        request.getRequestDispatcher("WEB-INF/pages/listOfUsers.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/pages/addUserForm.jsp").forward(request, response);
    }
}
