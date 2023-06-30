package models;

import java.io.Serializable;

/**
 *
 * @author Fortune Agbone
 */
//ensure to import java.io.Serializable implements Serializable when creating
// the AccountService Class
public class AccountService implements Serializable {
    public User login(String username, String password){        
        //Hardcoded validation for username and password
        if(username.equals("abe") && password.equals("password"))
        {
            return new User(username, null);
        }
        else if(username.equals("barb") && password.equals("password")){
            return new User(username, null);
        }
        
        return null; //Authentication failed;
    }
}
