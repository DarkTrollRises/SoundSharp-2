package beren.instructions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import beren.step.Step;
import beren.step.Time;

public class Instructions
{
	private List<Step> steps = new LinkedList<Step>();
	
	/**
	 * Adds a step to the step list
	 * 
	 * @param step the step to add to the step list
	 * @see Instructions
	 * @see Step
	 */
	public void add(Step step)
	{
		steps.add(step);
	}
	
	/**
	 * Removes a step from the step list
	 * 
	 * @param step the step to add to the step list
	 * @return if the removal has been successful
	 * @see Instructions
	 * @see Step
	 */
	public boolean remove(Step step)
	{
		return steps.remove(step);
	}
	
	/**
	 * Gets the steps in the step list in order from the number given
	 * 
	 * @param order the step order number to start at
	 * @return a list with the steps in order
	 * @see Instructions
	 * @see Step
	 */
	public List<Step> getDescriptionFrom(int order)
	{
		Step[] tempArray = (Step[]) steps.toArray(new Step[0]);
		List<Step> tempList;
		ArrayList<Step> tempArrayList = new ArrayList<Step>();
		
		Arrays.sort(tempArray, new Comparator<Step>()
		{
			@Override 
	        public int compare(Step s1, Step s2) {
	            return s1.getOrder() - s2.getOrder();
	        }
		});
		
		tempList = new LinkedList<Step>(Arrays.asList(tempArray));
		tempArrayList.addAll(tempList);
		
		for(Step step:tempArrayList)
		{
			if(step.getOrder() < order)
			{
				tempList.remove(step);
			}
			else
				return tempList;
		}
		return null;
	}
	
	/**
	 * Gets the total time all of the steps take
	 * 
	 * @return the time the steps take
	 * @see Instructions
	 * @see Step
	 * @see Time
	 */
	public Time getTotalTime()
	{
		int hours = 0;
		int minutes = 0;
		int seconds = 0;
		
		for(Step step:steps)
		{
			hours += step.getDuration().hours;
			minutes += step.getDuration().minutes;
			seconds += step.getDuration().seconds;
		}

		return new Time(hours, minutes, seconds);
	}
	
	/**
	 * Gets a step from the step list
	 * 
	 * @param index the index of the step
	 * @return the step at the given index in the step list
	 * @see Instructions
	 * @see Step
	 */
	public Step getStep(int index)
	{
		try
		{
			return steps.get(index);
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	/**
	 * Gets the size of the step list
	 * 
	 * @return the size of the step list
	 * @see Instructions
	 * @see Step
	 */
	public int getSize()
	{
		return steps.size();
	}
}
