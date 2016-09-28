package beren.dishes;

import beren.dish.Dish;
import beren.instructions.Instructions;

public class Starter extends Dish
{
	/**
	 * Sets the starter information
	 * 
	 * @param id the id of the starter
	 * @param name the name of the starter
	 * @param price the price of the starter
	 * @param dishType the type of the dish
	 * @param tempType whether it is a hot or cold dish
	 * @param instruction the instructions of the dish
	 * @see Starter
	 * @see Dish
	 */
	public Starter(int id, String name, double price, DishType dishType, TemperatureType tempType, Instructions instruction)
	{
		this.id = id;
		this.name = name;
		this.priceExBtw = price;
		this.dishType = dishType;
		this.tempType = tempType;
		this.instruction = instruction;
	}
	
	/**
	 * Sets the starter information
	 * 
	 * @param id the id of the starter
	 * @param name the name of the starter
	 * @param dishType the type of the dish
	 * @param tempType whether it is a hot or cold dish
	 * @param instruction the instructions of the dish
	 * @see Starter
	 * @see Dish
	 */
	public Starter(int id, String name, DishType dishType, TemperatureType tempType, Instructions instruction)
	{
		this.id = id;
		this.name = name;
		this.dishType = dishType;
		this.tempType = tempType;
		this.instruction = instruction;
	}
	
	/**
	 * Sets the starter information
	 * 
	 * @param id the id of the starter
	 * @param dishType the type of the dish
	 * @param tempType whether it is a hot or cold dish
	 * @param instruction the instructions of the dish
	 * @see Starter
	 * @see Dish
	 */
	public Starter(int id, DishType dishType, TemperatureType tempType, Instructions instruction)
	{
		this.id = id;
		this.dishType = dishType;
		this.tempType = tempType;
		this.instruction = instruction;
	}

	@Override
	public double calculateTax()
	{
		return this.priceExBtw * (this.taxRate/100);
	}
	
	@Override
	public String displayCalculateTax()
	{
		return String.format("Tax %.1f - €%.2f", this.taxRate, calculateTax());
	}
}
