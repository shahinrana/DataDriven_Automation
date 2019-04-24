package com.test.automation.UIAutomation.ruffwork;

public class StatiControlFlow 
{
	//Note: 1.7 version onwards main method is mandatory to start program execution
	//hence from 1.7 ver onwards withou writing main method it is impossible to print statements to console
	//********************************************************************************************
	//1st way to call static block
/*	static 
	{
		System.out.println("static block calling...");
	}
	//2st way to call static method call
	static int x=m1();
	public static int m1()
	{
		System.out.println("m1 method calling...");
		System.exit(0);
		return 10;
	}*/
	//3rd way to call block 
	/*static StatiClass t=new StatiClass();
	{
		System.out.println("m2 method calling...");
		System.exit(0);
	}*/
	//4th way to call construction
	/*static StatiClass t=new StatiClass();
	StatiClass()
	{
		System.out.println("m3 method calling...");
		System.exit(0);
	}*/
	
	//********************************************************************************************
	//static control flow in parent to child relationship
	//1) Identification of static member from parent to child 
	//2) Execution of static variable assignment & static blocks from parent to child
	//3) Execution of child class main method

	static int i=10;
	static 
	{
		m1();
		System.out.println("Base static calling...");
	}
	public static void main(String[] args) {
		m1();
		System.out.println("Base main calling...");
	}
	public static void m1()
	{
	System.out.println(j);	
	}
	static int j=20;
}
class derived extends StatiControlFlow
{
	static int x=100;
	static 
	{
		m2();
		System.out.println("Derived class calling...");
	}
	public static void main(String[] args) {
		m2();
		System.out.println("Derived main calling...");
	}
	public static void m2()
	{
		System.out.println(y);
	}
	static
	{
		System.out.println("Derived second static block");
	}
	static int y=200;
	/*o/p: StatiClass class calling
	0
	Base static calling...
	20
	Base main calling...*/
	/*o/p: derived class calling
	0
	Base static calling...
	0
	Derived class calling...
	Derived second static block
	200
	Derived main calling...*/
	
	
}
