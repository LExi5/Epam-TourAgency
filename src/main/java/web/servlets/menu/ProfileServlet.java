package web.servlets.menu;

import DAO.factory.DAOFactory;
import DAO.sql.entity.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        session.setAttribute("orders",new DAOFactory().getOrderDAO("jdbc").getAllUserOrders(user.getUserID()));
        req.getRequestDispatcher("/profile.jsp").forward(req,resp);
    }
}
