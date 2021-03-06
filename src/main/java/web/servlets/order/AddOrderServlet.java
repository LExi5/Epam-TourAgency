package web.servlets.order;

import DAO.factory.DAOFactory;
import service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addOrder")
public class AddOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (OrderService.addOrder(req)) {
            req.getRequestDispatcher("/toursPage.jsp").forward(req,resp);
        }
        req.setAttribute("massage","You have already ordered this tour");
        req.getRequestDispatcher("/error.jsp").forward(req,resp);


    }
}
