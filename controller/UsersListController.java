package studentHelper.controller;

import studentHelper.daoImpl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Evgeny on 4/10/17.
 */
public class UsersListController extends HttpServlet {
    private UserDaoImpl userDao = new UserDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("usersList", userDao.getAllUsers());
        request.getRequestDispatcher("WEB-INF/pages/listOfUsers.jsp").forward(request, response);
    }
}
