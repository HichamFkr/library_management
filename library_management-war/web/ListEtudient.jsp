<%-- 
    Document   : ListEtudient
    Created on : 3 janv. 2019, 17:21:21
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
         <h1 id="titre" class="titre" >List des etudients</h1>
        <input type="text" disabled="true" class="separteur"/>
         <form action="rechercheEtudient" method="post">
             <input class="search" placeholder="search" type="search" name="search"/>
        </form>
        <table>
            <thead><th>Matricule</th><th>Nom</th><th>Prenom</th> <th>Email</th></thead>
        <tbody>
       
            <c:forEach items="${sessionScope.etudients}" var="etudient" >
                <tr>
                    <th>
                        <c:out value="${etudient.matricule}"/>
                    </th>
                    <th>
                        <c:out value="${etudient.nom}"/>
                    </th>
                    <th>
                        <c:out value="${etudient.prenom}"/>
                    </th>
                    <th>
                        <c:out value="${etudient.email}"/>
                    </th>
                    <th>
                    <a href="<c:url value='supprimerEtudient'> <c:param name='id' value='${etudient.id}' /></c:url>">
<img src="<c:url value= 'images/ic_delete_forever_black_24dp_1x.png'/>" alt="Supprimer" /></a>
                     <a href="<c:url value='getEtudient'> <c:param name='id' value='${etudient.id}' /></c:url>">
<img src="<c:url value= 'images/ic_add_black_24dp_1x.png'/>" alt="Ajouter" /></a></th>
        
                </tr>
        </c:forEach>
        </tbody>
        </table>
           
       
         <script src="js/js.js"></script>
    </body>
</html>
