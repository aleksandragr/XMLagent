package com.travel.Agent.dto;

import java.util.List;

public class AccommodationDTO {



	

	


	public AccommodationDTO(long idAccommodation, String name, String type, String picture, String description,
			int rating, boolean free, int category, String reservedFrom, String reservedTo,
			List<String> aditionalServices, long idAdditionalS, boolean wiFi, boolean tv, boolean parking,
			boolean kitchen, boolean breakfast, boolean halfBoard, boolean fullBoard, boolean bathroom, long idLocation,
			String country, String city, String address, int onebeds, int twobeds, int theerebeds, int fourbeds,
			int fivebeds, long idAgent) {
		
		this.idAccommodation = idAccommodation;
		this.name = name;
		this.type = type;
		this.picture = picture;
		this.description = description;
		this.rating = rating;
		this.free = free;
		this.category = category;
		this.reservedFrom = reservedFrom;
		this.reservedTo = reservedTo;
		this.aditionalServices = aditionalServices;
		this.idAdditionalS = idAdditionalS;
		this.wiFi = wiFi;
		this.tv = tv;
		this.parking = parking;
		this.kitchen = kitchen;
		this.breakfast = breakfast;
		this.halfBoard = halfBoard;
		this.fullBoard = fullBoard;
		this.bathroom = bathroom;
		this.idLocation = idLocation;
		this.country = country;
		this.city = city;
		this.address = address;
		this.onebeds = onebeds;
		this.twobeds = twobeds;
		this.theerebeds = theerebeds;
		this.fourbeds = fourbeds;
		this.fivebeds = fivebeds;
		this.idAgent = idAgent;
	}

	public AccommodationDTO() {
		
	}
	
	

	/**
	 * 
	 * Accommodation fields
	 * 
	 */

    private long idAccommodation;
	
    private String name;
	
    private String type;
    
    private String picture;
	/*
    private Location location;
	
	private Agent agent;
	 */
	private String description;
	
	private int rating;
	
	private boolean free;
	
	//private AdditionalServices additionalServices;
	
	private int category;
	
	private String reservedFrom;
	
	private String reservedTo;
	

	
	/**
	 * 
	 * additionalServices fields
	 * 
	 */
	
	private List<String> aditionalServices;
	

	private long idAdditionalS;
	
	private boolean wiFi;
	
	private boolean tv;
	
	private boolean parking;
	
	private boolean kitchen;
	
	private boolean breakfast;
	
	private boolean halfBoard;
	
	private boolean fullBoard;
	
	private boolean bathroom;
	
	
	
	/**
	 * 
	 * Location fields 
	 * 
	 */
	
	private long idLocation;
	
	private String country;
	
	private String city;
	
	private String address;
	
	
	/**
	 * 
	 * Rooms fields
	 * 
	 */
	private int onebeds;
	
	private int twobeds;
	
	private int theerebeds;
	
	private int fourbeds;
	
	private int fivebeds;
	
	
	/**
	 * 
	 * Agent fields
	 * 
	 */
	private long idAgent;
	
	
	/**
	 * 
	 * constructors
	 */

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public boolean isFree() {
		return free;
	}

	public void setFree(boolean free) {
		this.free = free;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public long getIdAdditionalS() {
		return idAdditionalS;
	}

	public void setIdAdditionalS(long idAdditionalS) {
		this.idAdditionalS = idAdditionalS;
	}

	public boolean isWiFi() {
		return wiFi;
	}

	public void setWiFi(boolean wiFi) {
		this.wiFi = wiFi;
	}

	public boolean isTv() {
		return tv;
	}

	public void setTv(boolean tv) {
		this.tv = tv;
	}

	public boolean isParking() {
		return parking;
	}

	public void setParking(boolean parking) {
		this.parking = parking;
	}

	public boolean isKitchen() {
		return kitchen;
	}

	public void setKitchen(boolean kitchen) {
		this.kitchen = kitchen;
	}

	public boolean isBreakfast() {
		return breakfast;
	}

	public void setBreakfast(boolean breakfast) {
		this.breakfast = breakfast;
	}

	public boolean isHalfBoard() {
		return halfBoard;
	}

	public void setHalfBoard(boolean halfBoard) {
		this.halfBoard = halfBoard;
	}

	public boolean isFullBoard() {
		return fullBoard;
	}

	public void setFullBoard(boolean fullBoard) {
		this.fullBoard = fullBoard;
	}

	public boolean isBathroom() {
		return bathroom;
	}

	public void setBathroom(boolean bathroom) {
		this.bathroom = bathroom;
	}

	public long getIdLocation() {
		return idLocation;
	}

	public void setIdLocation(long idLocation) {
		this.idLocation = idLocation;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getIdAgent() {
		return idAgent;
	}

	public void setIdAgent(long idAgent) {
		this.idAgent = idAgent;
	}

	public int getOnebeds() {
		return onebeds;
	}

	public void setOnebeds(int onebeds) {
		this.onebeds = onebeds;
	}

	public int getTwobeds() {
		return twobeds;
	}

	public void setTwobeds(int twobeds) {
		this.twobeds = twobeds;
	}

	public int getTheerebeds() {
		return theerebeds;
	}

	public void setTheerebeds(int theerebeds) {
		this.theerebeds = theerebeds;
	}

	public int getFourbeds() {
		return fourbeds;
	}

	public void setFourbeds(int fourbeds) {
		this.fourbeds = fourbeds;
	}

	public int getFivebeds() {
		return fivebeds;
	}

	public void setFivebeds(int fivebeds) {
		this.fivebeds = fivebeds;
	}

	public long getIdAccommodation() {
		return idAccommodation;
	}

	public void setIdAccommodation(long id) {
		this.idAccommodation = id;
	}

	public String getReservedFrom() {
		return reservedFrom;
	}

	public void setReservedFrom(String reservedFrom) {
		this.reservedFrom = reservedFrom;
	}

	public String getReservedTo() {
		return reservedTo;
	}

	public void setReservedTo(String reservedTo) {
		this.reservedTo = reservedTo;
	}

	public List<String> getAditionalServices() {
		return aditionalServices;
	}

	public void setAditionalServices(List<String> aditionalServices) {
		this.aditionalServices = aditionalServices;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	
}

