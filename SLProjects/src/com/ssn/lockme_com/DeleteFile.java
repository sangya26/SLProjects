package com.ssn.lockme_com;

import java.io.File;
import java.util.Scanner;

public class DeleteFile {
	public static void deleteFile() {
		Scanner s=new Scanner(System.in);
		String f=s.nextLine();
		File obj = new File(f); 
	    if (obj.delete()) { 
	      System.out.println("Deleted the file: " + obj.getName());
	    } else {
	      System.out.println("Failed to delete the file.");
	    } 
	}
	
}
