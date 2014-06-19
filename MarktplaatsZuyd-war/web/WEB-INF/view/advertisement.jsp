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
                    <li>
                        <c:choose>
                            <c:when test="${bidding.accountIdaccount.username == pageContext.request.remoteUser || pageContext.request.isUserInRole('admin')}">
                                <p>&#8364; ${bidding.amount} <a href="changeBidding?${bidding.idbidding}">(wijzigen)</a><br />geboden door '${bidding.accountIdaccount.username}'</p>
                            </c:when>
                            <c:otherwise>
                                <p>&#8364; ${bidding.amount}<br />geboden door '${bidding.accountIdaccount.username}'</p>
                            </c:otherwise>
                        </c:choose>
                    </li>
                </c:forEach>
            </ul>
        </c:if>
        <c:if test="${pageContext.request.remoteUser != null && pageContext.request.remoteUser != selectedAd.accountIdaccount.username && !pageContext.request.isUserInRole('admin')}">
            <form action="placeBidding?${selectedAd.idadvertisement}" method="post">
                <input type="submit" value="Bod plaatsen">
            </form>
        </c:if>
        <c:if test="${pageContext.request.isUserInRole('admin') || pageContext.request.remoteUser == selectedAd.accountIdaccount.username}">
            <form action="changeAd?${selectedAd.idadvertisement}" method="post">
                <input type="submit" value="Advertentie beheren">
            </form>
        </c:if>
    </div>
</div>

<div id="rightColumn">
    <h2>${selectedAd.name}</h2>
    <p>${selectedAd.description}</p>
    <p>Vraagprijs: &#8364; ${selectedAd.price}</p>
</div>
