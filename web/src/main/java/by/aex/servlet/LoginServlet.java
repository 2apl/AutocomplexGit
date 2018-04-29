package by.aex.servlet;

import by.aex.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String defaultName = UserService.getInstance().getDefaultName().getName();
        req.setAttribute("defaultName", defaultName);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/login.jsp")
                .forward(req, resp);
    }
}
