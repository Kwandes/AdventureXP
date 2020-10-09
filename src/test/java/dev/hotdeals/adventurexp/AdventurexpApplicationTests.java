package dev.hotdeals.adventurexp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

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
    void findByIdTest() {

        //Get the activity from DB by id
        Activity testActivity = activityRepository.findById(1).get();

        //Make sure the id is 1
        assertThat(testActivity.getId()).isEqualTo(1);
    }

    @Test
    void findByAgeRestrictionTest() {
        //Get activity from DB by age restriction
        List<Activity> activityList = activityRepository.findAllByAgeRestriction(10);

        //Make sure the age restriction is 10 and there are 3 activities
        assertThat(activityList.size()).isEqualTo(3);
        assertThat(activityList.get(2).getAgeRestriction()).isEqualTo(10);
    }

}
