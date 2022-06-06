package day9.pkg2;

import day9.pkg1.A;

public class F extends A {
	void test () {
		F obj = new F();
		obj.emp_id = 101;// different package but inherits
		obj.name = "Su Su";
	}
}
