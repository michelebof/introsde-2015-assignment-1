package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.joda.time.DateTime;

 
@XmlRootElement(name = "person")	
@XmlType(propOrder = { "firstname", "lastname", "birthdate", "healthprofile" })
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {
	private String firstname;		
	private String lastname;		
	
	@XmlElement(name="healthprofile")
	private HealthProfile healthprofile;	
	
	@XmlAttribute(name="id")
	private String personId;
	private String birthdate;
	
	
	public Person(String firstname, String lastname, HealthProfile healthprofile,
			String birthdate, String personId) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.healthprofile = healthprofile;
		this.birthdate = birthdate;
		this.personId = personId;
	}
	
	public Person(){
		this.firstname="X";
		this.lastname="Y";
		this.healthprofile=new HealthProfile();

		// setting personId to a random number between 1 and 9999 and convert in String
		this.personId = Math.round(Math.floor(Math.random()*9998)+1)+""; 
		this.birthdate = (new DateTime(1990, 1, 1, 12, 0, 0, 0)).toString();
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public HealthProfile getHealthprofile() {
		return healthprofile;
	}

	public void setHealthprofile(HealthProfile healthprofile) {
		this.healthprofile = healthprofile;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	@Override
	public String toString() {
		HealthProfile hp=this.healthprofile;
		return "Person: " + this.firstname + " born "
		          + this.birthdate +", has a weight of " + hp.getWeight() + 
		          " Kg, a height of " + hp.getHeight() + " and a BMI of "+ hp.getBmi();
	}

	
}