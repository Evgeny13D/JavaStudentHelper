package studentHelper.controller;

import studentHelper.daoImpl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Evgeny on 4/16/17.
 */
@WebServlet(name = "RemoveUserController")
public class RemoveUserController extends HttpServlet {
    private final UserDaoImpl userDao = new UserDaoImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userDao.deleteUserById(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("usersList", userDao.getAllUsers());
        request.getRequestDispatcher("WEB-INF/pages/listOfUsers.jsp").forward(request, response);
    }
}
