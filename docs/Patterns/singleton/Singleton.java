package singleton;

public class Singleton {
	private static Singleton _singleInstance = null;
	public String str;
	
	private Singleton() { str = "String type var, part of Singleton class."; }
	
	// static method to create isntance of Singleton class
	public static Singleton getInstance() {
		if (_singleInstance == null)
			_singleInstance = new Singleton();
		
		return _singleInstance;
	}
}
