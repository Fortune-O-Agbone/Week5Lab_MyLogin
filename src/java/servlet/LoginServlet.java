package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Fortune Agbone
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*
            creating a session
            HttpSession requires an import - import javax.servlet.http.HttpSession;
         */
        HttpSession session = request.getSession();

        //displaying the login.jsp file
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //store user input for username and password into variables
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //validate that the user name and password are not empty
        if (username == null || username.equals("") || password == null || password.equals("")) {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }

        getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
        return;
    }
}
