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
import java.util.Arrays;
import java.util.List;

@WebServlet("/permutationsWithRepetition")
public class PermutationsWithRepetitionServlet extends HttpServlet {
    private MathService service;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        service = (MathService) getServletContext().getAttribute("service");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("calculations/perWithRep.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BigInteger[] nums = Arrays.stream(req.getParameter("totalItems").split("\\s+")).map(BigInteger::new).toArray(BigInteger[]::new);

        if (Arrays.stream(nums).anyMatch(n -> n.intValue() < 0)) req.setAttribute("result", "Неверно введены данные");
        else req.setAttribute("result", service.perWithRep(nums));
        req.getRequestDispatcher("calculations/perWithRep.jsp").forward(req, resp);
    }
}
