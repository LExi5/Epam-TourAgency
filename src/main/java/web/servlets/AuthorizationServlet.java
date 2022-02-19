package web.servlets;
import DAO.sql.entity.TourOrder;
import DAO.sql.entity.user.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/authorization")
public class AuthorizationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = null;
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        try{
            user = UserService.authentication(email,password);
            if(user != null){
                HttpSession session = req.getSession();
                session.setAttribute("access",user.getType());
                session.setAttribute("user",user);
                session.setAttribute("orders",new ArrayList<TourOrder>());
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }else{
                req.setAttribute("massage","Email or password is incorrect");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        }catch (Exception ex){
            req.setAttribute("massage",ex.getMessage());
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
