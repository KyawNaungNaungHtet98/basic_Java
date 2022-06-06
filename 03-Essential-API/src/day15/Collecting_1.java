package day15;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Collecting_1 {
	public static void main(String[] args) {
		Student[] students = {
				new Student(10,"cherry","yangon"),
				new Student(2,"cherry","mandalay"),
				new Student(5,"khaing","monywa"),
				new Student(1,"htet","mandalay"),
				new Student(11,"htet yadana","yangon")
				};
		Set<String> hashSet = Arrays.stream(students).map(student-> student.getName()).collect(Collectors.toSet());
		System.out.println(hashSet);
		TreeSet<String> treeset = Arrays.stream(students).map(Student::getName).collect(Collectors.toCollection(TreeSet::new));
		System.out.println(treeset);
		Map<Integer, String> hashmap = Arrays.stream(students).collect(Collectors.toMap(Student::getRno, Student::getName));
		System.out.println(hashmap);
		Map<Integer,Student> hashmap1 = Arrays.stream(students).filter(s->!s.getCity().equalsIgnoreCase("yangon")).collect(Collectors.toMap(s->s.getRno(), s->s));
		System.out.println(hashmap1);
	}
}
class Student {
	private int rno;
	private String name;
	private String city;
	public Student(int rno, String name, String city) {
		super();
		this.rno = rno;
		this.name = name;
		this.city = city;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return " rno=" + rno + ", name=" + name + ", city=" + city ;
	}
	
	
}