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
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import ru.tilman.entity.Chamber;
import ru.tilman.entity.District;
import ru.tilman.entity.Region;
import ru.tilman.repository.ChamberRepository;
import ru.tilman.repository.DistrictRepository;
import ru.tilman.repository.RegionRepository;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.util.List;


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

    @RequestMapping(method = RequestMethod.GET)
    public String showChambersList(Model uiModel) {
        setModelChambersListAttributes(uiModel);
        return "chambers";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String showChamber(Model uiModel, @PathVariable("id") Long id) {
        Chamber chamber = chamberRepository.findById(id).get();
        uiModel.addAttribute(CHAMBER_ATTRIBUTE, chamber);
        return "/show";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getForm(Model uiModel) {
        uiModel.addAttribute(CHAMBER_ATTRIBUTE, new Chamber())
                .addAttribute(REGIONS_ATTRIBUTE, regionRepository.findAll());
        return "/add";
    }

    @RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
    public String getForm(Model uiModel, @PathVariable("id") Long id) {
        uiModel.addAttribute(CHAMBER_ATTRIBUTE, chamberRepository.findById(id).get())
                .addAttribute(REGIONS_ATTRIBUTE, regionRepository.findAll());
        return "/add";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String remove(Model uiModel, @PathVariable("id") Long id) {
        setModelChambersListAttributes(uiModel);
        chamberRepository.deleteById(id);
        return "redirect:/chambers";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String save(Model uiModel,
                       @Valid @ModelAttribute(CHAMBER_ATTRIBUTE) Chamber chamber,
                       @RequestParam("regionId") Long regionId,
                       BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute(CHAMBER_ATTRIBUTE, chamber)
                    .addAttribute(REGIONS_ATTRIBUTE, regionRepository.findAll());
            return "/add";
        }

        Region region = regionRepository.findById(regionId).get();
        District district = districtRepository.findById(region.getDistrict().getId()).get();
        region.setDistrict(district);
        chamber.setRegion(region);
        chamberRepository.save(chamber);

        setModelChambersListAttributes(uiModel);

        return "redirect:/chambers";
    }

    @RequestMapping(value = "/add/{id}", method = RequestMethod.POST)
    public String save(@Valid Chamber chamber,
                       BindingResult bindingResult,
                       Model uiModel,
                       @PathVariable("id") Long id) {

        if (bindingResult.hasErrors()) {
            uiModel.addAttribute(CHAMBER_ATTRIBUTE, chamber)
                    .addAttribute(REGIONS_ATTRIBUTE, regionRepository.findAll());
            return "/add";
        }

        chamberRepository.save(chamber);

        setModelChambersListAttributes(uiModel);

        return "redirect:/chambers";
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

    private void setModelChambersListAttributes(Model uiModel) {
        List<Chamber> chamberList = chamberRepository.findAllByOrderByIdAsc();
        uiModel.asMap().clear();
        uiModel.addAttribute(MESSAGE_ATTRIBUTE, String.format("Список палат (%s)", chamberList.size()));
        uiModel.addAttribute(CHAMBERS_ATTRIBUTE, chamberList);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {

        binder.registerCustomEditor(Region.class, "region", new PropertyEditorSupport(Region.class) {
            @Override
            public void setAsText(String s) throws IllegalArgumentException {
                if (!StringUtils.isEmpty(s)) {
                    setValue(regionRepository.findById(Long.parseLong(s)).get());
                }
            }
        });
    }

}
