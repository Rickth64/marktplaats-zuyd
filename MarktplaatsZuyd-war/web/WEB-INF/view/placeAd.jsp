<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 
    Document   : placeAd
    Created on : 12-jun-2014, 14:44:05
    Author     : rick
--%>

<div id="leftColumn">
    <div id="pageTextLeft">
        <p>U bevindt zich momenteel op de pagina waar u een advertentie kunt plaatsen.</p>
        <p>Vul hiernaast de gevraagd gegevens in. Van de persoonsgegevens is één van de drie velden verplicht. Na het invullen klikt u op 'advertentie plaatsen'.</p>
    </div>
</div>

<div id="rightColumn">
    <h2>Advertentie plaatsen</h2>

    <form action="doPlaceAd" method="post">  
        <table>
            <tr>
                <td>Advertentietitel:</td>
                <td><input type="text" name="adTitle"></td>  
            </tr>
            <tr>
                <td>Categorie:</td>
                <td>
                    <select name="selectedCategory">
                        <c:forEach var="category" items="${availableCategories}">
                            <option value="${category.idcategory}">${category.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Persoonsgegevens:</td>
                <td>Telefoonnummer:<br /><input type="test" name="phone"></td>
                <td>E-mailadres:<br /><input type="text" name="email"></td>
                <td>Huisadres:<br /><input type="text" name="home"</td>
            </tr>
            <tr>
                <td>Beschrijving:</td>
                <td><textarea name="description" style="width: 100%;height: 100px;max-width: 100%;max-height: 90px;"></textarea></td>
            </tr>
            <tr>
                <td>Prijs:</td>
                <td><input type="text" name="price"></td>
                <td></td>
                <td><input type="submit" value="Advertentie plaatsen"></td>
            </tr>
        </table>
    </form>  
</div>
