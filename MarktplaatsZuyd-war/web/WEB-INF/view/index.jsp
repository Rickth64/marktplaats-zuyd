<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%-- 
    Document   : index
    Created on : 8-jun-2014, 13:40:53
    Author     : rick
--%>

<div id="leftColumn">
    <div id="pageTextLeft">
        <p>Welkom bij Marktplaats Zuyd!</p>
        <p>Dit is dé plaats om allerlei spullen te kopen of te verkopen. Alle advertenties op deze website zijn voor iedereen toegankelijk.
            De recentst geplaatste advertenties zijn hiernaast te zien, met een maximum aantal advertenties van 10.</p>
        <p>Wilt u zelf een advertentie plaatsen of meebieden? Maak dan meteen een account aan!</p>
    </div>
</div>

<div id="rightColumn">
    <h2>${fn:length(recentAds)} recente advertenties</h2>
    <table>
        <tr>
            <th>Titel</th>
            <th>Prijs</th>
            <th>Categorie</th>
        </tr>
        <c:forEach var="recentAd" items="${recentAds}">
            <tr>
                <td><a href="advertisement?${recentAd.idadvertisement}">${recentAd.name}</a></td>

                <c:choose>
                    <c:when test="${recentAd.price == null}">
                        <td>niet opgegeven</td>
                    </c:when>
                    <c:otherwise>
                        <td>&#8364; ${recentAd.price}</td>
                    </c:otherwise>
                </c:choose>
                        
                <td><a href="category?${recentAd.categoryIdcategory.idcategory}">${recentAd.categoryIdcategory.name}</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
