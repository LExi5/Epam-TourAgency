package web.servlets.order;

import DAO.sql.entity.user.User;
import service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addOrder")
public class AddOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if( OrderService.addOrder(req)){
            System.out.println("Successful");
            req.setAttribute("orderMassage","Tour been ordered");
        }else{
            System.out.println("Error");
            req.setAttribute("orderMassage","You have already ordered this tour");
        }
        req.getRequestDispatcher("/toursPage.jsp").forward(req,resp);

    }
}
