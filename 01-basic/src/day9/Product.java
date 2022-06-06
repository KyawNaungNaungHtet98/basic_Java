package day9;

public class Product {
	private int barCode;
	private String name;
	private float price;
	private String category;

	// setter
	void setBarCode(int a) {
		this.barCode = a;
	}

	void setName(String name) {
		this.name = name;
	}

	void setPrice(float price) {
		this.price = price;
	}

	void setCategory(String category) {
		this.category = category;
	}


	// getter
	int getBarCode() {
		return this.barCode;
	}

	String getName() {
		return this.name;
	}

	public float getPrice() {
		return price;
	}

	public String getCategory() {
		return category;
	}
}
