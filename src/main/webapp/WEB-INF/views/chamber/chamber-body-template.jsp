<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page session="false" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>

<script>
    var chamberBody =
        "                    <tr>" +
        "                        <td class='id-column'></td>" +
        "                        <td class='name-column'></td>" +
        "                        <td class='region-name-column'></td>" +
        "                        <td class='district-name-column'></td>" +
        "                        <td class='edit-column'>" +
        "<a class='edit-chamber-href' href=''>Edit>></a><br>" +
        "<a class='show-chamber-href' href=''>Show>></a><br>" +
        "<a class='remove-chamber-href' href=''>Remove>></a></td>" +
        "                    </tr>";
    var number = 20;
    var order = "ASC";
    var orderBy = "name";
    var pageCounter = 0;
</script>