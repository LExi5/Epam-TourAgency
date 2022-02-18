package web.servlets.menu;

import DAO.factory.DAOFactory;
import DAO.sql.entity.user.User;

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
        List<User> users = new DAOFactory().getUserDAO("jdbc").getUsers();
        req.setAttribute("userList", users);
        req.getRequestDispatcher("/usersPage.jsp").forward(req,resp);
    }
}
