package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Fortune Agbone
 */
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
            creating a session
            HttpSession requires an import - import javax.servlet.http.HttpSession;
         */
        HttpSession session = request.getSession();

        //getting the username as a String Object
        String username = (String) session.getAttribute("username");

        if(username == null){
            response.sendRedirect("login");
            return;
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request,response);
        return;
        
        /*
        if (username != null) {
            //user is authenticated. Display the welcome message
            //displaying the home.jsp file
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp");
        }
        else
        {
            //user is not authenticated. Redirect to Login
            response.sendRedirect("login");
        }
*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
