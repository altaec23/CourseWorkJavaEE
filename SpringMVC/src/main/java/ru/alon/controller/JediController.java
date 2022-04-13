package ru.alon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.alon.dao.JediDao;
import ru.alon.model.Jedi;
import ru.alon.model.JediForm;

import java.util.List;

@Controller

public class JediController {
    @Autowired
    private JediDao jediDao;

    @RequestMapping(path = "/jedi", method = RequestMethod.GET)
    public ModelAndView getAllUsers() {
        List<Jedi> jedi = jediDao.findAllByJediName("ObiWan");
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("jedi");
        modelAndView.addObject("jediFromServer", jedi);
        return modelAndView;
    }

    @RequestMapping(path = "/jedi1", method = RequestMethod.GET)
    public ModelAndView getAllUsers2(@RequestParam(value = "first_name", required = false) String firstName) {
        List<Jedi> jedi = jediDao.findAllByJediName(firstName);
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("jedi");
        modelAndView.addObject("jediFromServer", jedi);
        return modelAndView;
    }

    @RequestMapping(path = "/jedi", method = RequestMethod.POST)
    public String addJedi(JediForm jediForm) {
        var jedi = Jedi.builder()
                .lastName(jediForm.getLastName())
                .firstName(jediForm.getFirstName()).build();
        jediDao.save(jedi);
        return "redirect:/jedi";

    }


}
