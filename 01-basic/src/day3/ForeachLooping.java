package day3;

public class ForeachLooping {
	public static void main(String[] args) {
		String languages[]= {"Python","Java","Javascript"};
		System.out.println("---For looping---");
		//for looping
		for(var i = 0; i<languages.length;i++) {
			System.out.println(languages[i]);
		}
		System.out.println("---For each looping---");
		//for each
		for(var name:languages)
			System.out.println(name);
	}
}
