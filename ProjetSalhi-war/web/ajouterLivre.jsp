<%-- 
    Document   : ajouterLivre
    Created on : 3 janv. 2019, 15:02:17
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajouter livre</title>
        <link href="css/style.css" rel="stylesheet"/>
    </head>
    <body>
        <%@include  file="navBar.jsp" %> 
        <%@include  file="slideMenu.jsp" %> 
        
        <h1 id="titre" class="titre" >Ajouter livre</h1>
        <input type="text" disabled="true" class="separteur"/>
        <div id="dialogue" class="dialoge">
          
            <form  method="post" action="ajouterLivre"  enctype="true">
                <fieldset class="fieldsetGouche">
                <legend>Cote :</legend>
                <input type="text" name="cote" value="${sessionScope.livre.cote}"/>  
            </fieldset>
                 <fieldset>
                <legend>Titre :</legend>
                <input type="text" name="titre" value="${sessionScope.livre.titre}"/>  
            </fieldset>
                 <fieldset class="fieldsetGouche">
                <legend>Maison edition :</legend>
                <input type="text" name="maisonEdition" value="${sessionScope.livre.maisonEdition}"/>  
            </fieldset>
                 <fieldset>
                <legend>Annee Edition :</legend>
                <input type="date"  name="anneeEdition" value="${sessionScope.livre.anneeEdition}" />  
            </fieldset>
             </fieldset>
                 <fieldset class="fieldsetGouche">
                <legend>Auteur :</legend>
                <input type="text" name="auteur" value="${sessionScope.livre.maisonEdition}"/>  
            </fieldset>
             <fieldset >
                <legend>Nombre exemplaire :</legend>
                <input type="text" name="exemplaire" value="${sessionScope.livre.exemplaire}"/>  
            </fieldset>
                <input class="ui-button-submit" type="submit" onclick="reset()" name="save" value="Ajouter"/>
                <input class="ui-button-reset" type="reset" name="reset" value="reset"/>
            </form>
        </div>
            <script src="js/js.js" ></script>
    </body>
</html>
