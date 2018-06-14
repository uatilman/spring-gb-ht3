//Шаблон для размещения описания статьи в списке
var articleBody =

    "<span class='article__category'></span>";

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
function renderingArticles(articles) {

    articles.forEach(function (chamber) {

        var test = $(articleBody)
            // .find(".article__title").attr("href", contextPath + "/articles/" + chamber["id"]).html(chamber["name"]).end()
            // .find(".article__date").html(chamber["publishedDate"]).end()
            // .find(".article__author").html(chamber["author"]["firstname"]).end()
            // .find(".article__content").html(chamber["content"].substring(0, 110) + "...").end()
            .find(".article__category").html(chamber["name"].name)
            // .end()
            // .find(".more").attr("href", contextPath + "/articles/" + chamber["id"])
            .end().appendTo("#templatemo_content");

    });
}

//функция для осуществления асинхронного GET запроса
function loadArticles() {

    //формирование строки с данными, которые необходимо передать на сервер в метод listAjax
    var data = "pageCounter=" + pageCounter + "&" + "order=" + order + "&" + "orderBy=" + orderBy + "&" + "number=" + number;
    alert('before ajax');

    $.ajax({
        url: url,
        type: 'GET',
        data: data,
        cache: false,
        success: function (articlesResponsive) {

            if (articlesResponsive !== 0) {
                alert('data not null');
                //если ответ содержит данные, то они размещаются на странице
                //а счетчик страниц(блоков) увеличивается на единицу
                renderingArticles(articlesResponsive["articles"]);
                pageCounter++;
            } else {
                alert('data null');

            }
        },
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