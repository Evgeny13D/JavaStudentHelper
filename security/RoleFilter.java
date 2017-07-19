package studentHelper.security;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import studentHelper.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static studentHelper.model.Role.ADMIN;


/**
 * Created by Evgeny on 4/14/17.
 */
@WebFilter(filterName = "RoleFilter")
public class RoleFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
            HttpServletRequest httpRequest = (HttpServletRequest) req;
            HttpServletResponse httpResponse = (HttpServletResponse) resp;

            User user = (User) httpRequest.getSession().getAttribute("user");
            if (user != null && user.getRole() == ADMIN) {
                chain.doFilter(req, resp);
            } else {
                httpResponse.sendRedirect("WEB-INF/pages/accesDenied.jsp");
            }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
