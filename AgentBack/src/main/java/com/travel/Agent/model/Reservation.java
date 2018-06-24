//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.06 at 07:30:19 PM CEST 
//


package com.travel.Agent.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import org.hibernate.annotations.Cascade;





/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="Price" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Surname" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element ref="{http://www.travel.com/accommodation}Accommodation"/&gt;
 *         &lt;element ref="{http://www.travel.com/reguser}RegUser"/&gt;
 *         &lt;element name="RoomType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Accepted" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="Deleted" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "price",
    "startDate",
    "endDate",
    "name",
    "surname",
    "email",
    "accommodation",
    "regUser",
    "roomType",
    "accepted",
    "deleted"
})
@XmlRootElement(name = "Reservation", namespace = "http://www.travel.com/reservation")
@Entity
public class Reservation {

	 @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @XmlElement(name = "Id", namespace = "http://www.travel.com/reservation")
    protected long id;
    @XmlElement(name = "Price", namespace = "http://www.travel.com/reservation", defaultValue = "0")
    protected int price;
    @XmlElement(name = "StartDate", namespace = "http://www.travel.com/reservation", required = true)
    protected String startDate;
    @XmlElement(name = "EndDate", namespace = "http://www.travel.com/reservation", required = true)
    protected String endDate;
    @XmlElement(name = "Name", namespace = "http://www.travel.com/reservation", required = true)
    protected String name;
    @XmlElement(name = "Surname", namespace = "http://www.travel.com/reservation", required = true)
    protected String surname;
    @XmlElement(name = "Email", namespace = "http://www.travel.com/reservation", required = true)
    protected String email;
    protected String nameAccommodation;
    @ManyToOne
    @XmlElement(name = "Accommodation", required = true)
    protected Accommodation accommodation;
    
    @ManyToOne
    @XmlElement(name = "RegUser", namespace = "http://www.travel.com/reguser", required = true)
    protected RegUser regUser;
    
    @XmlElement(name = "RoomType", namespace = "http://www.travel.com/reservation", required = true)
    protected String roomType;
    @XmlElement(name = "Accepted", namespace = "http://www.travel.com/reservation")
    protected boolean accepted;
    @XmlElement(name = "Deleted", namespace = "http://www.travel.com/reservation")
    protected boolean deleted;

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the price property.
     * 
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     */
    public void setPrice(int value) {
        this.price = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDate(String value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDate(String value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the surname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the value of the surname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSurname(String value) {
        this.surname = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the accommodation property.
     * 
     * @return
     *     possible object is
     *     {@link Accommodation }
     *     
     */
    public Accommodation getAccommodation() {
        return accommodation;
    }

    /**
     * Sets the value of the accommodation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Accommodation }
     *     
     */
    public void setAccommodation(Accommodation value) {
        this.accommodation = value;
    }

    /**
     * Gets the value of the regUser property.
     * 
     * @return
     *     possible object is
     *     {@link RegUser }
     *     
     */
    public RegUser getRegUser() {
        return regUser;
    }

    /**
     * Sets the value of the regUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegUser }
     *     
     */
    public void setRegUser(RegUser value) {
        this.regUser = value;
    }

    /**
     * Gets the value of the roomType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomType() {
        return roomType;
    }

    /**
     * Sets the value of the roomType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomType(String value) {
        this.roomType = value;
    }

    /**
     * Gets the value of the accepted property.
     * 
     */
    public boolean isAccepted() {
        return accepted;
    }

    /**
     * Sets the value of the accepted property.
     * 
     */
    public void setAccepted(boolean value) {
        this.accepted = value;
    }

    /**
     * Gets the value of the deleted property.
     * 
     */
    public boolean isDeleted() {
        return deleted;
    }

    /**
     * Sets the value of the deleted property.
     * 
     */
    public void setDeleted(boolean value) {
        this.deleted = value;
    }

	public String getNameAccommodation() {
		return nameAccommodation;
	}

	public void setNameAccommodation(String nameAccommodation) {
		this.nameAccommodation = nameAccommodation;
	}

}
