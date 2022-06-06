package day7;

import java.util.Scanner;

public class Exception_ass1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("How many array do u want to enter : ");
			int num = Integer.parseInt(sc.nextLine());
			String[] arr = new String[num];
			for (var i = 0; i < num; i++) {
				System.out.print("Enter value for array : ");
				String arr_value = sc.nextLine();
				arr[i] = arr_value;

			}
			int sum = 0;
			int max = 0;
			int min = Integer.parseInt(arr[0]);
			for (String a : arr) {
				int arr_int = Integer.parseInt(a);
				sum += arr_int;
				if (min > arr_int) {
					min = arr_int;
				}
				if (max < arr_int) {
					max = arr_int;
				}

			}
			float average = sum / arr.length;
			System.out.println(average);
			System.out.println("Max is  " + max);
			System.out.println("Min is " + min);

		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} finally {
			sc.close();
		}

	}// main close
}// class close
