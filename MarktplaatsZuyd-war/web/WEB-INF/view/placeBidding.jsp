<%-- 
    Document   : placeBidding
    Created on : 12-jun-2014, 20:44:33
    Author     : rick
--%>

<div id="leftColumn">
    <div id="pageTextLeft">
        <p>Bieden kan hiernaast :)</p>
    </div>
</div>

<div id="rightColumn">
    <h2>Bod plaatsen - ${selectedAd.name}</h2>

    <form action="doPlaceBidding" method="post"> 
        <input type="hidden" name="selectedAdId" value="${selectedAd.idadvertisement}">
        <table>
            <tr>
                <td>Bedrag (in &#8364;)</td>
                <td><input type="text" name="amount"></td>
            </tr>
        </table>
        <input type="submit" value="Bod plaatsen">
    </form>  
</div>
