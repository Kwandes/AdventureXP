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

@Controller
public class ActivitiesController {

	@Autowired
	ActivityRepository activityRepository;
	
    @RequestMapping(value = "/activities", method = {RequestMethod.GET, RequestMethod.POST})
    public String activities(Model model) {
    	List<Activity> activities = activityRepository.findAll();
        model.addAttribute("activities", activities);
    	return "activities/index";
    }
    
    @GetMapping("/getActivities")
    public ResponseEntity<List<Activity>>getAllActivitites(){
    	
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
	public String activityDetails(@PathVariable("id") int id, Model model){
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
	public String createNewActivity(@ModelAttribute Activity activity){
    	int id = activityRepository.save(activity).getId();
    	return "redirect:/activity/" + id;
	}

    
    
    //TODO - Show activities -> List of Activities (obj)
    
    //TODO - Redirect from selected activity to Details page of it.
    
    //TODO - Login button redirect

    //TODO - CRUD Activity (admin only)
}
