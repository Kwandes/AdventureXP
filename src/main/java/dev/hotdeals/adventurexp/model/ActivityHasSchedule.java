package dev.hotdeals.adventurexp.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ActivityHasSchedule {
	
	@EmbeddedId
	private ActivityHasScheduleId activityHasScheduleId;
	
	public ActivityHasSchedule() {
	}

	public ActivityHasScheduleId getActivityHasScheduleId() {
		return activityHasScheduleId;
	}

	public void setActivityHasScheduleId(ActivityHasScheduleId activityHasScheduleId) {
		this.activityHasScheduleId = activityHasScheduleId;
	}
	
}
