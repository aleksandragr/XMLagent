package com.travel.Agent.dto;



public class AccommodationDTO {

	public AccommodationDTO(long idAccommodation, String name, String type, String description, int rating,
			boolean free, int category, long idAdditionalS, boolean wiFi, boolean tv, boolean parking, boolean kitchen,
			boolean breakfast, boolean halfBoard, boolean fullBoard, boolean bathroom, long idLocation, String country,
			String city, String address, int twobads, int theerebads, int fourbads, int fivebads, long idAgent) {
		super();
		this.idAccommodation = idAccommodation;
		this.name = name;
		this.type = type;
		this.description = description;
		this.rating = rating;
		this.free = free;
		this.category = category;
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
		this.twobads = twobads;
		this.theerebads = theerebads;
		this.fourbads = fourbads;
		this.fivebads = fivebads;
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
	/*
    private Location location;
	
	private Agent agent;
	 */
	private String description;
	
	private int rating;
	
	private boolean free;
	
	//private AdditionalServices additionalServices;
	
	private int category;
	
	

	
	/**
	 * 
	 * additionalServices fields
	 * 
	 */

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
	private int twobads;
	
	private int theerebads;
	
	private int fourbads;
	
	private int fivebads;
	
	
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

	public long getIdAccommodation() {
		return idAccommodation;
	}

	public void setIdAccommodation(long idAccommodation) {
		this.idAccommodation = idAccommodation;
	}

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

	public int getTwobads() {
		return twobads;
	}

	public void setTwobads(int twobads) {
		this.twobads = twobads;
	}

	public int getTheerebads() {
		return theerebads;
	}

	public void setTheerebads(int theerebads) {
		this.theerebads = theerebads;
	}

	public int getFourbads() {
		return fourbads;
	}

	public void setFourbads(int fourbads) {
		this.fourbads = fourbads;
	}

	public int getFivebads() {
		return fivebads;
	}

	public void setFivebads(int fivebads) {
		this.fivebads = fivebads;
	}
}

