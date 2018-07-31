package ru.tilman.controller.faces;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.tilman.entity.Chamber;
import ru.tilman.repository.ChamberRepository;

import java.util.List;

@Component
@Scope("session")
public class ChambersBean {

/*    private final ChamberRepository chamberRepository;

    @Autowired
    public ChambersBean(ChamberRepository chamberRepository) {
        this.chamberRepository = chamberRepository;
    }*/

    public String print() {
        return "test la-lal-la-la-la-la";
    }
/*    public List<Chamber> getChamberList() {
        System.out.println("getlist");
        return Lists.newArrayList(chamberRepository.findAll());
    }*/

}
