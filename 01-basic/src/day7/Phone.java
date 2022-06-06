package day7;

public class Phone {
	//Fields
	String brand;
	String color;
	int price;
	
	//constructor
	public Phone() {
		
	}	
	public Phone(String brand, String color, int price) {
		super();
		this.brand = brand;
		this.color = color;
		this.price = price;
	}


	//method
	void call() {
		System.out.println("Make Phone call");
	}
	void sendSMS() {
		System.out.println("send Message");
	}
	
}
