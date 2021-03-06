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
import javax.xml.bind.annotation.XmlType;




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
 *         &lt;element name="Rating" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element ref="{http://www.travel.com/reguser}RegUser"/&gt;
 *         &lt;element ref="{http://www.travel.com/comment}Comment"/&gt;
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
    "rating",
    "regUser",
    "comment",
    "accommodation"
})
@XmlRootElement(name = "Review", namespace = "http://www.travel.com/review")
@Entity
public class Review {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @XmlElement(name = "Id", namespace = "http://www.travel.com/review")
    protected long id;
	
	@Column
    @XmlElement(name = "Rating", namespace = "http://www.travel.com/review", defaultValue = "5")
    protected int rating;
	
	@OneToOne
    @XmlElement(name = "RegUser", namespace = "http://www.travel.com/reguser", required = true)
    protected RegUser regUser;
	
	@OneToOne
    @XmlElement(name = "Comment", namespace = "http://www.travel.com/comment", required = true)
    protected Comment comment;
	
	@ManyToOne
	@XmlElement(name = "Accommodation", required = true)
    protected Accommodation accommodation;
	
	
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
     * Gets the value of the rating property.
     * 
     */
    public int getRating() {
        return rating;
    }

    /**
     * Sets the value of the rating property.
     * 
     */
    public void setRating(int value) {
        this.rating = value;
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
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link Comment }
     *     
     */
    public Comment getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Comment }
     *     
     */
    public void setComment(Comment value) {
        this.comment = value;
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
    
  
}
