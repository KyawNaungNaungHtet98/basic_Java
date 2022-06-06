package day4;

public class TwoD_array {
	public static void main(String[] args) {
		String[] name = {"Jeon","Yuri","Cherry"};
		int[][] marks = {
				{65, 73, 86, 84,59},
				{71, 80, 90, 69,95},
				{75, 75, 99, 96, 99}
		};
		
		int row = marks.length;//no of row
		int col = marks[0].length;//no of column
		for(var r = 0; r<row; r++) {
			int total = 0;
			for(var c = 0; c < col; c++) {
				total += marks[r][c];
			}
			System.out.println("Total marks of Student - "+ name[r] + " is " + total);
			System.out.println("Average mark - "+ (float)total/5);
		}
	}
}
