<%-- 
    Document   : listeDesPretses
    Created on : 5 janv. 2019, 14:02:16
    Author     : ASUS
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <table id="table">
            <thead><th>Matricule</th><th>Nom</th><th>Prenom</th><th>Email</th> <th>cote</th><th>Titre</th></thead>
        <tbody>
             <c:forEach items="${sessionScope.listeDesPretses}" var="list">
              <tr >
                  <th><c:out value="${list.etudient.matricule}"/></th>
                  <th><c:out value="${list.etudient.nom}"/></th>
           <th><c:out value="${list.etudient.prenom}"/></th>   
           <th><c:out value="${list.etudient.email}"/></th>
            <th><c:out value="${list.livre.titre}"/></th>
            <th><c:out value="${list.livre.cote}"/></th>
             
                <th ><a href="<c:url value='supprimerListeDesPrets'> <c:param name='id' value='${list.id}' /></c:url>">
<img src="<c:url value= 'images/ic_delete_forever_black_24dp_1x.png'/>" alt="Supprimer" /></a> 
                 </th>
                 </tr>            
            </c:forEach>        
        </tbody>
        </table>
        <script src="js/js.js"></script>
    </body>
</html>
