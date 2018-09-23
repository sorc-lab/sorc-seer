package builder;

import java.util.Arrays;

/**
 * Avoid long constructor calls such as:
 * Monster monster = new Monster(
 * 		"A Snake", 350, hasPoison, 1.75, 150, canSummon, lootTable
 * );
 * 
 * Error prone, compiler will allow mistakes in order if types are correct.
 * Hard to read and cumbersome for developers.
 * Some parms. may be option, resulting in having to pass in 'nulls'.
 * Solving the issue w/ 'setters' can result in a partially initialized obj.
 * if a dev. forgets to call a setter function.
 * 
 * NOTE: Has private constructor that only the builder has access to.
 * 		 Uses fluent interface for enhanced readability.
 */
public class Snake
{
	private final String _name;
	private int _hp;
	private boolean _hasPoison;
	private double _dps;
	private int _movementSpeed;
	private boolean _canSummon;
	private String[] _lootTable;
	
	private Snake(String name) { this._name = name; }
	
	public String getName() { return _name; }
	
	public int getHp() { return _hp; }
	public void setHp(int hp) { this._hp = hp; }
	
	public boolean hasPoison() { return _hasPoison; }
	public void setPoison(boolean hasPoison)
	{
		this._hasPoison = hasPoison;
	}
	
	public double getDps() { return _dps; }
	public void setDps(double dps) { this._dps = dps; }
	
	public int getMovementSpeed() { return _movementSpeed; }
	public void setMovementSpeed(int movementSpeed)
	{
		this._movementSpeed = movementSpeed;
	}
	
	public boolean canSummon() { return _canSummon; }
	public void setSummon(boolean canSummon) { this._canSummon = canSummon; }
	
	public String[] getLootTable() { return _lootTable; }
	public void setLootTable(String[] lootTable)
	{
		this._lootTable = lootTable;
	}
	
	public String toString()
	{
		String name = "Name: " +  _name + "\n";
		String hp = "HP: " + String.valueOf(_hp) + "\n";
		String hasPoison = "Poison: " + String.valueOf(_hasPoison) + "\n";
		String dps = "DPS: " + String.valueOf(_dps) + "\n";
		String movementSpeed = "Speed: " + String.valueOf(_movementSpeed) +"\n";
		String lootTable = "Loot: " + Arrays.toString(_lootTable) + "\n";
		return name + hp + hasPoison + dps + movementSpeed + lootTable;
	}
	
	public static class Builder
	{
		private final String _name; // important field--pass to constructor
		private int _hp;
		private boolean _hasPoison;
		private double _dps;
		private int _movementSpeed;
		private boolean _canSummon;
		private String[] _lootTable;
		
		public Builder(String name)
		{
			this._name = name;
		}
		
		public Builder setHp(int hp)
		{
			this._hp = hp;
			return this; // return builder each time--use fluent interface
		}
		
		public Builder setPoison(boolean hasPoison)
		{
			this._hasPoison = hasPoison;
			return this;
		}
		
		public Builder setDps(double dps)
		{
			this._dps = dps;
			return this;
		}
		
		public Builder setMovementSpeed(int movementSpeed)
		{
			this._movementSpeed = movementSpeed;
			return this;
		}
		
		public Builder setSummon(boolean canSummon)
		{
			this._canSummon = canSummon;
			return this;
		}
		
		public Builder setLootTable(String[] lootTable)
		{
			this._lootTable = lootTable;
			return this;
		}
		
		// creates snake obj.--always in fully instantiated state when returned
		public Snake build()
		{
			// Builder is IN Snake class, we can invoke its private constructor
			Snake snake = new Snake(_name);
			snake._hp = this._hp;
			snake._hasPoison = this._hasPoison;
			snake._dps = this._dps;
			snake._movementSpeed = this._movementSpeed;
			snake._canSummon = this._canSummon;
			snake._lootTable = this._lootTable;
			return snake;
		}
	}
}
