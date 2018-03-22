import java.awt.Point;
import java.awt.Rectangle;

public class PointRectangle
{
	public static void main(String[] args)
	{
		Point point_1 = new Point(3, 4);
		Point point_2 = new Point(4, 4);
		double distance = distance(point_1, point_2);
		System.out.printf("Distance b/t p1 & p2: %.2f\n", distance);
		
		// parms. x, y, width, height
		Rectangle box = new Rectangle(0, 0, 100, 200);

		Point center = findCenter(box); // obj.
		System.out.println(box);
		System.out.println(center);
		
		moveRect(box, 50, 100); // or Java's box.translate(50, 100)
		System.out.println(box);
	}

	public static double distance(Point p1, Point p2)
	{
		int dx = p2.x - p1.x;
		int dy = p2.y - p1.y;
		return Math.sqrt(dx * dx + dy * dy);
	}

	public static Point findCenter(Rectangle box)
	{
		int x = box.x + box.width / 2;
		int y = box.y + box.height / 2;
		return new Point(x,y);
	}
	
	/**
	 * Mutates state of Rectangle object--moves Rectangle w/o changing its size
	 */
	public static void moveRect(Rectangle box, int dx, int dy)
	{
		box.x = box.x + dx;
		box.y = box.y + dy;
	}
}
