package beren.io;

import java.util.Scanner;

public class MyScanner
{
	public static Scanner scanner = new Scanner(System.in);
	
	public static void closeScanner()
	{
		scanner.close();
	}
}
