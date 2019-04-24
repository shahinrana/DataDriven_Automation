package com.test.automation.UIAutomation.ruffwork;

public class InstanceControlFlow 
{
	// whenever we are executing java class first static control will be executed in the static control flow if we are creating an object the following sequence of events will execution as part instance control flow
	//1) Identification of instance member from top to bottom
	//2) Execution of instance variable assignment and instance blocks from top to bottom
	//3) Execution of constructor
	//Note:
	//1) Static control flow is one time activity which will be performed at time of class loading but instance control flow is not one time activity it will be performed every time when object is created
	//2) Object creation is most costly operation if there is no specific requirement then it is not recommended to create object. 
	// Parent to Child class flow
	int i=10;	
	{
		m1();
		System.out.println("First Instance Block...");
	}
	InstanceControlFlow()
	{
		System.out.println("InstanceControlFlow constructor calling...");
	}
	public static void main(String[] args) 
	{
		InstanceControlFlow i= new InstanceControlFlow();
		System.out.println("InstanceControlFlow Main calling...");
		//InstanceControlFlow i2= new InstanceControlFlow();
	}
	public void m1()
	{
		System.out.println(j);
	}
	{
		System.out.println("Second Instance method calling...");
	}
	int j=20;
}
