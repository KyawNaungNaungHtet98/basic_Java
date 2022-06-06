package day11;

public class MethodOverriding {
	public static void main(String[] args) {
		Developer d1 = new Developer();
		d1.work();

		d1 = new FrontEndDeveloper();
		d1.work();

		d1 = new BackEndDeveloper();
		d1.work();
	}
}

class Developer {
	void work() {
		System.out.println("Some Work");
	}
}

class FrontEndDeveloper extends Developer {

	@Override
	void work() {
		System.out.println("Doing work Frontend ");
	}

}

class BackEndDeveloper extends Developer {

	@Override
	void work() {
		System.out.println("Doing work Backend ");
	}

}
