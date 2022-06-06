package day4;

public class Math_api {
	public static void main(String[] args) {
		System.out.println("Absolute value of -7 " + Math.abs(-7));
		System.out.println("Result of 3 power 4 = " + Math.pow(3, 4));
		System.out.println("Square root of 49 = " + Math.sqrt(49));
		System.out.println("Randon value = "+ Math.random());
		System.out.println("Max value : " + Math.max(100, 300));
		System.out.println("Min value : " + Math.min(100, 0));
		
		//round
		System.out.println("Round(3.6) : " + Math.round(3.6));
		System.out.println("Floor (3.6) : "+ Math.floor(3.6));
		System.out.println("Ceil (3.2) : "+ Math.ceil(3.2));
		
		//log 
		System.out.println("Sin 30 : " + Math.sin(30));
		System.out.println("Log 30 : " + Math.log(30));
	}
}
