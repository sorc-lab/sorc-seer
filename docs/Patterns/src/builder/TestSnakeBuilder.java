package builder;

// TODO: Convert to:
// 		https://dzone.com/articles/design-patterns-the-builder-pattern
public class TestSnakeBuilder
{
	public static void main(String[] args)
	{
		String[] snakeLoot = {"test1", "test2"};
		
		Snake snake = new SnakeBuilder("A Snake")
			.setHp(350)
			.setMovementSpeed(150)
			.setDps(1.75)
			.setPoison(true)
			.setSummon(false)
			.setLootTable(snakeLoot)
			.build();
		
		System.out.println(snake);
	}
}
