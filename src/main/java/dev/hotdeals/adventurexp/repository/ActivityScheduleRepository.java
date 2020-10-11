package dev.hotdeals.adventurexp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.hotdeals.adventurexp.model.ActivitySchedule;

public interface ActivityScheduleRepository extends JpaRepository<ActivitySchedule, Integer>{
	
}
