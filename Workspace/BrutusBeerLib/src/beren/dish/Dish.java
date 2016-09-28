package beren.dish;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import beren.dishes.DishType;
import beren.dishes.TemperatureType;
import beren.instructions.Instructions;
import beren.step.Step;

public abstract class Dish
{
	public static List<Dish> dishes = new ArrayList<Dish>();
	
	protected int id;
	protected String name;
	protected double priceExBtw;
	protected double taxRate = 6.0;
	protected Instructions instruction;
	protected DishType dishType;
	protected TemperatureType tempType;
	
	/**
	 * Calculates the tax with the current taxrate
	 * 
	 * @return the tax
	 * @see Dish
	 */
	public abstract double calculateTax();
	
	/**
	 * Gets the string with the current tax in the correct format
	 * 
	 * @return the string in the correct format
	 * @see Dish
	 */
	public abstract String displayCalculateTax();
	
	/**
	 * Gets the string to display the dish
	 * 
	 * @return the string in the correct format
	 * @see Dish
	 */
	public String displayDish()
	{
		if(this.name != null)
			return "Naam: " + this.name;
		else
			return "Naam: Niet ingevuld";
	}
	
	/**
	 * Gets the string to display the dish with more info
	 * 
	 * @param dishPrice whether or not to display the price
	 * @param dishId whether or not to display the id
	 * @return the string in the correct format
	 * @see Dish
	 */
	public String displayDish(boolean dishPrice, boolean dishId)
	{
		String temp = displayDish();
		
		if(dishPrice)
		{
			if(this.priceExBtw != 0)
			{
				temp += String.format("\nPrijs: %.2f", this.priceExBtw);
			}
			else
			{
				temp += "\nPrijs: Niet ingevuld";
			}
		}
		if(dishId)
		{
			temp = "\nID: " + this.id + "\n" + temp;
		}
		
		return temp;
	}
	
	/**
	 * Adds the dish to the list
	 * @param dish the dish to add to the list
	 * @see Dish
	 */
	public void addToList(Dish dish)
	{
		dishes.add(dish);
	}
	
	/**
	 * Gets a list with cold dishes in order
	 * 
	 * @return list with cold dishes
	 * @see Dish
	 * @see TemperatureType
	 */
	public static List<Dish> showByTemp()
	{
		List<Dish> temp = new ArrayList<Dish>();
		
		for(Dish dish:dishes)
		{
			if(dish.getTempType() == TemperatureType.COLD)
			{
				temp.add(dish);
			}
		}
		Collections.sort(temp, new Comparator<Dish>()
		{
			@Override 
	        public int compare(Dish d1, Dish d2) {
	            return d1.getId() - d2.getId();
	        }
		});
		return temp;
	}
	
	/**
	 * Gets a list with cold or hot dishes in order
	 * 
	 * @param hot whether to return cold or hot dishes
	 * @return list with cold or hot dishes
	 * @see Dish
	 * @see TemperatureType
	 */
	public static List<Dish> showByTemp(boolean hot)
	{
		List<Dish> temp = new ArrayList<Dish>();
		
		for(Dish dish:dishes)
		{
			if(hot)
			{
				if(dish.getTempType() == TemperatureType.HOT)
				{
					temp.add(dish);
				}
			}
			else
			{
				if(dish.getTempType() == TemperatureType.COLD)
				{
					temp.add(dish);
				}
			}
		}
		Collections.sort(temp, new Comparator<Dish>()
		{
			@Override 
	        public int compare(Dish d1, Dish d2) {
	            return d1.getId() - d2.getId();
	        }
		});
		return temp;
	}
	
	/**
	 * Gets the list with the starters
	 * 
	 * @return the list with the starters
	 * @see Dish
	 */
	public static List<Dish> getDishList()
	{
		return dishes;
	}
	
	/**
	 * Checks if the dish has an instruction
	 * 
	 * @return whether or not the dish has an instruction
	 * @see Dish
	 * @see Instructions
	 */
	public boolean hasInstruction()
	{
		return (this.instruction.getSize()==0?false:true);
	}
	
	/**
	 * Add a step to the instruction
	 * 
	 * @param step the step to add to the instruction
	 * @see Dish
	 * @see Instructions
	 * @see Step
	 */
	public void addStep(Step step)
	{
		this.instruction.add(step);
	}
	
	/**
	 * Remove a step from the instruction
	 * 
	 * @param step the step to remove from the instruction
	 * @see Dish
	 * @see Instructions
	 * @see Step
	 */
	public void removeStep(Step step)
	{
		this.instruction.remove(step);
	}
	
	/**
	 * Gets the instruction
	 * 
	 * @return the instruction
	 * @see Dish
	 * @see Instructions
	 */
	public Instructions getInstruction()
	{
		return this.instruction;
	}
	
	/**
	 * Gets the dish type
	 * 
	 * @return the dish type
	 * @see Dish
	 * @see DishType
	 */
	public DishType getDishType()
	{
		return dishType;
	}
	
	/**
	 * Sets the dish type
	 * 
	 * @param dishType the new dish type
	 * @see Dish
	 * @see DishType
	 */
	public void setDishType(DishType dishType)
	{
		this.dishType = dishType;
	}
	
	/**
	 * Gets the temperature type
	 * 
	 * @return the temperature type
	 * @see Dish
	 * @see TemperatureType
	 */
	public TemperatureType getTempType()
	{
		return tempType;
	}
	
	/**
	 * Sets the temperature type
	 * 
	 * @param tempType the new temperature type
	 * @see Dish
	 * @see TemperatureType
	 */
	public void setTempType(TemperatureType tempType)
	{
		this.tempType = tempType;
	}
	
	/**
	 * Gets the id of the dish
	 * 
	 * @return the id of the dish
	 * @see Dish
	 */
	public int getId()
	{
		return id;
	}
	
	/**
	 * Sets the id of the dish
	 * 
	 * @param id the new id of the dish
	 * @see Dish
	 */
	public void setId(int id)
	{
		this.id = id;
	}
	
	/**
	 * Sets the name of the dish
	 * 
	 * @param name the new name of the dish
	 * @see Dish
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Gets the price of the dish without tax
	 * 
	 * @return the price of the dish without tax
	 * @see Dish
	 */
	public double getPrice()
	{
		return priceExBtw;
	}
	
	/**
	 * Gets the price of the dish with or without tax
	 * 
	 * @param exTax whether to return the price without or with tax
	 * @return the price with or without tax
	 * @see Dish
	 */
	public double getPrice(boolean exTax)
	{
		if(exTax)
			return priceExBtw;
		else
			return priceExBtw + calculateTax();
	}
	
	/**
	 * Sets the price of the dish without tax
	 * 
	 * @param price the new price of the dish without tax
	 * @see Dish
	 */
	public void setPrice(double price)
	{
		this.priceExBtw = price;
	}
	
	/**
	 * Gets the tax of the dish
	 * 
	 * @return the tax of the dish
	 * @see Dish
	 */
	public double getTax()
	{
		return taxRate;
	}
	
	/**
	 * Sets the tax of the dish
	 * 
	 * @param tax the new tax of the dish
	 * @see Dish
	 */
	public void setTax(double tax)
	{
		this.taxRate = tax;
	}
}
