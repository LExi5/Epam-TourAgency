package web.servlets.menu;

import DAO.factory.DAOFactory;
import DAO.factory.user.UserDAO;
import DAO.factory.user.UserDAOImpl;
import DAO.sql.entity.user.User;
import org.apache.logging.log4j.core.util.JsonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = 1;
        int recordsPerPage = 5;

        UserDAO userDAO = new DAOFactory().getUserDAO("jdbc");
        if (req.getParameter("page") != null)
            page = Integer.parseInt(req.getParameter("page"));

        List<User> users = userDAO.getUsers((page - 1) * recordsPerPage,
                recordsPerPage);

        int noOfRecords = userDAO.getUserCount();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        req.setAttribute("userList", users);
        req.setAttribute("noOfPages", noOfPages);
        req.setAttribute("currentPage", page);
        req.getRequestDispatcher("/usersPage.jsp").forward(req, resp);
    }
}
