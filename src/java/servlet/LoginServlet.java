package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;
import models.User;

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

        // Check for a "logout" parameter with the incoming request
        String logout = request.getParameter("logout");
        // if the logout parameter exists, then the user wants to log out
        // if the logout parameter exists then it will be a blank string, which is not null
        // if the logout parameter does not exist, it will be considered null
        if (logout != null) {
            //invalid logout and display logout message
            session.invalidate();
            request.setAttribute("message", "you have succesfully loggd out.");
            session = request.getSession();
        }

        // if the user is logged in, their username will be in the session object
        String username = (String)session.getAttribute("username");
        // if the user name exists, the user is logged in
        if(username != null){
            // if they are logged in, they have no reason to be at the login page
            // so redirect them to the home page
            response.sendRedirect("home");
            return;
        }
        
        //displaying the login.jsp file
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
            creating a session
            HttpSession requires an import - import javax.servlet.http.HttpSession;
         */
        HttpSession session = request.getSession();

        //store user input for username and password into variables
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //validate that the user name and password are not empty
        if (username != null || !username.equals("") && password != null || !password.equals("")) {

            //Call login() method of Account Service to validate credentials
            //requires you to import models.AccountService;
            AccountService accountService = new AccountService();
            User user = accountService.login(username, password);

            if (user != null) {
                //Authentication Successful, Store username in session variable
                // this attribute will only be set once the user has logged in
                session.setAttribute("username", username);

                //Redirect to home URL
                response.sendRedirect("home");
                return; //return to avoid executing the same code
            }
        }

        //invalid authentication parameters
        //display error message and forward to login.jsp
        request.setAttribute("error", "Invalid username or password");
        request.setAttribute("username", username);//Retain previous input in the textbox
        
        //forward to login.jsp
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        return;
    }
}
