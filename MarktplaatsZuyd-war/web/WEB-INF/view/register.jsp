<%-- 
    Document   : register
    Created on : 7-jun-2014, 17:21:30
    Author     : rick
--%>

<script>
function validateForm() {
    var username = document.forms["registrationForm"]["username"].value;
    if (username==null || username=="") {
        alert("Gebruikersnaam moet ingevuld worden.");
        return false;
    }
    
    var password = document.forms["registrationForm"]["password"].value;
    if (password==null || password=="") {
        alert("Wachtwoord moet ingevuld worden.");
        return false;
    }
    
    var firstName = document.forms["registrationForm"]["firstName"].value;
    if (firstName==null || firstName=="") {
        alert("Voornaam moet ingevuld worden.");
        return false;
    }
    
    var lastName = document.forms["registrationForm"]["lastName"].value;
    if (lastName==null || lastName=="") {
        alert("Achternaam moet ingevuld worden.");
        return false;
    }
    
    var email = document.forms["registrationForm"]["email"].value;
    var atpos = email.indexOf("@");
    var dotpos = email.lastIndexOf(".");
    if (atpos< 1 || dotpos<atpos+2 || dotpos+2>=x.length) {
        alert("Geen geldig e-mailadres.");
        return false;
    }
}
</script>

<div id="leftColumn">
    <div id="pageTextLeft">
        <p>U bevindt zich momenteel op onze registratiepagina. Vul hiernaast de gevraagde gegevens in en klik vervolgens op 'registeren' om zo snel mogelijk aan de slag te gaan!</p>
    </div>
</div>

<div id="rightColumn">
    <h2>Registreren</h2>

    <form name="registrationForm" action="doRegister" onsubmit="return validateForm()" method="post">  
        <table>
            <tr>
                <td>Gebruikersnaam:</td>
                <td><input type="text" name="username" maxlength="45"></td>
            </tr>
            <tr>
                <td>Wachtwoord:</td>
                <td><input type="password" name="password" maxlength="45"></td>  
            </tr>
            <tr>
                <td>Voornaam:</td>
                <td><input type="text" name="firstName" maxlength="45"></td>
            </tr>
            <tr>
                <td>Achternaam:</td>
                <td><input type="text" name="lastName" maxlength="45"></td>  
            </tr>
            <tr>
                <td>E-mailadres:</td>
                <td><input type="text" name="email" maxlength="45"></td>
            </tr>
        </table>
        <input type="submit" value="Registreren">
    </form> 
</div>
