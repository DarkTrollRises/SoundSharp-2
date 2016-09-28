package beren.step;

public class Step
{
	private int order;
	private String description;
	private Time duration;
	
	/**
	 * Sets the step information
	 * 
	 * @param order the number in the order of the steps
	 * @param description the description of the step
	 * @param duration the time the step takes
	 * @see Step
	 * @see Time
	 */
	public Step(int order, String description, Time duration)
	{
		this.order = order;
		this.description = description;
		this.duration = duration;
	}
	
	/**
	 * Sets the step information
	 * 
	 * @param order the number in the order of the steps
	 * @param description the description of the step
	 * @see Step
	 */
	public Step(int order, String description)
	{
		this.order = order;
		this.description = description;
	}
	
	/**
	 * Sets the step information
	 * 
	 * @param order the number in the order of the steps
	 * @see Step
	 */
	public Step(int order)
	{
		this.order = order;
	}
	
	/**
	 * Sets the step information
	 * @see Step
	 */
	public Step()
	{
	}
	
	/**
	 * Sets the order number of the step
	 * 
	 * @param order order number to set
	 * @see Step
	 */
	public void setOrder(int order)
	{
		this.order = order;
	}
	
	/**
	 * Gets the order number of the step
	 * 
	 * @return order number of the step
	 * @see Step
	 */
	public int getOrder()
	{
		return this.order;
	}
	
	/**
	 * Sets the description of the step
	 * 
	 * @param description the description to set
	 * @see Step
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	/**
	 * Gets the description of the step
	 * 
	 * @return description of the step
	 * @see Step
	 */
	public String getDescription()
	{
		return this.description;
	}
	
	/**
	 * Sets the duration of the step
	 * 
	 * @param duration the duration to set
	 * @see Step
	 * @see Time
	 */
	public void setDuration(Time duration)
	{
		this.duration = duration;
	}
	
	/**
	 * Gets the duration of the step
	 * 
	 * @return duration of the step
	 * @see Step
	 * @see Time
	 */
	public Time getDuration()
	{
		return this.duration;
	}
	
	/**
	 * Gets the duration of the step in seconds
	 * 
	 * @return duration of the step in seconds
	 * @see Step
	 * @see Time
	 */
	public int getDurationInSeconds()
	{
		return duration.seconds + (duration.minutes*60) + (duration.hours*3600);
	}
	
	/**
	 * Gives the information of the step in the following format: %order number%: %description%(%duration%)
	 * 
	 * @return string with the information of the step
	 * @see Step
	 * @see Time
	 */
	public String displayStep()
	
	{
		return String.format("%d: %s(%s)", order, description, duration.displayTime());
	}
}
