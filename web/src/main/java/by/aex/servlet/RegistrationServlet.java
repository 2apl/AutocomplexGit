package by.aex.servlet;

import by.aex.entity.Account;
import by.aex.entity.Role;
import by.aex.entity.User;
import by.aex.service.AccountService;
import by.aex.service.UserService;
import by.aex.util.ContextUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher("/registration.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = new User(firstName, lastName, email, password);
        UserService bean = ContextUtil.getContext(UserService.class);
        bean.save(user);

        Account account = Account.createNew(user);

        resp.sendRedirect("/registration");
    }
}
