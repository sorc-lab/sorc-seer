package singleton;

public class Main {
	public static void main(String[] args) {
		// instantiating Singleton class w/ var x
		Singleton x = Singleton.getInstance();
		
		// instantiating Singleton class w/ var y
		Singleton y = Singleton.getInstance();
		
		// instantiating Singleton class w/ var z
		Singleton z = Singleton.getInstance();
		
		// changing var of instance x
		x.str = (x.str).toUpperCase();
		
		System.out.println("String from x is " + x.str);
		System.out.println("String from y is " + y.str);
		System.out.println("String from z is " + z.str);
		System.out.println("\n");
		
		// changing var of instance z
		z.str = (z.str).toLowerCase();
		
		System.out.println("String from x is " + x.str);
		System.out.println("String from y is " + y.str);
		System.out.println("String from z is " + z.str);
		
		// output:
		//		String from x is STRING TYPE VAR, PART OF SINGLETON CLASS.
		//		String from y is STRING TYPE VAR, PART OF SINGLETON CLASS.
		//		String from z is STRING TYPE VAR, PART OF SINGLETON CLASS.
		//
		//
		//		String from x is string type var, part of singleton class.
		//		String from y is string type var, part of singleton class.
		//		String from z is string type var, part of singleton class.
	}
}
