package day13;

import java.util.ArrayList;

public class ArrayList_3 {
	public static void main(String[] args) {
		var list = new ArrayList<Phone>();
		Phone p = new Phone("Samsung", 170000);
		list.add(p);
		list.add(new Phone("Iphone", 200000));
		list.add(new Phone("vivo", 200000));
		System.out.println(list);

		System.out.println("---for each---");
		list.forEach(P -> System.out.println("Brand: " + P.brand + " , Price : " + P.price));

		// search
		System.out.println("----Price > 130000----");
		list.forEach(ph -> {
			if (ph.price > 130000) {
				System.out.println(ph);
			}
		});

		var phone = list.get(0);
		System.out.println("[0]: " + phone);
	}
}

class Phone {
	String brand;
	int price;

	Phone(String brand, int price) {
		this.brand = brand;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Phone [brand=" + brand + ", price=" + price + "]";
	}

}