<%-- 
    Document   : login
    Created on : 2 janv. 2019, 12:18:27
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="css/style.css" rel="stylesheet"/>
    </head>
    <body>
        <div class="left">
            <h1>Bibliotheque</h1>
        </div>
        <div class="right">
           <div class="ui-panel-login">
        <form action="login" method="post">
            <legend>Email :</legend>
            <input placeholder="email..." type="text" name="email" class="ui-input"/><br/><br/><br/>
            <legend>Pass word :</legend>
            <input id="password" placeholder="password..." type="password" name="password" class="ui-input"/><br/>
            <input class="ui-button-login" onclick="v()" type="submit" name="login" value="login" />
        </form>
        </div> 
        </div>
       
    </body>
</html>
