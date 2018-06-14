//Шаблон для размещения описания статьи в списке
var articleBody =
    "<div class='chamber'>"
    + " Id: "
    + "<span class='chamber_id'></span>"
    + " Палата: "
    + "<span class='chamber_name'></span>"
    + "</div>";

//данные, которые передаются на сервер
//количество страниц
var number = 4;
//порядок сортировки
var order = "DESC";
//поле для сортировки
var orderBy = "name";
//счетчик страниц(блоков)
var pageCounter = 0;

//функция для размещения полученных данных на странице
function renderingArticles(chambers) {
    var count = 1;
    chambers.forEach(function (chamber) {
        var chName = chamber["id"];

        var test = $(articleBody)
            .find(".chamber_id").html(chamber["id"])
            .end()
            .find(".chamber_name").html(chamber["name"])
            .end()
            .appendTo("#templatemo_content");
        count++;

    });
}

//функция для осуществления асинхронного GET запроса
function loadArticles() {

    //формирование строки с данными, которые необходимо передать на сервер в метод listAjax
    var data = "pageCounter=" + pageCounter + "&" + "order=" + order + "&" + "orderBy=" + orderBy + "&" + "number=" + number;

    $.ajax({
        url: url,
        type: 'GET',
        data: data,
        cache: false,
        success: function (articlesResponsive) {

            if (articlesResponsive !== 0) {
                //если ответ содержит данные, то они размещаются на странице
                //а счетчик страниц(блоков) увеличивается на единицу
                renderingArticles(articlesResponsive["chambers"]);
                pageCounter++;
            }
        }
    });
}

$(document).ready(function () {
    //первая страница(блок) статей подгружается при загрузке страницы
    loadArticles();

    $(".btn_load").click(function () {

        //остальные страницы подгружаются при нажатии на кнопку "Загрузить еще"
        loadArticles();

    })
});