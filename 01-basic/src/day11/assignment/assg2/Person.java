package day11.assignment.assg2;

public class Person {
	String name;
	String nrcno;
	String address;
	String phone;
	String[] division = { "AA", "BB", "CC", "DD", "EE", "FF", "GG", "HH", "II", "JJ", "KK", "LL", "MM", "NN" };

	public Person(String name, String nrcno, String address, String phone) {
		super();
		this.name = name;
		this.nrcno = nrcno;
		this.address = address;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNrcno() {
		return nrcno;
	}

	public void setNrcno(String nrcno) {
		this.nrcno = nrcno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	void showData() {
		System.out.format("Name : %s, Nrcno : %s, Address : %s, Phone : %s", getName(), getNrcno(), getAddress(),
				getPhone());
	}

	void showInfo() {
		int num1 = getNrcno().indexOf("/");
		int num2 = getNrcno().indexOf("(");
		int num3 = getNrcno().indexOf(")");
		String township = getNrcno().substring(num1 + 1, num2);
		String number = getNrcno().substring(num3 + 1);
		String station = getNrcno().substring(0, num1);
		int num4 = Integer.parseInt(station);
		System.out.println(division[num4 - 1]);
		System.out.println("Station : " + station);
		System.out.println("Township : " + township);
		System.out.println("Number : " + number);
	}
}// class block
