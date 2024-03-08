package com.example.Assignment.controllers;


import com.example.Assignment.dao.EventRepo;
import com.example.Assignment.models.Event;
import com.example.Assignment.services.util.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventManagementController {
    @Autowired
    private EventRepo eventRepo;
    private final ModelAndView modelWithViewObject = new ModelAndView("home");

    @SuppressWarnings("null")
    @GetMapping("/createEvent")
    public ModelAndView createEvent(Event event){
        try{
            this.eventRepo.save(event);
            this.modelWithViewObject.addObject("isEventCreated","true");
        }
        catch(Exception exception){
            this.modelWithViewObject.addObject("isEventCreated","false");
        }

        this.modelWithViewObject.addObject("isEventDeleted","");
        this.modelWithViewObject.addObject("eventTypeList", CommonService.generateEventTypeList());
        this.modelWithViewObject.addObject("eventList", eventRepo.findAll());
        return this.modelWithViewObject;
    }

    @SuppressWarnings("null")
    @GetMapping("/deleteEvent")
    public ModelAndView deleteEvent(@RequestParam(value = "name", defaultValue = "")String name){
        try{
            this.eventRepo.deleteById(name);
            this.modelWithViewObject.addObject("isEventDeleted","true");
        }
        catch(Exception exception){
            this.modelWithViewObject.addObject("isEventDeleted","false");
        }

        this.modelWithViewObject.addObject("isEventCreated","");
        this.modelWithViewObject.addObject("eventTypeList", CommonService.generateEventTypeList());
        this.modelWithViewObject.addObject("eventList", eventRepo.findAll());

        return this.modelWithViewObject;
    }
}
