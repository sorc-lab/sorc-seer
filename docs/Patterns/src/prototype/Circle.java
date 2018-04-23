package prototype;

public class Circle extends Shape
{
	public Circle() { type = "Cricle"; }
	
	@Override
	public void draw() {System.out.println("Inside Cricle::draw() method.");}
}
