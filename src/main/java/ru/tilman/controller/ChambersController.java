package ru.tilman.controller;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.tilman.entity.Chamber;
import ru.tilman.repository.ChamberRepository;


@Controller
@RequestMapping("/chambers")
public class ChambersController {

    public final static String MESSAGE_ATTRIBUTE = "message";
    public final static String CHAMBER_ATTRIBUTE = "chambers";
    private final Logger logger = LoggerFactory.getLogger(ChambersController.class);

    private final ChamberRepository chamberRepository;

    @Autowired
    public ChambersController(
            @Qualifier("chamberRepository") ChamberRepository chamberRepository
    ) {
        this.chamberRepository = chamberRepository;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String viewBase(Model uiModel) {
        uiModel.addAttribute(MESSAGE_ATTRIBUTE, "Общий список палат");
        uiModel.addAttribute(CHAMBER_ATTRIBUTE, chamberRepository.findAllByOrderByIdAsc());
        return "chambers";
    }

    @RequestMapping(value = "/{chamberId}", method = RequestMethod.GET)
    public String viewCompaniesList(Model uiModel, @PathVariable(value = "chamberId") Long id) {

        uiModel.addAttribute(MESSAGE_ATTRIBUTE, ("Информация о палате " + id));
        uiModel.addAttribute(CHAMBER_ATTRIBUTE, chamberRepository.findById(id));
//        logger.info(name);
        return "chambers";
    }

    /**
     * http://localhost:8080/chambers/articles_ajax?pageCounter=0&number=1&order=DESC&orderBy=name&number=1
     * Метод обрабатывающий асинхронный запрос
     */
    @RequestMapping(
            value = "/articles_ajax",
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    /**
     * @param pageCounter-текущая страница(блок из number статей)
     * @param number - количество статей в одном блоке
     * @param order - порядок сортировки(ASC-прямая, DESC-обратная)
     * @param orderBy - поле по которому происходит сортировка
     * @return объект класса ChamberAjax, который содержит список статей,
     * данный объект преобразовывается в JSON-формат
     */
    public ChamberAjax listAjax(
            @RequestParam("pageCounter") Integer pageCounter,
            @RequestParam("number") Integer number,
            @RequestParam("order") String order,
            @RequestParam("orderBy") String orderBy) {

        //объект, который будет содержать информацию о сортировке
        Sort sort = null;

        if (order.equalsIgnoreCase("DESC")) {
            //конструктор Sort принимает в качестве параметров тип сортировки и поле,
            //по которому будет происходить соритровка
            sort = new Sort(Sort.Direction.DESC, orderBy);

        } else {
            sort = new Sort(Sort.Direction.ASC, orderBy);
        }
        //конструктор принимает полную информацию о текущем блоке,количестве статей и сортировке
        PageRequest pageable = new PageRequest(pageCounter, number, sort);

        Page<Chamber> chamberPage = chamberRepository.findAll(pageable);

        ChamberAjax responsive = new ChamberAjax();
        //из объекта Page возвращаем итератор и с помощью библиотеки google guava создаем списочный массив
        responsive.setChambers(Lists.newArrayList(chamberPage.iterator()));


        return responsive;

    }

}
