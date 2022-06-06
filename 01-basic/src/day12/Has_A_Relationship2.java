package day12;

import java.time.LocalDate;

public class Has_A_Relationship2 {
	public static void main(String[] args) {
		SaleRecord[] records = new SaleRecord[3];
		Product p1 = new Product("Coffee", 1500);
		Product p2 = new Product("Drink", 1000);
		records[0] = new SaleRecord(1001, 2, p1);
		records[1] = new SaleRecord(1002, 2, p2);
		records[2] = new SaleRecord(1003, 1, p1);
		
		System.out.println("Code\t Sale Date\t Product\t Price\t Qty\t Total");
		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''");
		for(var sale:records) {
			sale.showdata();
		}
		
	}//main block
}//class block

class Product {
	String name;
	int price;

	Product(String name, int price) {
		this.name = name;
		this.price = price;

	}
}

class SaleRecord {
	int id;
	int sale_qty;
	LocalDate sale_date;
	Product product;

	SaleRecord(int id, int sale_qty, Product product) {
		this.id = id;
		this.sale_date = LocalDate.now();
		this.sale_qty = sale_qty;
		this.product = product;

	}

	void showdata() {
		System.out.print(id + "\t" + sale_date + "\t");
		System.out.print(product.name + "\t" + product.price + "ks.\t");
		System.out.print(sale_qty + "\t" + (sale_qty * product.price));
		System.out.println();

	}
}