package models;

import java.io.Serializable;

/**
 *
 * @author Fortune Agbone
 */
//ensure to import java.io.Serializable implements Serializable when creating
// the AccountService Class
public class AccountService implements Serializable {
    private String username;
    private String password;

    public AccountService() {
        username = "";
        password = "";
    }

    public AccountService(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean login(String username, String password){
        //predefined credentials for validation
        String valid_username = "abe";
        String valid_password = "password";
        
        //validate the provided username and password
        if(username.equals(valid_username) && password.equals(valid_password))
        {
            //authentication successful
            return true;
        }
        else{
            return false;
        }
    }
}
