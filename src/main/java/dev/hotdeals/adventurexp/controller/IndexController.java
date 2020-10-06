package dev.hotdeals.adventurexp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

import dev.hotdeals.adventurexp.model.Activity;


@Controller
public class IndexController {

    @RequestMapping(value = {"", "/", "/index", "/index/"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String index() {
        return "redirect:/activities";
    }
    

    
    
}
