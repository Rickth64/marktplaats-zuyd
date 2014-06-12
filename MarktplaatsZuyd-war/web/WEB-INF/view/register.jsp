<%-- 
    Document   : register
    Created on : 7-jun-2014, 17:21:30
    Author     : rick
--%>

<div id="leftColumn">
    <div id="pageTextLeft">
        <p>U bevindt zich momenteel op onze registratiepagina. Vul hiernaast de gevraagde gegevens in en klik vervolgens op 'registeren' om zo snel mogelijk aan de slag te gaan!</p>
    </div>
</div>

<div id="rightColumn">
    <h2>Inloggen</h2>

    <form action="doRegister" method="post">  
        <table>
            <tr>
                <td>Gebruikersnaam:</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>Wachtwoord:</td>
                <td><input type="password" name="password"></td>  
            </tr>
            <tr>
                <td>Voornaam:</td>
                <td><input type="text" name="firstName"></td>
            </tr>
            <tr>
                <td>Achternaam:</td>
                <td><input type="text" name="lastName"></td>  
            </tr>
            <tr>
                <td>E-mailadres:</td>
                <td><input type="text" name="email"></td>
            </tr>
        </table>
        <input type="submit" value="Registreren">
    </form> 
</div>
