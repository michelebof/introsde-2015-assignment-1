package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.joda.time.DateTime;

@XmlRootElement(name="healthprofile")
@XmlType(propOrder = {"lastupdate", "weight", "height", "bmi" })
@XmlAccessorType(XmlAccessType.FIELD)
public class HealthProfile {
	private String lastupdate;
	private double weight; 
	private double height; 
	
	
	
	public HealthProfile(double weight, double height) {
		this.weight = weight;
		this.height = height;
		this.lastupdate= new DateTime().toString();
	}
	
	public HealthProfile() {
		this.weight = 70;
		this.height = 1.70;
		this.lastupdate= new DateTime().toString();
	}

	public String getLastupdate() {
		return lastupdate;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.lastupdate= new DateTime().toString();
		this.weight = weight;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.lastupdate= new DateTime().toString();
		this.height = height;
	}
	
	@XmlElement(name="bmi")
	// BMI = weight / (height^2)
	public double getBmi() {
		return this.weight/(Math.pow(this.height, 2));
	}
	
}
