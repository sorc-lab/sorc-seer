package builder;

public class SnakeBuilder
{
	private final String _name;
	private int _hp = 0;
	private boolean _hasPoison = false;
	private double _dps = 0.0;
	private int _movementSpeed = 0;
	private boolean _canSummon = false;
	private String[] _lootTable;
	
	public SnakeBuilder(String name) { this._name = name; }
	
	public SnakeBuilder(
		String name, int hp, boolean hasPoison, double dps, int movementSpeed,
		boolean canSummon, String[] lootTable
	)
	{
		this._name = name;
		this._hp = hp;
		this._hasPoison = hasPoison;
		this._dps = dps;
		this._movementSpeed = movementSpeed;
		this._canSummon = canSummon;
		this._lootTable = lootTable;
	}

	public SnakeBuilder setHp(int hp)
	{
		this._hp = hp;
		return this;
	}
	
	public SnakeBuilder setPoison(boolean hasPoison)
	{
		this._hasPoison = hasPoison;
		return this;
	}
	
	public SnakeBuilder setDps(double dps)
	{
		this._dps = dps;
		return this;
	}
	
	public SnakeBuilder setMovementSpeed(int movementSpeed)
	{
		this._movementSpeed = movementSpeed;
		return this;
	}
	
	public SnakeBuilder setSummon(boolean canSummon)
	{
		this._canSummon = canSummon;
		return this;
	}
	
	public SnakeBuilder setLootTable(String[] lootTable)
	{
		this._lootTable = lootTable;
		return this;
	}
	
	public Snake build()
	{
		return new Snake(
			_name, _hp, _hasPoison, _dps, _movementSpeed, _canSummon, _lootTable
		);
	}
}
