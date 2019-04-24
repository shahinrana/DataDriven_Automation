package com.test.automation.UIAutomation.ruffwork;

import java.lang.reflect.Method;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Student {

	String name;
	int rollno;
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */

	public Student(String name, int rollno) {
		this.name = name;
		this.rollno = rollno;
	}

	public boolean equals(Object obj) 
	{
		if(obj==this)
			return true;
		if (obj instanceof Student) {
			Student s = (Student) obj;
			if (name.equals(s.name) && rollno == s.rollno) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	
	
	 

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	/*
	 * @Override
	 * 
	 * 
	 * 
	 * 
	 * @Override public int hashCode() { final int prime = 31; int result = 1;
	 * result = prime * result + ((name == null) ? 0 : name.hashCode()); result
	 * = prime * result + rollno; return result; }
	 * 
	 * public int hashCode() { return rollno; }
	 * 
	 * 
	 * 
	 * public String toString() { return rollno+"";
	 * 
	 * }
	 */
	public static void main(String[] args) {

		/*String s1="hello";  
		String s2="hello";  
		String s3="meklo";  
		String s4="hemlo";  
		String s5="flag";  
		String s6="12345";  
		System.out.println(s1.compareTo(s2));//0 because both are equal  
		System.out.println(s1.compareTo(s3));//-5 because "h" is 5 times lower than "m"  
		System.out.println(s1.compareTo(s4));//-1 because "l" is 1 times lower than "m"  
		System.out.println(s1.compareTo(s5));//2 because "h" is 2 times greater than "f"  
		System.out.println(s1.compareTo(s6));*/
		/*Student s1 = new Student("Durga", 101);
		Student s2 = new Student("Ravi", 102);
		Student s3 = new Student("Durga", 101);
		Student s4 = s1;
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s1.equals(s4));
		System.out.println(s1.equals(123));*/
		/*String s1=new String("durga");
		String s2=new String("durga");
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
		StringBuffer sb1=new StringBuffer("durga");
		StringBuffer sb2=new StringBuffer("durga");
		System.out.println("__________");

		System.out.println(sb1==sb2);
		System.out.println(sb1.equals(sb2));*/
		/*int count=0;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\yogeshsolanki\\Desktop\\Selenium Test Setup\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		Object o=new RemoteWebDriver();
		Class c=o.getClass();
		System.out.println("fully qualified name of class:"+c.getName());
		Method[] m=c.getDeclaredMethods();
		for(Method m1:m)
		{
			count++;
			System.out.println(m1.getName());
		}
		System.out.println("Total no:"+count);*/

	}

}
