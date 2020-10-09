package dev.hotdeals.adventurexp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dev.hotdeals.adventurexp.model.Activity;
import dev.hotdeals.adventurexp.repository.ActivityRepository;

@SpringBootTest
class AdventurexpApplicationTests {

	@Autowired
	ActivityRepository activityRepository;
	
    @Test
    void contextLoads() {
    }
    
    @Test
    void getAllActivitiesTest() {
    	//Create a list for Activities
    	List<Activity> activities = new ArrayList<>();
    	
    	//add everything that findAll gets from DB to activites List
		activities.addAll(activityRepository.findAll());
		
		//make sure that activites is excatly 5 entries long
		assertThat(activities.size()).isEqualTo(5);
		//assertEquals(5, activities.size());
    }

    @Test
    void findByIdTest1() {

        //Get the activity from DB
        Activity testActivity = activityRepository.findById(1).get();

        //Make sure the id is 1
        assertThat(testActivity.getId()).isEqualTo(1);
    }
}
