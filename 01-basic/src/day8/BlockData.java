package day8;

public class BlockData {
	static final int MIN_LENGTH;
	final int empId;
	String phone;
	public void Block_data(String phone) {
		System.out.println("This is constructor Block");
		if(phone.length() >= MIN_LENGTH) {
			this.phone = phone;
		}
	}
	//instance block
	{
		empId = 1;
		phone = "unknown";
		System.out.println("this is instance block");
	}
	
	//static block
	static {
		MIN_LENGTH = 9;
		System.out.println("This is static block");
	}
	public static void main(String[] args) {
		BlockData obj1 = new BlockData();
		obj1.Block_data("09799630371");
	}//main block
}//class block
