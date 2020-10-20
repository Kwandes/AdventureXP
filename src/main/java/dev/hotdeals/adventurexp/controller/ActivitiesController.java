package dev.hotdeals.adventurexp.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import dev.hotdeals.adventurexp.model.Activity;
import dev.hotdeals.adventurexp.repository.ActivityRepository;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

@Controller
public class ActivitiesController {

    @Autowired
    ActivityRepository activityRepository;

    @RequestMapping(value = "/activities", method = {RequestMethod.GET, RequestMethod.POST})
    public String activities(Model model, HttpServletRequest request) {

        if (request.getSession().getAttribute("isLoggedIn") != null) {
            model.addAttribute("isLoggedIn", true);
        }

        List<Activity> activities = activityRepository.findAll();
        model.addAttribute("activities", activities);
        return "activities/index";
    }

    @GetMapping("/getActivities")
    public ResponseEntity<List<Activity>> getAllActivitites() {

        //grabs all data of Activities from the DB and returns them into an ArrayList
        try {
            List<Activity> activities = new ArrayList<>();
            activities.addAll(activityRepository.findAll());
            return new ResponseEntity<>(activities, HttpStatus.OK);
        } catch (Exception e) {
            //In the event of an issue grabbing data return this error
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
    }


    //NEW CODE FOR ACTIVITY DETAILS HTML
    @GetMapping("/activity/{id}")
    public String activityDetails(@PathVariable("id") int id, Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("isLoggedIn") != null) {
            model.addAttribute("isLoggedIn", true);
        }

        Activity activity = activityRepository.findById(id).get();
        model.addAttribute("activity", activity);
        return "activities/activityDetails";
    }

    @GetMapping("/createNewActivity")
    public String createNewActivity(Model model) {
        model.addAttribute("activity", new Activity());
        return "activities/createNewActivity";
    }

    @PostMapping("/createNewActivity")
    public String createNewActivity(@ModelAttribute Activity activity) {
        int id = activityRepository.save(activity).getId();
        return "redirect:/activity/" + id;
    }

    @GetMapping("/deleteActivity/{id}")
    public String deleteActivity(@PathVariable String id, HttpServletRequest request, Model model) {

        if (request.getSession().getAttribute("isLoggedIn") == null) {
            return "redirect:/index";
        }

        try {

            //set the int id to the correct ID
            int idInt = Integer.parseInt(id);
            //get the required object to delete
            activityRepository.deleteById(idInt);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return "/ShitsFuckedYo";
        }

        return "redirect:/index";
    }

    @GetMapping("/updateActivity/{id}")
    public String updateActivity(@PathVariable int id, HttpServletRequest request, Model model) {
        if (request.getSession().getAttribute("isLoggedIn") == null) {
            return "redirect:/index";
        }

        Activity activity = activityRepository.findById(id).get();
        model.addAttribute("activity", activity);
        model.addAttribute("isUpdate", true);
        return "activities/createNewActivity";
    }

    @PostMapping("/updateActivity")
    public String updateActivity(@ModelAttribute Activity activity) {
        activityRepository.save(activity);
        return "redirect:/activity/" + activity.getId();
    }

    //TODO - Show activities -> List of Activities (obj)

    //TODO - Redirect from selected activity to Details page of it.

    @GetMapping("/login")
    public String login() {
        return "activities/login";
    }

    @PostMapping("/submitLogin")
    public String submitLogin(HttpServletRequest request, Model model) {
        request.getSession().setAttribute("isLoggedIn", true);
        model.addAttribute("isLoggedIn", true);
        return "redirect:/index";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/index";
    }

    //TODO - CRUD Activity< (admin only)
}
