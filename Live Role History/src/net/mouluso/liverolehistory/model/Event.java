package net.mouluso.liverolehistory.model;

import android.location.Location;

public class Event {
	private int id;
	private String name;
	private String description;
	private int order;
	private Action action;
	private Treasure treasure;
	private Location location;
	
	public Event(int id, String name, String description, int order,
			Action action, Treasure treasure, Location location) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.order = order;
		this.action = action;
		this.treasure = treasure;
		this.location = location;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public Action getAction() {
		return action;
	}
	public void setAction(Action action) {
		this.action = action;
	}
	public Treasure getTreasure() {
		return treasure;
	}
	public void setTreasure(Treasure treasure) {
		this.treasure = treasure;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	
	
}
