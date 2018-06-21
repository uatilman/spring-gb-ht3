

function renderingChambers(chambers) {
    var count = 1;
    chambers.forEach(function (chamber) {
        var test = $(chamberBody)
            .find(".id-column").html(chamber["id"]).end()
            .find(".name-column").html(chamber["name"]).end()
            .find(".region-name-column").html(chamber["region"]["name"]).end()
            .find(".district-name-column").html(chamber["region"]["district"]["name"]).end()
            .find(".edit-chamber-href").attr("href", contextPath + "/chambers/add/" + chamber["id"]).end()
            .find(".show-chamber-href").attr("href", contextPath + "/chambers/" + chamber["id"]).end()
            .find(".remove-chamber-href").attr("href", contextPath + "/chambers/remove/" + chamber["id"]).end()
            .appendTo(".chamber-table");
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