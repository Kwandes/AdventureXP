package dev.hotdeals.adventurexp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;



@Embeddable
@Table(name = "activity_has_schedule")
public class ActivityHasScheduleId implements Serializable{
	
	
	@Column(name ="schedule_id")
	private int scheduleId;
	
	@Column(name ="activity_id")
	private int activityId;
	
	public ActivityHasScheduleId() {}
	
	
	public ActivityHasScheduleId(int scheduleId, int activityId) {
		super();
		this.scheduleId = scheduleId;
		this.activityId = activityId;
	}




	@Override
	public int hashCode() {
		return Objects.hash(activityId, scheduleId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ActivityHasScheduleId))
			return false;
		ActivityHasScheduleId other = (ActivityHasScheduleId) obj;
		return activityId == other.activityId && scheduleId == other.scheduleId;
	}


	//--------------------------------------------- GETTERS AND SETTERS --------------------------------------------
	public int getScheduleId() {
		return scheduleId;
	}


	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}


	public int getActivityId() {
		return activityId;
	}


	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
}
