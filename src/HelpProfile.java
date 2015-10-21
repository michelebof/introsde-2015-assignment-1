public class HelpProfile {
	private String firstname;
	private String lastname;
	private String birthdate;
	private double weight;
	private double height;
	private double bmi;
	
	
	
	public HelpProfile() {
	}
	
	public HelpProfile(String firstname, String lastname, String birthdate,
			double weight, double height, double bmi) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.weight = weight;
		this.height = height;
		this.bmi = bmi;
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
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getBmi() {
		return bmi;
	}
	public void setBmi(double bmi) {
		this.bmi = bmi;
	}
	@Override
	public String toString() {
		String ris = firstname + " " + lastname + " was born in " + birthdate + ", has a weight of "
				+ weight + " Kg, a height of " + height +" and a BMI of "+ bmi;
		return ris;
	}
	
	public String HealthProfiletoString() {
		String ris = firstname + " has a weight of "
				+ weight + " Kg, a height of " + height +" and a BMI of "+ bmi;
		return ris;
		
	}
	
	

}
