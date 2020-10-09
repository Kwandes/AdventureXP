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
    void getAllUsersTest()
    {
    	//Create a list for Activities
    	List<Activity> activities = new ArrayList<>();
    	
    	//add everything that findAll gets from DB to activites List
		activities.addAll(activityRepository.findAll());
		
		//make sure that activites is exatly 5 entries long
		assertThat(activities.size()).isEqualTo(5);
		//assertEquals(5, activities.size());
    }
    
}
