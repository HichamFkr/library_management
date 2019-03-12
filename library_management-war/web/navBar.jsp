<%-- 
    Document   : navBar
    Created on : 2 janv. 2019, 13:23:45
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <nav class="navbar">
           <span class="open-slide">
          <a href="#" onclick="openSlideMenu()">
            <svg width="30" height="30">
                <path d="M0,5 30,5" stroke="#fff" stroke-width="5"/>
                <path d="M0,14 30,14" stroke="#fff" stroke-width="5"/>
                <path d="M0,23 30,23" stroke="#fff" stroke-width="5"/>
            </svg>
          </a>
        </span>
           
           <img src="images/ic_settings_white_18dp_2x.png"  class="ui-image-settings" />
           <img src="images/ic_notifications_none_white_36dp.png" class="ui-image-notification" />
           <a href="login.jsp">   <img src="images/ic_exit_to_app_white_36dp.png" class="ui-image-exit" /></a>
        </nav>
    </body>
</html>
