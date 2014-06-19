<%-- 
    Document   : changeBidding
    Created on : 19-jun-2014, 18:31:18
    Author     : rick
--%>

<div id="leftColumn">
    <div id="pageTextLeft">
        <p>Bod wijzigen kan hiernaast :)</p>
    </div>
</div>

<div id="rightColumn">
    <h2>Bod wijzigen</h2>

    <form action="doChangeBidding" method="post"> 
        <input type="hidden" name="biddingId" value="${biddingToChange.idbidding}">
        <table>
            <tr>
                <td>Bedrag (in &#8364;)</td>
                <td><input type="text" name="amount" value="${biddingToChange.amount}"></td>
            </tr>
        </table>
        <button type="submit" name="action" value="update">Bod wijzigen</button>
        <button type="submit" name="action" value="delete">Bod verwijderen</button>
    </form>  
</div>


