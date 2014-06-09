<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <ul>

        <c:forEach var="category" items="${categories}">
            <li><a href="category?${category.idcategory}">${category.name}</a></li>
        </c:forEach>



    </ul>
</div>
