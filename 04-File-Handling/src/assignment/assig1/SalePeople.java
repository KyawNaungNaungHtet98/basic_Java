package assignment.assig1;

public class SalePeople {
	private String name;
	private String city;
	private double commision;
	public SalePeople(String name, String city, double commision) {
		super();
		this.name = name;
		this.city = city;
		this.commision = commision;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getCommision() {
		return commision;
	}
	public void setCommision(double commision) {
		this.commision = commision;
	}
	@Override
	public String toString() {
		return "SalePeople [name=" + name + ", city=" + city + ", commision=" + commision + "]";
	}
	
	
}
