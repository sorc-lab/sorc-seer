package builder;

public class TestSnakeBuilder
{
	public static void main(String[] args)
	{
		String[] snakeLoot = {"A Snake Egg", "Snake Scales", "Poisonous Fang"};
		
		Snake snake = new Snake.Builder("A Snake")
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
