<%-- 
    Document   : home
    Created on : Jun 24, 2023, 4:17:00 AM
    Author     : Fortune Agbone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Home Page</h1>
        
        <p>Hello ${username}</p>
        
        <!--
        The logout button will make a request to the login servlet
        the query string (?) contains one parameter called logout
        this parameter does not have a value, so it will be sent as blank string
        if the logout parameter does not exist, it will be considered null
        -->
        <a href="login?logout">Log out</a>
    </body>
</html>
