package com.test.automation.UIAutomation.ruffwork.collection;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.*;
import org.apache.commons.collections4.Get;
import org.sqlite.SQLiteConfig.SynchronousMode;

import com.gargoylesoftware.htmlunit.javascript.host.Iterator;

public class Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet hs=new HashSet();
		hs.add("yogesh");
		hs.add("yogesh");
		hs.add(1);
		hs.add(2);
		hs.add(2);
		
		System.out.println(hs);
		LinkedHashSet lhs=new LinkedHashSet();
		lhs.add("yogesh");
		lhs.add("yogesh");
		lhs.add(1);
		lhs.add(2);
		lhs.add(2);
		
		System.out.println(lhs);
		
		TreeSet ths=new TreeSet();
		ths.add("Gdgdg");
		ths.add("adfsf");
		ths.add("!@#$#$#$");
		ths.add("1");
		ths.add("yogesh");
		ths.add("solanki");
		/*ths.add(1);
		ths.add(2);
		ths.add(2);*/
		System.out.println(ths);
	}

}
