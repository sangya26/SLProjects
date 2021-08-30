package com.ssn.lockme_com;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AddFile {
	
	public static void addFile() {
		
		Scanner s=new Scanner(System.in);
		String f=s.next();
		try {
		      File obj = new File(f);
		      if (obj.createNewFile()) {
		        System.out.println("File created: " + obj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		 } 
		catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		 }
	}
}
