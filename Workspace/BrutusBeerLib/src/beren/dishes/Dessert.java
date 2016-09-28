package beren.dishes;

import beren.dish.Dish;
import beren.instructions.Instructions;

public class Dessert extends Dish
{
	private DessertType dessertType;
	
	/**
	 * Sets the dessert information
	 * 
	 * @param id the id of the dessert
	 * @param name the name of the dessert
	 * @param price the price of the dessert
	 * @param dessertType the type of the dessert
	 * @param tempType whether it is a hot or cold dish
	 * @param instruction the instructions of the dessert
	 * @see Dessert
	 * @see Dish
	 * @see Instructions
	 * @see DessertType
	 */
	public Dessert(int id, String name, double price, DessertType dessertType, TemperatureType tempType, Instructions instruction)
	{
		this.id = id;
		this.name = name;
		this.priceExBtw = price;
		this.dessertType = dessertType;
		this.tempType = tempType;
		this.instruction = instruction;
	}
	
	/**
	 * Sets the dessert information
	 * 
	 * @param id the id of the dessert
	 * @param name the name of the dessert
	 * @param dessertType the type of the dessert
	 * @param tempType whether it is a hot or cold dish
	 * @param instruction the instructions of the dessert
	 * @see Dessert
	 * @see Dish
	 * @see Instructions
	 * @see DessertType
	 */
	public Dessert(int id, String name, DessertType dessertType, TemperatureType tempType, Instructions instruction)
	{
		this.id = id;
		this.name = name;
		this.dessertType = dessertType;
		this.tempType = tempType;
		this.instruction = instruction;
	}
	
	/**
	 * Sets the dessert information
	 * 
	 * @param id the id of the dessert
	 * @param dessertType the type of the dessert
	 * @param tempType whether it is a hot or cold dish
	 * @param instruction the instructions of the dessert
	 * @see Dessert
	 * @see Dish
	 * @see Instructions
	 * @see DessertType
	 */
	public Dessert(int id, DessertType dessertType, TemperatureType tempType, Instructions instruction)
	{
		this.id = id;
		this.dessertType = dessertType;
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
	
	/**
	 * Gets the dessert type
	 * 
	 * @return the dessert type
	 * @see Dessert
	 * @see Dish
	 * @see Instructions
	 * @see DessertType
	 */
	public DessertType getDessertType()
	{
		return dessertType;
	}
	
	/**
	 * Sets the dessert type
	 * @param dessertType the new dessert type
	 * @see Dessert
	 * @see Dish
	 * @see Instructions
	 * @see DessertType
	 */
	public void setDessertType(DessertType dessertType)
	{
		this.dessertType = dessertType;
	}
}
