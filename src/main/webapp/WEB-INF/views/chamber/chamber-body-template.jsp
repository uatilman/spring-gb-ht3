<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page session="true" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>

<script>
    var chamberBody =
        "                    <tr class='click-row' data-href=''>" +
        "                        <td class='id-column'></td>" +
        "                        <td class='name-column'></td>" +
        "                        <td class='region-name-column'></td>" +
        "                        <td class='district-name-column'></td>" +
        "                    </tr>";
    var number = 20;
    var order = "ASC";
    var orderBy = "name";
    var pageCounter = 0;
</script>