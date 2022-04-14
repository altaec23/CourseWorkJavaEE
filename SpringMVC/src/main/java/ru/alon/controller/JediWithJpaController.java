package ru.alon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.alon.model.Jedi;
import ru.alon.model.JediForm;

import ru.alon.service.JediService;

import java.util.List;

@Controller
public class JediWithJpaController {

    @Autowired
    private JediService jediService;

    @RequestMapping(path = "/jpa/jedi", method = RequestMethod.GET)
    public ModelAndView getAllUsers() {
        List<Jedi> jedi = null;
        jedi = jediService.findAll();

        var modelAndView = new ModelAndView();
        modelAndView.setViewName("jedi");
        modelAndView.addObject("jediFromServer", jedi);
        return modelAndView;
    }

    @RequestMapping(path = "/jpa/jedi", method = RequestMethod.POST)
    public String addJedi(JediForm jediForm) {
        var jedi = Jedi.builder()
                .lastName(jediForm.getLastName())
                .firstName(jediForm.getFirstName()).build();
        jediService.save(jedi);
        return "redirect:/jedi";

    }
}
