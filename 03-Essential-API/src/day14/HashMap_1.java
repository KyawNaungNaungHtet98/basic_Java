package day14;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMap_1 {
	public static void main(String[] args) {
		Map<String,String> foods = new HashMap<>();
		foods.put("Orange", "Fruit");
		foods.put("Grape", "Fruit");
		
		var another1 = Map.of("Mango","Fruit","Potato","Vegetable");//cannot modify
		foods.putAll(another1);
		
		System.out.println(foods);
		
		var another2 = Map.ofEntries(
					Map.entry("Coffee", "Juice"),
					Map.entry("Lemon Tea", "Juice")
				);
		
		foods.putAll(another2);
		
		foods.forEach((k,v) -> System.out.println(k + " => " + v));
		
		foods.putIfAbsent("Kiwi", "Fruit");
		System.out.println("After new item : " + foods);
		
//		System.out.println("Contain Coffee 'Key' : " + foods.containsKey("Coffee"));
//		System.out.println("Contain Snack 'Value' : " + foods.containsValue("Snack"));
//		
//		Set<String> keys = foods.keySet();
//		System.out.println("All keys of foods : " + keys);
//		
//		Collection<String> value = foods.values();
//		System.out.println("All value of foods : " + value);
		
		//remove
//		foods.remove("Mango");
//		System.out.println("All keys" + foods.keySet());
//		
//		foods.keySet().removeIf(s-> s.contains("Tea"));
//		System.out.println("After remove : " + foods);
//		
//		foods.values().removeIf(v -> v.equalsIgnoreCase("Fruit"));
//		System.out.println("After remove with value : " + foods);
		
		//update
		foods.replace("Mango", "Pineapple");
		System.out.println("[Mango] " + foods.get("Mango"));// get specified key
		
		foods.compute("Coffee", (k,v)-> v.toUpperCase());// update if already key exist
		System.out.println("[Coffee] : " + foods.get("Coffee"));
		
		foods.compute("Cake", (k,v) -> "Snack");//put new if not exist key
		System.out.println(foods);
		
		foods.computeIfAbsent("Orange", k->"Juice");// no effect if already key exist
		System.out.println(foods);
		
		foods.computeIfAbsent("Banana", k->"Fruit");// put new if not exist key
		System.out.println(foods);
		
		foods.computeIfPresent("Orange", (k,v)-> "Juice");// update if key already exist
		System.out.println(foods);
		
		foods.computeIfPresent("Corn", (k,v)-> "Vegetable");// no effect if not exist key
		System.out.println("[Corn] :" + foods.get("Corn"));
	}
}
