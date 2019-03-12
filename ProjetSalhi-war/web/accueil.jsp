<%-- 
    Document   : accueil
    Created on : 2 janv. 2019, 12:55:21
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil</title>
         <link href="css/style.css" rel="stylesheet"/>
    </head>
    <body >
        <%@include  file="navBar.jsp" %> 
        <%@include  file="slideMenu.jsp" %> 
        <h1 id="titre" class="titre">List des livres</h1>
        <input disabled="true" class="separteur" type="text"/>
        <h1>${message}</h1>
        <form action="rechercheLivre" method="post">
            <input class="search" placeholder="search" type="search" name="search"/>
        </form>
         <form action="reserverLivre" method="post">
             <input class="ui-button-reserver" type="submit" value="reserver"/>
        </form>
        <table id="table">
            <thead></thead>
            <thead><th>cote</th><th>Titre</th><th>Auteur</th><th>maison edition</th><th>annee edition</th><th>exenplaire</th></thead>
        <tbody>
             <c:forEach items="${sessionScope.livres}" var="list">
              <tr>
            <th ><c:out value="${list.cote}"/></th>
             <th><c:out value="${list.titre}"/></th>
             <th><c:out value="${list.auteur}"/></th>
              <th><c:out value="${list.maisonEdition}"/></th>
               <th><c:out value="${list.anneeEdition}"/></th>
                <th><c:out value="${list.exemplaire}"/></th>
                <th >
                    <c:choose>
                        <c:when test="${list.exemplaire>0}">
                    <a href="<c:url value='supprimerLivre'> <c:param name='id' value='${list.id}' /></c:url>">
<img src="<c:url value= 'images/ic_delete_forever_black_24dp_1x.png'/>" alt="Supprimer" /></a> 
                 <a href="<c:url value='reserverLivre'> <c:param name='id' value='${list.id}' /></c:url>">
<img src="<c:url value= 'images/ic_add_black_24dp_1x.png'/>" alt="Ajouter" /></a>
                        </c:when>
                    </c:choose></th>
                 </tr>            
            </c:forEach>        
        </tbody>
        </table>
       
     
        <script src="js/js.js"></script>
        
        
    </body>
</html>
