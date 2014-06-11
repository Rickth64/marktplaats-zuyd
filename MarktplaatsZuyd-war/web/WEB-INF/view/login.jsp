<%-- 
    Document   : login
    Created on : 7-jun-2014, 17:21:20
    Author     : rick
--%>

<div id="leftColumn">
    <div id="pageTextLeft">
        <p>Informatie over inloggen</p>
    </div>
</div>

<div id="rightColumn">
    <form action="j_security_check" method="post">  
        Name:<input type="text" id="j_username" name="j_username"><br>  
        Password:<input type="password" id="j_password" name="j_password"><br>  
        <input type="submit" value="login">  
    </form>  
</div>
