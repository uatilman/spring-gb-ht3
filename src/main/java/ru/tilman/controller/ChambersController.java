package ru.tilman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tilman.repository.ChamberRepository;

@Controller
@RequestMapping("/chambers")
public class ChambersController {

    public final static String MESSAGE_ATTRIBUTE = "message";
    public final static String CHAMBER_ATTRIBUTE = "chambers";

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

    @RequestMapping(value = "/{chamberName}", method = RequestMethod.GET)
    public String viewCompaniesList(Model uiModel, @PathVariable(value = "chamberName") String name) {

        uiModel.addAttribute(MESSAGE_ATTRIBUTE, ("Информация о палате " + name));
        uiModel.addAttribute(CHAMBER_ATTRIBUTE, chamberRepository.findByNameOrderByIdAsc(name));

        return "chambers";
    }

}
