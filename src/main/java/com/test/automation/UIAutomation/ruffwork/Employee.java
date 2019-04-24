package com.test.automation.UIAutomation.ruffwork;

public class Employee 
{
	private String empName;
	private int empID;
	private String empDesignation;
	
	public void setDetails(String empname,int empID,String empDesignation )
	{
		this.empName=empname;
		this.empID=empID;
		this.empDesignation=empDesignation;
	}
	
	public void getDetais()
	{
		System.out.println(empID+"\t"+empName+"\t"+empDesignation);
	}
}
