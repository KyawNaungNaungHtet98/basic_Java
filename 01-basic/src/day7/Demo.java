package day7;

public class Demo {
	public static void main(String[] args) {
		Phone p1 = new Phone("iphone", "pink" , 180000);
		Phone p2 = new Phone("Samsung" , "purple" , 380000);
		Phone p3 = new Phone("Vivo" , "Black" , 100000);
		
		System.out.println("---Phone 1 Data---");
		System.out.println("Brand : " + p1.brand + " , color : " + p1.color + " , price : " + p1.price);
		p1.call();
		p1.sendSMS();
		System.out.println("---Phone 2 Data---");
		System.out.format("Brand %s, color : %s , Price : %d\n", p2.brand,p2.color,p2.price);
		p2.call();
		p1.sendSMS();
		System.out.println("---Phone 3 Data---");
		System.out.format("Brand %s, color : %s , Price : %d\n", p3.brand,p3.color,p3.price);
	}
}
