package com.example.Assignment.controllers;

import com.example.Assignment.dao.EventRepo;
import com.example.Assignment.services.util.CommonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController{
    private final EventRepo eventRepo;

    public MainController(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }


    @GetMapping({"/","/home"})
    public ModelAndView home(){
        ModelAndView modelWithViewObject =  new ModelAndView("home");
        modelWithViewObject.addObject("isEventCreated", "");
        modelWithViewObject.addObject("isEventDeleted","");
        modelWithViewObject.addObject("eventTypeList", CommonService.generateEventTypeList());
        modelWithViewObject.addObject("eventList", eventRepo.findAll());
        return modelWithViewObject;
    }
}
