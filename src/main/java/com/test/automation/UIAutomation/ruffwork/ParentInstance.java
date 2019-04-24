package com.test.automation.UIAutomation.ruffwork;

import org.apache.poi.poifs.property.Child;

public class ParentInstance {

	//1) Identification of instance member from parent to child
	//2) Execution of instance variable assignments and instance blocks only in parent class
	//3) Execution of parent construction 
	//4) Execution of Execution variable assignments and instance blocks in child class
	//5) Execution of child constructions
	
	int i=10;	
	{
		m1();
		System.out.println("Parent Instance Block...");
	}
	ParentInstance()
	{
		System.out.println("Parent Instance constructor calling...");
	}
	public static void main(String[] args) 
	{
		//ParentInstance i= new ParentInstance();
		System.out.println("Parent Instance Main calling...");
		//ParentInstance i2= new ParentInstance();
	}
	public void m1()
	{
		System.out.println(j);
	}
	int j=20;
	
}
class child extends ParentInstance
{
	int i=10;	
	{
		m2();
		System.out.println("Child Instance Block...");
	}
	child()
	{
		System.out.println("Child Instance constructor calling...");
	}
	public static void main(String[] args) 
	{
		child i= new child();
		System.out.println("child Instance Main calling...");
		//ParentInstance i2= new ParentInstance();
	}
	public void m2()
	{
		System.out.println(y);
	}
	{
		System.out.println("Child 2nd Instance Block...");
	}
	int y=200;
}
