package studentHelper.controller;

import studentHelper.model.Role;
import studentHelper.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

/**
 * Created by Evgeny on 4/3/17.
 */
public class AuthController extends HttpServlet {
    private static String URL = "jdbc:mysql://localhost:3306/student_helper";
    private static String USERNAME = "root";
    private static String PASSWORD = "root";
    private static final String SELECT = "SELECT * FROM student_helper.user WHERE userName = ?; ";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User user = new User();

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
           Class.forName("com.mysql.jdbc.Driver");
           connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
           connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
           connection.setAutoCommit(false);
           preparedStatement = connection.prepareStatement(SELECT);
           preparedStatement.setString(1, login);
           ResultSet resultSet = preparedStatement.executeQuery();

           if(resultSet.next()){
               user.setUser(resultSet.getString("userName"));
               user.setPassword(resultSet.getString("password"));
               user.setRole(Role.valueOf(resultSet.getString("role")));
           }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.getSession().setAttribute("user", user);
        if(login.equals(user.getUser()) && password.equals(user.getPassword()) && "ADMIN".equals(String.valueOf(user.getRole()))) {
            req.getRequestDispatcher("WEB-INF/pages/chooseAction.jsp").forward(req, resp);
        } else if (login.equals(user.getUser()) && password.equals(user.getPassword())){
            req.getRequestDispatcher("WEB-INF/pages/chooseActionSP.jsp").forward(req, resp);
        } else {
            req.setAttribute("errorMessage", "Login or password is incorrect");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
