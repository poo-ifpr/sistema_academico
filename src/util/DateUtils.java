package util;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateUtils {

	private static SimpleDateFormat dateFormatter;
	private static String dateFormat = "dd/MM/yyyy";
	
	static {
		dateFormatter = new SimpleDateFormat();
		dateFormatter.applyPattern(dateFormat);
	}
	
	public static String formataData(Date date){
		return dateFormatter.format(date); 
	}
}
