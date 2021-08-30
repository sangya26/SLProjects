package com.ssn.lockme_com;

import java.io.File;
import java.util.Scanner;

public class SearchFile {

	public static void search() {
		Scanner s=new Scanner(System.in);
		String f=s.nextLine();
		File file = new File(f);
		if(file.exists())
			System.out.println("The file exists : "+file.getName());
		else
			System.out.println("The file doesn't exist.");
	}
}
