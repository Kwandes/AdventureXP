package dev.hotdeals.adventurexp;

import dev.hotdeals.adventurexp.model.Activity;
import dev.hotdeals.adventurexp.model.ActivitySchedule;
import dev.hotdeals.adventurexp.repository.ActivityRepository;
import dev.hotdeals.adventurexp.repository.ActivityScheduleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AdventurexpApplicationTests {

	@Autowired
	ActivityRepository activityRepository;
	@Autowired
	ActivityScheduleRepository activityScheduleRepository;
	
    @Test
    void contextLoads() {
    }
    
    @Test
    void getAllActivitiesTest() {
    	//Create a list for Activities
    	List<Activity> activities = new ArrayList<>();
    	
    	//add everything that findAll gets from DB to activities List
		activities.addAll(activityRepository.findAll());
		
		//make sure that activities is exactly 5 entries long
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
        assertThat(activityList.getClass().isMemberClass());
        
    }
    
    @Test
    void checkThatActivityScheduleExists()
    {
    	ActivitySchedule testActivitySchedule = activityScheduleRepository.findById(1).get();
    	assertThat(testActivitySchedule.getId()).isEqualTo(1);
    }

    @Test
    void updateActivityDetailsTest(){
        Activity activity = activityRepository.findById(activityRepository.findAll().get(0).getId()).get();
        String name = "updated activity";
        activity.setName(name);
        String description = "is this working?";
        activity.setDescription(description);
        double price = 10.00;
        activity.setPrice(price);
        String groupSize = "10";
        activity.setGroupSize(groupSize);
        int duration = 30;
        activity.setDuration(duration);
        String startTime = "12.00";
        activity.setStartTime(startTime);
        int ageRestriction = 10;
        activity.setAgeRestriction(ageRestriction);
        int heightRestriction = 155;
        activity.setHeightRestrictionCm(heightRestriction);
        String fullDescription = "full description";
        activity.setFullDescription(fullDescription);

        Activity activity1 = activityRepository.save(activity);
        assertThat(activity.getName()).isEqualTo(activity1.getName());
        assertThat(activity.getDescription()).isEqualTo(activity1.getDescription());
        assertThat(activity.getPrice()).isEqualTo(activity1.getPrice());
        assertThat(activity.getGroupSize()).isEqualTo(activity1.getGroupSize());
        assertThat(activity.getDuration()).isEqualTo(activity1.getDuration());
        assertThat(activity.getStartTime()).isEqualTo(activity1.getStartTime());
        assertThat(activity.getAgeRestriction()).isEqualTo(activity1.getAgeRestriction());
        assertThat(activity.getHeightRestrictionCm()).isEqualTo(activity1.getHeightRestrictionCm());
        assertThat(activity.getFullDescription()).isEqualTo(activity1.getFullDescription());

    }

}
