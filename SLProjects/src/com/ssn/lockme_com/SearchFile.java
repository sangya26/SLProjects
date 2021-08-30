package com.ssn.lockme_com;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SearchFile {

	public static void search() {
		Scanner s=new Scanner(System.in);
		String f=s.nextLine();
		File file = new File(f);
		boolean name = false;
		try {
	        name = file.exists() && file.getCanonicalFile().getName().equals(file.getName());
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		if (name) { 
		      System.out.println("File found : " + file.getName());
		} else {
		      System.out.println("File doesn't exist.");
		} 
	}
}
