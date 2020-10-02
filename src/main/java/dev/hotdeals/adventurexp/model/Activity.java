package dev.hotdeals.adventurexp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "activities")
public class Activity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="price")
	private double price;
	
	@Column(name="group_size")
	private String groupSize;
	
	//Google says java.sql.Timestamp corresponds to SQL DATETIME
	@Column(name="duration")
	private int duration;
	
	@Column(name="start_time")
	private String startTime;
	
	@Column(name="age_restriction")
	private int ageRestriction;
	
	@Column(name="height_restriction")
	private int heightRestrictionCm;
	
	@Column(name="full_description")
	private String fullDescription;


	
	public Activity(String name, String description, double price, String groupSize, int duration, String startTime,
			int ageRestriction, int heightRestrictionCm, String fullDescription) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.groupSize = groupSize;
		this.duration = duration;
		this.startTime = startTime;
		this.ageRestriction = ageRestriction;
		this.heightRestrictionCm = heightRestrictionCm;
		this.fullDescription = fullDescription;
	}

	
	//region getters and setters

	public Activity() {}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getGroupSize() {
		return groupSize;
	}


	public void setGroupSize(String groupSize) {
		this.groupSize = groupSize;
	}


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public String getStartTime() {
		return startTime;
	}


	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}


	public int getAgeRestriction() {
		return ageRestriction;
	}


	public void setAgeRestriction(int ageRestriction) {
		this.ageRestriction = ageRestriction;
	}


	public int getHeightRestrictionCm() {
		return heightRestrictionCm;
	}


	public void setHeightRestrictionCm(int heightRestrictionCm) {
		this.heightRestrictionCm = heightRestrictionCm;
	}


	public String getFullDescription() {
		return fullDescription;
	}


	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}


	public int getId() {
		return id;
	}

	
	
	
	//endregion
	
	
}
