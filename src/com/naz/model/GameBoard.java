package com.naz.model;

public class GameBoard {
	
	public GameBoard(String userName, String colour, String roomColour, int place) {
		super();
		this.userName = userName;
		this.colour = colour;
		this.roomColour = roomColour;
		this.place = place;
	}

	private String userName;
	
	private String colour;
	
	private String roomColour;
	
	private int place;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getRoomColour() {
		return roomColour;
	}

	public void setRoomColour(String roomColour) {
		this.roomColour = roomColour;
	}

	public int getPlace() {
		return place;
	}

	public void setPlace(int place) {
		this.place = place;
	}
	
	

}
