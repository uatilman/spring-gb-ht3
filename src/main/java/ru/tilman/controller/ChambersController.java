package ru.tilman.controller;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.tilman.entity.Chamber;
import ru.tilman.entity.District;
import ru.tilman.entity.Region;
import ru.tilman.repository.ChamberRepository;
import ru.tilman.repository.DistrictRepository;
import ru.tilman.repository.RegionRepository;


@Controller
@RequestMapping("/chambers")
public class ChambersController {

    public final static String MESSAGE_ATTRIBUTE = "message";
    public final static String CHAMBERS_ATTRIBUTE = "chambers";
    public final static String CHAMBER_ATTRIBUTE = "chamber";
    public final static String REGIONS_ATTRIBUTE = "regions";
    private final Logger logger = LoggerFactory.getLogger(ChambersController.class);

    private final ChamberRepository chamberRepository;
    private final RegionRepository regionRepository;
    private DistrictRepository districtRepository;

    @Autowired
    public ChambersController(
            @Qualifier("chamberRepository") ChamberRepository chamberRepository,
            @Qualifier("regionRepository") RegionRepository regionRepository,
            @Qualifier("districtRepository") DistrictRepository districtRepository
    ) {
        this.chamberRepository = chamberRepository;
        this.regionRepository = regionRepository;
        this.districtRepository = districtRepository;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getForm(Model uiModel) {
        Chamber chamber = new Chamber();
        uiModel.addAttribute(CHAMBER_ATTRIBUTE, chamber)
                .addAttribute(REGIONS_ATTRIBUTE, regionRepository.findAll());
        return "/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String save(Chamber chamber, BindingResult bindingResult, @RequestParam("regionId") Long regionId) {
        // TODO: 15.06.18 Вынести часть логики на сервис уровень
        if (!bindingResult.hasErrors()) {
            chamber.setRegion(regionRepository.findById(regionId).get());
            // TODO: 15.06.18 проблемы со структурой данных или структурой классов
            try {
                chamberRepository.save(chamber);
            } catch (Exception e) {
                return "/add";
            }
        }
        return "redirect:/chambers/{" + chamber.getId() + "}";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String viewBase(Model uiModel) {
        uiModel.addAttribute(MESSAGE_ATTRIBUTE, "Общий список палат");
        uiModel.addAttribute(CHAMBERS_ATTRIBUTE, chamberRepository.findAllByOrderByIdAsc());
        return "chambers";
    }

    @RequestMapping(value = "/{chamberId}", method = RequestMethod.GET)
    public String viewCompaniesList(Model uiModel, @PathVariable(value = "chamberId") Long id) {
        uiModel.addAttribute(MESSAGE_ATTRIBUTE, ("Информация о палате " + id));
        uiModel.addAttribute(CHAMBERS_ATTRIBUTE, chamberRepository.findById(id));
        logger.info(id.toString());
        return "chambers";
    }

    @ResponseBody
    @RequestMapping(
            value = "/articles_ajax",
            method = RequestMethod.GET,
            produces = "application/json")
    public ChamberAjax listAjax(
            @RequestParam("pageCounter") Integer pageCounter,
            @RequestParam("number") Integer number,
            @RequestParam("order") String order,
            @RequestParam("orderBy") String orderBy) {

        Sort sort = null;

        if (order.equalsIgnoreCase("DESC")) {
            sort = new Sort(Sort.Direction.DESC, orderBy);
        } else {
            sort = new Sort(Sort.Direction.ASC, orderBy);
        }

        PageRequest pageable = new PageRequest(pageCounter, number, sort);
        Page<Chamber> chamberPage = chamberRepository.findAll(pageable);
        ChamberAjax responsive = new ChamberAjax();
        responsive.setChambers(Lists.newArrayList(chamberPage.iterator()));
        return responsive;
    }

}
