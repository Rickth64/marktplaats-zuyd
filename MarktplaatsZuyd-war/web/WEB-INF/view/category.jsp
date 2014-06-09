<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : category
    Created on : 7-jun-2014, 17:20:29
    Author     : rick
--%>

<div id="leftColumn">
    
</div>

<div id="rightColumn">
    <h2>Advertenties in '${selectedCategory.name}'</h2>
    <table class="adsTable">
        <tr>
            <th>Titel</th>
            <th>Prijs</th>
        </tr>
        <c:forEach var="ad" items="${categoryAds}">
            <tr>
                <td><a href="advertisement?${ad.idadvertisement}">${ad.name}</a></td>

                <td>&#8364; ${ad.price}</td>
            </tr>
        </c:forEach>
    </table>
</div>
