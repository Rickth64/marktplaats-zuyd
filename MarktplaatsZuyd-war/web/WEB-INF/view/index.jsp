<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : index
    Created on : 8-jun-2014, 13:40:53
    Author     : rick
--%>

<%--
<sql:query var="recentads" dataSource="jdbc/marktplaatszuyd">
    (SELECT idadvertisement, price, category.name AS categoryname, advertisement.name AS adname
    FROM category, advertisement
    WHERE category.idcategory = advertisement.category_idcategory
    ORDER BY idadvertisement DESC LIMIT 10)
    ORDER BY idadvertisement ASC;
</sql:query>--%>

<div id="indexLeftColumn">
    <div id="pageTextLeft">
        <p>Welkom bij Marktplaats Zuyd!</p>
        <p>Dit is dé plaats om allerlei spullen te kopen of te verkopen. Alle advertenties op deze website zijn voor iedereen toegankelijk.
        De recentst geplaatste advertenties zijn hiernaast te zien, met een maximum aantal advertenties van 10.</p>
        <p>Wilt u zelf een advertentie plaatsen of meebieden? Maak dan meteen een account aan!</p>
    </div>
</div>

<div id="indexRightColumn" style="overflow-y: scroll">
    <h2> recente advertenties</h2>
    <!--<table id="recentAdvertisementsTable">-->
    <ul>

        <c:forEach var="recentad" items="${recentads}">
            <%--<c:choose>
                <c:when test="${recentad.price == null}">
                    <li><a href="advertisement?${recentad.idadvertisement}">${recentad.adname}</a> - GEEN PRIJS OPGEGEVEN (in ${recentad.categoryname})</li>
                    </c:when>
                    <c:otherwise>
                    <li><a href="advertisement?${recentad.idadvertisement}">${recentad.adname}</a> - &#8364; ${recentad.price} (in ${recentad.categoryname})</li>
                    </c:otherwise>
                </c:choose>--%>
            <li>${recentad.name}</li>
            </c:forEach>



    </ul>
    <!--</table>-->
</div>
</div>
</body>
</html>
