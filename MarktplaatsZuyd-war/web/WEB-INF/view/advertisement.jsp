<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : advertisement
    Created on : 7-jun-2014, 17:20:58
    Author     : rick
--%>

<div id="leftColumn">
    <p>Gegevens van verkoper '${seller.username}'</p>
    <c:if test="${selectedAd.contactemail != null}">
        <p>e-mail: ${selectedAd.contactemail}</p>
    </c:if>
    <c:if test="${selectedAd.contactphone != null}">
        <p>tel: ${selectedAd.contactphone}</p>
    </c:if>
    <c:if test="${selectedAd.contactaddress != null}">
        <p>adres: ${selectedAd.contactaddress}</p>
    </c:if>
    <p>Biedingen</p>
    <ul>
    <c:forEach var="bidding" items="${selectedAd.biddingCollection}">
        <li>&#8364; ${bidding.amount}</li>
    </c:forEach>
    </ul>
    <c:if test="${user != null}">
        <form action="placeBidding" method="post">
            <input type="submit" value="Bod plaatsen">
        </form>
    </c:if>

</div>

<div id="rightColumn">
    <h2>${selectedAd.name}</h2>
    <p>${selectedAd.description}</p>
    <p>${selectedAd.price}</p>
</div>
