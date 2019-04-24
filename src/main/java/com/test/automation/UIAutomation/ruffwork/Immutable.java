package com.test.automation.UIAutomation.ruffwork;

import java.lang.reflect.*;

public final class Immutable {

	private int i;
	public Immutable(int i)
	{
		this.i=i;
	}
	public Immutable modify(int i)
	{
		if(this.i==i)
		{
			return this;
		}
		else
		{
			return (new Immutable(i));
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		
		/*Immutable i= new Immutable(10);
		System.out.println(i.i);
		Immutable i2= i.modify(100);
		System.out.println(i2.i);
		Immutable i3= i.modify(10);		
		System.out.println(i==i2);
		System.out.println(i==i3);*/
		int count=0;
		Class c=Class.forName("java.lang.Object");
		Method[] m=c.getDeclaredMethods();
		for(Method m1:m)
		{
			count++;
			System.out.println(m1.getName());
		}
		System.out.println(count++);
		/*Object o;
		StringBuffer sb=new StringBuffer();
		sb.append("abc").append(12).append("india is great country").insert(2, "testing").reverse().delete(2, 5);
		System.out.println(sb);*/
		
	}

}

