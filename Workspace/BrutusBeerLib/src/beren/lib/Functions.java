package beren.lib;

import beren.io.MyScanner;

public class Functions
{
	public static void enterToContinue()
	{
		System.out.println(Strings.PRESS_ENTER);
		MyScanner.scanner.nextLine();
	}
}
