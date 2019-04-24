package com.test.automation.UIAutomation.ruffwork;

 class Bank {
	 static double getRateOfInterest() {
		return 0;
	}
}

 class SBI extends Bank {
	 static double getRateOfInterest() {
		return 8.5;
	}
}

 class ICICI extends Bank {
	 static double getRateOfInterest() {
		return 7.5;
	}
}

 class AXIS extends Bank {
	static double getRateOfInterest() {
		return 9.5;
	}
}

 class MethodOverLoading2 {
	public static void main(String args[]) 
	{
		System.out.println("With the object of the class");
		SBI s = new SBI();
		ICICI i = new ICICI();
		AXIS a = new AXIS();
		System.out.println("SBI Rate of Interest: " + s.getRateOfInterest());
		System.out.println("ICICI Rate of Interest: " + i.getRateOfInterest());
		System.out.println("AXIS Rate of Interest: " + a.getRateOfInterest());
		System.out.println("\nWith the Static of the class");
		System.out.println("SBI Rate of Interest: " + SBI.getRateOfInterest());
		System.out.println("ICICI Rate of Interest: " + ICICI.getRateOfInterest());
		System.out.println("AXIS Rate of Interest: " + AXIS.getRateOfInterest());
	
	}
}
