package prototype;

import java.util.Hashtable;

public class ShapeCache
{
	private static Hashtable<String, Shape>
		shapeMap = new Hashtable<String, Shape>();
	
	public static Shape getShape(String shapeId)
	{
		Shape cachedShape = shapeMap.get(shapeId);
		return (Shape) cachedShape.clone();
	}
	
	// for each shape run DB query and create shape
	// shapeMap.put(shapeKey, shape);
	// e.g., we are adding 3 shapes
	
	public static void loadCache() // should be named 'populateCache'?
	{
		Circle circle = new Circle();
		circle.setId("1");
		shapeMap.put(circle.getId(), circle);
		
		Square square = new Square();
		square.setId("2");
		shapeMap.put(square.getId(), square);
		
		Rectangle rectangle = new Rectangle();
		rectangle.setId("3");
		shapeMap.put(rectangle.getId(), rectangle);
	}
}
