<%-- 
    Document   : changeAccount
    Created on : 20-jun-2014, 13:18:30
    Author     : rick
--%>

<div id="leftColumn">
    <div id="pageTextLeft">
        <p>Account beheren kan hiernaast :)</p>
    </div>
</div>

<div id="rightColumn">
    <h2>Accountbeheer - '${accountToChange.username}'</h2>

    <form action="doChangeAccount" method="post">  
        <input type="hidden" name="accountId" value="${accountToChange.idaccount}">
        <table>
            <tr>
                <td>Gebruikersnaam:</td>
                <td><input type="text" name="username" value="${accountToChange.username}" readonly></td>
            </tr>
            <tr>
                <td>Wachtwoord:</td>
                <td><input type="password" name="password"></td>  
            </tr>
                <tr>
                <td>Voornaam:</td>
                <td><input type="text" name="firstName" value="${accountToChange.firstName}"></td>
            </tr>
            <tr>
                <td>Achternaam:</td>
                <td><input type="text" name="lastName" value="${accountToChange.lastName}"></td>  
            </tr>
            <tr>
                <td>E-mailadres:</td>
                <td><input type="text" name="email" value="${accountToChange.emailAdress}"></td>
            </tr>
        </table>
            <button type="submit" name="action" value="update">Account wijzigen</button>
            <button type="submit" name="action" value="delete">Account verwijderen</button>
    </form> 
</div>

