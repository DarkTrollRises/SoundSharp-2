import java.util.List;

import beren.dish.Dish;
import beren.dishes.DishType;
import beren.dishes.MainCourse;
import beren.dishes.Starter;
import beren.dishes.TemperatureType;
import beren.instructions.Instructions;
import beren.step.Step;
import beren.step.Time;

public class Tester
{
	public static void main(String[] args)
	{
		Instructions instructions = new Instructions();
		Step step1 = new Step(1, "Schil de aardappelen en de tomaten", new Time(1, 50, 36));
		Step step2 = new Step(2, "test", new Time(2, 16, 42));
		Step step3 = new Step(3, "ayylmao", new Time(1, 58));
		Step step4 = new Step(4, "sweggy step", new Time(10));
		Step step5 = new Step(5, "www.niceme.me", new Time(2116));
		Step step6 = new Step(6, "swiggety swooty", new Time(65, 420));
		instructions.add(step2);
		instructions.add(step1);
		instructions.add(step5);
		instructions.add(step4);
		instructions.add(step6);
		instructions.add(step3);

		for(int i = 0; i < instructions.getSize(); i++)
		{
			System.out.println(instructions.getStep(i).displayStep());
		}
		System.out.println();
		
		List<Step> steps = instructions.getDescriptionFrom(5);
		
		if(steps != null)
		{
			for(Step step:steps)
			{
				System.out.println(step.displayStep());
			}
			System.out.println();
		}
		
		System.out.println("Total time: " + instructions.getTotalTime().displayTime());
		System.out.println();
		
		Instructions i1 = new Instructions();
		Instructions i2 = new Instructions();
		i1.add(new Step(1, "test1", new Time(1, 20, 30)));
		i2.add(new Step(1, "test2", new Time(1, 20, 30)));
		Dish dish = new MainCourse(1, "lmfao", 15.6, DishType.MEAT, TemperatureType.HOT, i1);
		dish.addToList(dish);
		System.out.println(dish.displayDish());
		System.out.println();
		System.out.println(dish.displayDish(true, false));
		System.out.println();
		System.out.println(dish.displayDish(false, true));
		System.out.println();
		System.out.println(dish.displayDish(true, true));
		System.out.println();
		System.out.println(String.format("%.2f", dish.calculateTax()));
		System.out.println(dish.displayCalculateTax());
		System.out.println();
		
		Dish starter1 = new Starter(2, "kek", 420.0, DishType.FISH, TemperatureType.HOT, i2);
		starter1.addToList(starter1);
		Dish starter2 = new Starter(3, "lol", 360, DishType.FISH, TemperatureType.HOT, i1);
		starter2.addToList(starter2);
		Dish starter3 = new Starter(4, "ayyy", 270, DishType.VEGETARIAN, TemperatureType.COLD, i2);
		starter3.addToList(starter3);
		Dish starter4 = new Starter(5, "lmao", 180, DishType.MEAT, TemperatureType.HOT, i1);
		starter4.addToList(starter4);
		System.out.printf("1: %s\n2: %s\n3: %s\n4: %s\n", starter1.displayCalculateTax(), starter2.displayCalculateTax(), starter3.displayCalculateTax(), starter4.displayCalculateTax());
		System.out.println();
		System.out.printf("%s\n\n%s\n\n%s\n\n%s\n\n----------", starter1.displayDish(true, true), starter2.displayDish(true, true), starter3.displayDish(true, true), starter4.displayDish(true, true));
		System.out.println();
	}
}
