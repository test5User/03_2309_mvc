package by.itclass.controllers;

import by.itclass.model.db.DbInMemory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/search")
public class SearchController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var fio = req.getParameter("fio");
        var isPresent = DbInMemory.isPresent(fio);

        //var rd = req.getRequestDispatcher(isPresent ? "/yes.html" : "/no.html");
        RequestDispatcher rd;
        if (isPresent) {
            rd = req.getRequestDispatcher("/yes.html");
        } else {
            rd = req.getRequestDispatcher("/no.html");
        }
        rd.forward(req, resp);
    }
}
