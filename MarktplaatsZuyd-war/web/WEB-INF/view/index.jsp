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

<div id="leftColumn">
    <div id="pageTextLeft">
        <p>Welkom bij Marktplaats Zuyd!</p>
        <p>Dit is dé plaats om allerlei spullen te kopen of te verkopen. Alle advertenties op deze website zijn voor iedereen toegankelijk.
            De recentst geplaatste advertenties zijn hiernaast te zien, met een maximum aantal advertenties van 10.</p>
        <p>Wilt u zelf een advertentie plaatsen of meebieden? Maak dan meteen een account aan!</p>
    </div>
</div>

<div id="rightColumn">
    <h2>${recentAdsCount} recente advertenties</h2>
    <table class="adsTable">
        <tr>
            <th>Titel</th>
            <th>Prijs</th>
            <th>Categorie</th>
        </tr>
        <c:forEach var="recentAd" items="${recentAds}">
            <tr>
                <td><a href="advertisement?${recentAd.idadvertisement}">${recentAd.name}</a></td>

                <td>&#8364; ${recentAd.price}</td>

                <td>${recentAd.categoryIdcategory.name}</td>
            </tr>
        </c:forEach>
    </table>
</div>
