package com.test.automation.UIAutomation.ruffwork.collection;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Queue;
import java.util.PriorityQueue;
public class PriorityQueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue pq= new PriorityQueue();
		pq.add(156464);
		pq.add(244);
		pq.add(35545);
		pq.add(44);
		pq.add(554545);
		
		Iterator it= pq.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		System.out.println("*****************");
		Queue pq1= new ArrayDeque();
		pq1.add(156464);
		pq1.add(244);
		pq1.add(35545);
		pq1.add(44);
		pq1.add(554545);
		
		Iterator it1= pq1.iterator();
		while(it1.hasNext())
		{
			System.out.println(it1.next());
		}
		System.out.println("*****************");
		
		
	}

}
