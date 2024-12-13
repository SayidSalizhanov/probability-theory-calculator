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

@WebServlet("/urnModel")
public class UrnModelServlet extends HttpServlet {
    private MathService service;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        service = (MathService) getServletContext().getAttribute("service");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("calculations/urnModel.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BigInteger n = new BigInteger(req.getParameter("totalItems"));
        BigInteger m = new BigInteger(req.getParameter("markedItems"));
        BigInteger k = new BigInteger(req.getParameter("extractedItems"));
        String rstr = req.getParameter("expectedMarked");
        BigInteger r;
        if (rstr == null || rstr.isEmpty()) {
            r = new BigInteger(String.valueOf(k.intValue()));
        }
        else r = new BigInteger(req.getParameter("expectedMarked"));

        if (m.compareTo(n) > 0 || k.compareTo(n) > 0 || r.compareTo(k) > 0
                || n.intValue() < 0 || m.intValue() < 0 || k.intValue() < 0
                || r.intValue() < 0 || n.intValue() - m.intValue() < k.intValue() - r.intValue()
                || n.intValue() < k.intValue() || m.intValue() < r.intValue()) {
            req.setAttribute("result", "Неверно введены данные");
        }
        else req.setAttribute("result", service.urnModel(n,m,k,r));
        req.getRequestDispatcher("calculations/urnModel.jsp").forward(req, resp);
    }
}
