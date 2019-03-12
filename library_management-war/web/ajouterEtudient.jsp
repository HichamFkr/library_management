<%-- 
    Document   : ajouterEtudient
    Created on : 3 janv. 2019, 18:58:47
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
         <%@include  file="navBar.jsp" %> 
        <%@include  file="slideMenu.jsp" %> 
        
        <h1 id="titre" class="titre" >Ajouter etudient</h1>
        <input  type="text" disabled="true" class="separteur"/>
        <div id="dialogue" class="dialoge">
            
            <form  method="post" action="ajouterEtudient" enctype="true"  >
                <fieldset >
                <legend>Matricule :</legend>
                <input class="${erreurs}"  type="text" name="matricule" value="${sessionScope.etudient.matricule}"/>  
            </fieldset>
                 <fieldset>
                <legend>Nom :</legend>
                <input class="${erreurs}" type="text" name="nom" value="${sessionScope.etudient.nom}"/>  
            </fieldset>
                 <fieldset >
                <legend>Prenom :</legend>
                <input class="${erreurs}" type="text" name="prenom" value="${sessionScope.etudient.prenom}"/>  
            </fieldset>
                 <fieldset>
                <legend>Email :</legend>
                <input class="${erreurs}" type="text"  name="email" value="${sessionScope.etudient.email}" />  
            </fieldset>
             
            <input class="ui-button-submit" type="submit" onclick="reset()"  name="save" value="Ajouter"/>
                <input class="ui-button-reset" type="reset" name="reset" value="reset"/>
            </form>
        </div>
            <script src="js/js.js" ></script>
    </body>
</html>
