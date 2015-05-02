package model;

import java.sql.Time;
import java.util.List;

public class Slot {
	private Time startTime;
	private List<Van> slotVans;

	
	public Slot(Time startTime) {
		super();
		this.startTime = startTime;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public List<Van> getSlotVans() {
		return slotVans;
	}

	public void setSlotVans(List<Van> slotVans) {
		this.slotVans = slotVans;
	}
	
	public void addVan(Van van){
		slotVans.add(van);
	}

}
