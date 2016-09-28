package beren.menu;

import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import beren.dish.Dish;
import beren.io.MyScanner;
import beren.lib.Functions;
import beren.lib.Strings;
import beren.step.Step;

public class MainMenu
{
	private Scanner scanner = MyScanner.scanner;
	
	public void mainMenu()
	{
		showMenu();
		int choice = 0;
		
		while(true)
		{
			try
			{
				System.out.println(Strings.MENU_CHOICE);
				choice = scanner.nextInt();
			}
			catch(InputMismatchException e)
			{
				System.out.println(Strings.INPUT_INVALID);
			}
			processChoice(choice);
		}
	}
	
	private void showMenu()
	{
		for(int i = 0; i < 9; i++)
			System.out.println(Strings.MENU_ENTRIES[i]);
	}
	
	private void processChoice(int choice)
	{
		switch(choice)
		{
			case 1:
				menuItem1();
				break;
			case 2:
				menuItem2();
				break;
			case 3:
				menuItem3();
				break;
			case 4:
				menuItem4();
				break;
			case 5:
				menuItem5();
				break;
			case 8:
				menuItem8();
				break;
			case 9:
				menuItem9();
				break;
			default:
				System.out.println(Strings.INVALID_MENU_ENTRY);
				scanner.nextLine();
				mainMenu();
				break;
		}
	}
	
	private void menuItem1()
	{
		List<Dish> dishes = Dish.getDishList();
		
		Collections.sort(dishes, new Comparator<Dish>(){
			@Override
			public int compare(Dish d1, Dish d2)
			{
				return d1.getId() - d2.getId();
			}
		});
		
		System.out.println("Gerechten:");
		for(int i = 0; i < Dish.dishes.size(); i++)
		{
			System.out.print(i+1 + ": ");
			System.out.println(dishes.get(i).displayDish());
		}
		
		System.out.println("\n");
		System.out.println(Strings.CHOOSE_DISH);
		String choice = scanner.nextLine();
		scanner.nextLine();
		int dishChoice = 0;
		
		if(choice == "")
		{
			mainMenu();
		}
		
		try
		{
			dishChoice = Integer.parseInt(choice);
		}
		catch(NumberFormatException exception)
		{
			System.out.println(Strings.INPUT_INVALID);
			Functions.enterToContinue();
			mainMenu();
		}
		
		System.out.println(Strings.FROM_STEP);
		scanner.nextLine();
		String choice2 = scanner.nextLine();
		int fromChoice = 0;
		
		try
		{
			fromChoice = Integer.parseInt(choice2);
		}
		catch(NumberFormatException exception)
		{
			System.out.println(Strings.INPUT_INVALID);
			Functions.enterToContinue();
			mainMenu();
		}
		
		System.out.println(dishes.get(dishChoice-1).displayDish(true, true));
		System.out.println("\nStappen:");
		for(Step step:dishes.get(dishChoice-1).getInstruction().getDescriptionFrom(fromChoice))
		{
			System.out.println("\n" + step.displayStep());
		}
		
		System.out.println("\n\n");
		Functions.enterToContinue();
		mainMenu();
	}
	
	private void menuItem2()
	{
		
	}
	
	private void menuItem3()
	{
		
	}
	
	private void menuItem4()
	{
		
	}
	
	private void menuItem5()
	{
		
	}
	
	private void menuItem8()
	{
		mainMenu();
	}
	
	private void menuItem9()
	{
		System.exit(0);
	}
}
