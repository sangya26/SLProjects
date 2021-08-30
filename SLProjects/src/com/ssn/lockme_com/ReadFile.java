package com.ssn.lockme_com;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {

	public static void readFile() {
		Scanner s=new Scanner(System.in);
		String f=s.nextLine();
		try {
			FileReader fr=new FileReader(f);
			int i;
		    while ((i=fr.read()) != -1)
		    	System.out.print((char) i);
		    }
		catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		   }
	}
}
