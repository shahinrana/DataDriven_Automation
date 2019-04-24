package com.test.automation.UIAutomation.ruffwork.collection;

import java.util.Hashtable;

import org.eclipse.jetty.http.Http1FieldPreEncoder;

public class HashTableExample {

	public static void main(String[] args) {
		Hashtable<String,String> ht = new Hashtable<String,String>();
		ht.put("Course1", "selenium");
		ht.put("Course2", "java");
		Hashtable<String,String> ht1 = new Hashtable<String,String>();
		ht1.put("Location1", "Aus");
		ht1.put("Locatiion2", "India");
		
		Hashtable<String,Hashtable<String,String>> ht2= new Hashtable<String,Hashtable<String,String>>();
		ht2.put("Institute", ht);
		ht2.put("Country", ht1);

		
		System.out.println(ht2.get("Institute").get("Course1"));
		
	}

}
