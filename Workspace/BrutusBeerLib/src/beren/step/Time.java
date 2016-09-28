package beren.step;

public class Time
{
	public int hours;
	public int minutes;
	public int seconds;
	
	/**
	 * Calculates the amount hours, minutes and seconds
	 * 
	 * @param hours the amount of hours
	 * @param minutes the amount of minutes
	 * @param seconds the amount of seconds
	 * @see Time
	 */
	public Time(int hours, int minutes, int seconds)
	{
		this.seconds = (seconds%3600) % 60;
		this.minutes = (minutes + ((seconds%3600)/60)) % 60;
		this.hours = hours + ((minutes + ((seconds%3600) / 60)) / 60) + (seconds/3600);
	}
	
	/**
	 * Calculates the amount hours, minutes and seconds
	 * 
	 * @param minutes the amount of minutes
	 * @param seconds the amount of seconds
	 * @see Time
	 */
	public Time(int minutes, int seconds)
	{
		this.seconds = (seconds%3600) % 60;
		this.minutes = (minutes + ((seconds%3600)/60)) % 60;
		this.hours = ((minutes + ((seconds%3600) / 60)) / 60) + (seconds/3600);
	}
	
	/**
	 * Calculates the amount hours, minutes and seconds
	 * 
	 * @param seconds the amount of seconds
	 * @see Time
	 */
	public Time(int seconds)
	{
		this.seconds = (seconds%3600) % 60;
		this.minutes = ((seconds%3600)/60) % 60;
		this.hours = (((seconds%3600) / 60) / 60) + (seconds/3600);
	}
	
	/**
	 * Gets the string with the proper format to display the time
	 * 
	 * @return the string with the correct format
	 * @see Time
	 */
	public String displayTime()
	{
		return String.format("%02d:%02d:%02d", hours, minutes, seconds);
	}
}
