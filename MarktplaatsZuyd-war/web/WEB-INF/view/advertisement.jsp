<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%-- 
    Document   : advertisement
    Created on : 7-jun-2014, 17:20:58
    Author     : rick
--%>

<div id="leftColumn">
    <div id="pageTextLeft">
        <b>Gegevens van verkoper '${selectedAd.accountIdaccount.username}'</b>
        <c:if test="${selectedAd.contactemail != ''}">
            <p>e-mail: ${selectedAd.contactemail}</p>
        </c:if>
        <c:if test="${selectedAd.contactphone != ''}">
            <p>tel: ${selectedAd.contactphone}</p>
        </c:if>
        <c:if test="${selectedAd.contactaddress != ''}">
            <p>adres: ${selectedAd.contactaddress}</p>
        </c:if>
        <c:if test="${fn:length(selectedAd.biddingCollection) > 0}">
            <b>Biedingen</b>
            <ul>
                <c:forEach var="bidding" items="${selectedAd.biddingCollection}">
                    <li>&#8364; ${bidding.amount}</li>
                    </c:forEach>
            </ul>
        </c:if>
        <c:if test="${user != null}">
            <form action="placeBidding?${selectedAd.idadvertisement}" method="post">
                <input type="submit" value="Bod plaatsen">
            </form>
        </c:if>
    </div>
</div>

<div id="rightColumn">
    <h2>${selectedAd.name}</h2>
    <p>${selectedAd.description}</p>
    <p>Vraagprijs: &#8364; ${selectedAd.price}</p>
</div>
