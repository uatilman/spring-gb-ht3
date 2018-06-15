//Шаблон для размещения описания статьи в списке
var chamberBody =
    "                    <tr>" +
    "                        <td class='id-column'></td>" +
    "                        <td class='name-column'></td>" +
    "                        <td class='region-name-column'></td>" +
    "                        <td class='district-name-column'></td>" +
    "                    </tr>";
var number = 20;
var order = "ASC";
var orderBy = "name";
var pageCounter = 0;

function renderingChambers(chambers) {
    var count = 1;
    chambers.forEach(function (chamber) {
        var test = $(chamberBody)
            .find(".id-column").html(chamber["id"]).end()
            .find(".name-column").html(chamber["name"]).end()
            .find(".region-name-column").html(chamber["region"]["name"]).end()
            .find(".district-name-column").html(chamber["region"]["district"]["name"]).end()
            .appendTo("#chamber-table");
        count++;

    });
}

function loadChambers() {
    var data = "pageCounter=" + pageCounter + "&" + "order=" + order + "&" + "orderBy=" + orderBy + "&" + "number=" + number;

    $.ajax({
        url: url,
        type: 'GET',
        data: data,
        cache: false,
        success: function (chambersResponsive) {
            if (chambersResponsive !== 0) {
                renderingChambers(chambersResponsive["chambers"]);
                pageCounter++;
            }
        }
    });
}

$(document).ready(function () {
    loadChambers();
    $(window).scroll(function () {
        if ($(window).scrollTop() === $(document).height() - $(window).height()) {
            loadChambers();
        }
    });
});