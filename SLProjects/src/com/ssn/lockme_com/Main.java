package com.ssn.lockme_com;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		System.out.println("Welcome to LockedMe.com, choose the number to perform the operation of your choice : ");
		String menu = (" 1. Add a file "+"\n"+" 2. Delete a file "+"\n"+" 3. Read a file "+ "\n"+" 4. Show all the files "+"\n"+" 5. Search a file "+"\n"+" 6. Exit");
		int c;
		do {
			System.out.println(menu);
			c=s.nextInt();
			switch(c) {
			case 1 : 
				System.out.println("Please enter the filename to add : ");
				AddFile.addFile();
				break;
			case 2 :
				System.out.println("Enter the file name to delete : ");
				DeleteFile.deleteFile();
				break;
			case 3 :
				System.out.println("Enter the file name to read it's content : ");
				ReadFile.readFile();
				break;
			case 4 :
				ShowFiles.showFiles();
				break;
			case 5 :
				System.out.println("Enter the file name to search in the DB : ");
				SearchFile.search();
				break;
			case 6 : 
				     System.exit(0);
				     
			default : 
				System.out.println("Invalid Input");
		}
		}while(c!=7);
	}

}
