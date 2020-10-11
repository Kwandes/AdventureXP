package dev.hotdeals.adventurexp.model;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "activity_schedule")
public class ActivitySchedule {
	
	//id + time
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private int id;
	
	@NotNull
	@Column(name="time")
	private Time time;

	public ActivitySchedule() {}
	
	
	
	public Time getTime()
	{
		return time;
	}

	public void setTime(Time time)
	{
		this.time = time;
	}

	public int getId()
	{
		return id;
	}
	
	
	//activityHasSchedule
	//activity id + activity schedule 
	
	
}
