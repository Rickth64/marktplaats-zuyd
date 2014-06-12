<%-- 
    Document   : login
    Created on : 7-jun-2014, 17:21:20
    Author     : rick
--%>

<div id="leftColumn">
    <div id="pageTextLeft">
        <p>U bevindt zich momenteel op onze inlogpagina. Vul hiernaast uw gebruikersnaam en wachtwoord in en klik vervolgens op 'inloggen'.</p>
        <p>Nog geen account? Klik dan rechtsboven op 'registreren' om een account aan te maken.</p>
    </div>
</div>

<div id="rightColumn">
    <h2>Inloggen</h2>

    <form action="j_security_check" method="post">  
        <table>
            <tr>
                <td>Gebruikersnaam:</td>
                <td><input type="text" id="j_username" name="j_username"></td>
            </tr>
            <tr>
                <td>Wachtwoord:</td>
                <td><input type="password" id="j_password" name="j_password"></td>  
            </tr>
        </table>
        <input type="submit" value="Inloggen">
    </form>  
</div>
