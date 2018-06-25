function renderingChambers(chambers) {
    var count = 1;
    chambers.forEach(function (chamber) {
        var chamberHref = contextPath + "/chambers/" + chamber["id"];

        var test = $(chamberBody)
            .find(".id-column").html(chamber["id"]).end()
            .find(".name-column").html(chamber["name"]).end()
            .find(".region-name-column").html(chamber["region"]["name"]).end()
            .find(".district-name-column").html(chamber["region"]["district"]["name"]).end();

        $(test).attr("data-href", chamberHref);
        $(test).appendTo(".chamber-table");

        count++;

    });
}

function setRowClickListener() {
    $(".click-row").click(function () {
        window.location = $(this).data("href");
        return false;
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
                setRowClickListener();
                pageCounter++;
            }
        }
    });
}


$(document).ready(
    function () {
        loadChambers();

        $(window).scroll(function () {
            if ($(window).scrollTop() === $(document).height() - $(window).height()) {
                loadChambers();
            }
        });
    }
);



