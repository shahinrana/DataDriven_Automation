package com.test.automation.UIAutomation.ruffwork.collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
public class Maptest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map map=new HashMap();  
		  map.put(1000,"Amit");  
		  map.put(105,"Vijay");  
		  map.put(102,"Rahul"); 
		  map.put(null,null);
		  map.put(103, "software");
		  
		  Set set = map.keySet();
		  Iterator it=set.iterator();
		  while(it.hasNext())
		  {
			  Object key = it.next();
			  System.out.println("key:"+key+"\tvalue:"+map.get(key)+"\t");
		  }
		  System.out.println();
		  System.out.println("LinkedHashMap");
			Map linkedmap=new  LinkedHashMap();  
			linkedmap.put(100,"Amit");  
			linkedmap.put(105,"Vijay");  
			linkedmap.put(102,"Rahul"); 
			linkedmap.put(null,null);
			linkedmap.put(103, "software");
			  
			  Set set1 = linkedmap.keySet();
			  Iterator it1=set1.iterator();
			  while(it1.hasNext())
			  {
				  Object key = it1.next();
				  System.out.println("key:"+key+"\tvalue:"+linkedmap.get(key)+"\t");
			  }
			  
			  System.out.println();
			  System.out.println("hashtable ");
				/*Map hashtablemap=new  Hashtable<>();  
				hashtablemap.put(100,"Amit");  
				hashtablemap.put(105,"Vijay");  
				hashtablemap.put(102,"Rahul"); 
				//hashtablemap.put(null,null);
				hashtablemap.put(103, "software");
				  
				  Set set2 = hashtablemap.keySet();
				  Iterator it2=set2.iterator();
				  while(it2.hasNext())
				  {
					  Object key = it2.next();
					  System.out.println("key:"+key+"\tvalue:"+linkedmap.get(key)+"\t");
				  }
				  
				  System.out.println();*/
	}

}
