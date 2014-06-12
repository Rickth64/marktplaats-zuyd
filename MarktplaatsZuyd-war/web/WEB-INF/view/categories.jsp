<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%-- 
    Document   : categories
    Created on : 7-jun-2014, 17:20:02
    Author     : rick
--%>

<div id="leftColumn">
    <div id="pageTextLeft">
        <p>Hiernaast vindt u alle categorieën.</p>
    </div>
</div>

<div id="rightColumn">
    <h2>Alle categorieën</h2>
    <table>
        <tr>
            <th>Categorie</th>
            <th>Aantal advertenties</th>
        </tr>

        <c:forEach var="category" items="${categories}">
            <tr>
                <td><a href="category?${category.idcategory}">${category.name}</a></td>
                <td>${fn:length(category.advertisementCollection)}</td>
            </tr>
        </c:forEach>



    </table>
</div>
