package web.servlets.order;

import service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class ChangeStatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (OrderService.changeStatus(req) == false) {
            req.setAttribute("massage","Can not change status");
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }
        resp.sendRedirect("profile");
    }
}
