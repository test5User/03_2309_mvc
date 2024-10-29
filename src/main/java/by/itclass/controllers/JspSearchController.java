package by.itclass.controllers;

import by.itclass.model.db.DbInMemory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/jspSearch")
public class JspSearchController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var fio = req.getParameter("fio");
        var user = DbInMemory.findByFio(fio);
        if(user != null) {
            req.setAttribute("us", user);
        } else {
            req.setAttribute("mes", "User with " + fio + " not found.");
        }
        req.getRequestDispatcher("/user-info.jsp").forward(req, resp);
    }
}
