package day7;

public class Throwing {
	static void checkMark(int mark) {
		if(mark<0 || mark>100) {
			ArithmeticException e = new ArithmeticException("Invail mark");
			throw e;
		}
	}
	public static void main(String[] args) {
		try {
			checkMark(-1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
//		try {
//			int[] num = {100,200,300};
//			int index = 5;
//			if(index >= num.length) {
//				throw new ArrayIndexOutOfBoundsException("Out of Range");
//			}
//			System.out.println(num[index]);
//		} catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println(e.getMessage());
//		}
	}
}
