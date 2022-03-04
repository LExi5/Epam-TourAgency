package web.servlets.menu;

import DAO.factory.DAOFactory;
import DAO.factory.order.OrderDAO;
import DAO.sql.entity.TourOrder;
import DAO.sql.entity.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static DAO.sql.entity.user.Type.USER;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        int page = 1;
        int recordsPerPage = 3;

        OrderDAO orderDAO = new DAOFactory().getOrderDAO("jdbc");
        User user = (User) session.getAttribute("user");

        if (user.getType() != USER) {

            List<TourOrder> orders = orderDAO.getAllOrders((page - 1) * recordsPerPage,
                    recordsPerPage);
            session.setAttribute("orders", orders);
            int noOfRecords = orderDAO.getCountOfOrders();
            int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
            req.setAttribute("noOfPages", noOfPages);
            req.setAttribute("currentPage", page);
            req.getRequestDispatcher("/profile.jsp").forward(req, resp);

        } else {

            List<TourOrder> orders = orderDAO.getAllUserOrders(user.getId(),(page - 1) * recordsPerPage,
                    recordsPerPage);
            session.setAttribute("orders", orders);
            int noOfRecords = orderDAO.getCountOfUserOrders(user.getId());
            int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
            req.setAttribute("noOfPages", noOfPages);
            req.setAttribute("currentPage", page);
            req.getRequestDispatcher("/profile.jsp").forward(req, resp);

        }
    }
}
