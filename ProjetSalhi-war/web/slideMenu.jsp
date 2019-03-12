<%-- 
    Document   : slideMenu
    Created on : 2 janv. 2019, 13:34:12
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet"/>
    </head>
    <body>
        <div id="side-menu" class="side-nav">
             <nav class="sousnavbar" id="sousnavbar"> 
                <img id="ui-image-folder" src="images/ic_folder_open_white_36dp_1.png" class="ui-image-folder"/>
                <h4 id="h4">Gestion Bibiotheque</h4>
                <a href="#" onclick="closeSlideMenu()"><img src="images/ic_clear_white_24dp_2x.png" class="ui-image-clear" /></a>
            
             </nav>
            
            <ul>
                <li>
                    <a class="a" href="accueil.jsp">List des livres</a>
                </li>
                <li>
                    <a class="a" href="ajouterLivre.jsp">ajouter livre</a>
                </li>
                <li>
                    <a class="a" href="ListEtudient.jsp">List des etudients</a>
                </li>
                <li>
                    <a class="a" href="ajouterEtudient.jsp">ajouter etudient</a>
                </li>
                <li>
                    <a class="a" href="listeDesPretses.jsp">listeDesPretses</a>
                </li>
            </ul>
        </div>
    </body>
</html>
