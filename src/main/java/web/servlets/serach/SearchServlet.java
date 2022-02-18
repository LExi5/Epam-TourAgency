package web.servlets.serach;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sortParam = req.getParameter("sortParam");
        String name = req.getParameter("searchByName");

        if(sortParam != null){

        }else if(name != null){

        }else{

        }

    }
}
