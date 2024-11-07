package by.itclass.controllers;

import by.itclass.model.services.UserService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/condition")
public class ConditionServlet extends HttpServlet {
    private UserService service;

    @Override
    public void init() throws ServletException {
        service = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var users = service.getByConditions(req.getParameterMap());
        if (!users.isEmpty()) {
            req.setAttribute("us", users);
        } else {
            req.setAttribute("mes", "Not found");
        }
        req.getRequestDispatcher("/users.jsp").forward(req, resp);
    }
}
