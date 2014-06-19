<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : changeAd
    Created on : 19-jun-2014, 17:07:31
    Author     : rick
--%>

<div id="leftColumn">
    <div id="pageTextLeft">
        <p>U bevindt zich momenteel op de pagina waar u een advertentie kunt beheren.</p>
        <p>Indien u de advertentie wenst te wijzigen vult hiernaast de gevraagde gegevens in. Van de persoonsgegevens is één van de drie velden verplicht. Na het invullen klikt u op 'advertentie wijzigen'.</p>
        <p>Voor het verwijderen van een advertentie klikt u op 'Advertentie verwijderen'.</p>
    </div>
</div>

<div id="rightColumn">
    <h2>Advertentie beheren - ${adToChange.name}</h2>

    <form action="doChangeAd" method="post">  
        <input type="hidden" name="adId" value="${adToChange.idadvertisement}">
        <table>
            <tr>
                <td>Advertentietitel:</td>
                <td><input type="text" name="adTitle" value="${adToChange.name}"></td>  
            </tr>
            <tr>
                <td>Categorie:</td>
                <td>
                    <select name="selectedCategory">
                        <c:forEach var="category" items="${availableCategories}">
                            <c:choose>
                                <c:when test="${category == adToChange.categoryIdcategory}">
                                    <option value="${category.idcategory}" selected>${category.name}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${category.idcategory}">${category.name}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Persoonsgegevens:</td>
                <td>Telefoonnummer:<br /><input type="test" name="phone" value="${adToChange.contactphone}"></td>
                <td>E-mailadres:<br /><input type="text" name="email" value="${adToChange.contactemail}"></td>
                <td>Huisadres:<br /><input type="text" name="home" value="${adToChange.contactaddress}"</td>
            </tr>
            <tr>
                <td>Beschrijving:</td>
                <td><textarea name="description" style="width: 100%;height: 100px;max-width: 100%;max-height: 90px;">${adToChange.description}</textarea></td>
            </tr>
            <tr>
                <td>Prijs:</td>
                <td><input type="text" name="price" value="${adToChange.price}"></td>
                <td><button type="submit" name="action" value="update">Advertentie wijzigen</button></td>
                <td><button type="submit" name="action" value="delete">Advertentie verwijderen</button></td>
            </tr>
        </table>
    </form>  
</div>
