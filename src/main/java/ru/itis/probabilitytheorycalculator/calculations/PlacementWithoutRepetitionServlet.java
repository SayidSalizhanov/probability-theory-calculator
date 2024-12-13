package ru.itis.probabilitytheorycalculator.calculations;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.itis.probabilitytheorycalculator.MathService;

import java.io.IOException;
import java.math.BigInteger;

@WebServlet("/placementWithoutRepetition")
public class PlacementWithoutRepetitionServlet extends HttpServlet {
    private MathService service;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        service = (MathService) getServletContext().getAttribute("service");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("calculations/placeWithoutRep.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BigInteger n = new BigInteger(req.getParameter("totalItems"));
        BigInteger k = new BigInteger(req.getParameter("extractedItems"));

        if (k.compareTo(n) > 0 || n.intValue() < 0 || k.intValue() < 0) req.setAttribute("result", "Неверно введены данные");
        else req.setAttribute("result", service.placeWithoutRep(n,k));

        req.getRequestDispatcher("calculations/placeWithoutRep.jsp").forward(req, resp);
    }
}
