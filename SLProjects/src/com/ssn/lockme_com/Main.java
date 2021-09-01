package com.ssn.lockme_com;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		System.out.println("Welcome to LockedMe.com \nDeveloper:- Sangya Sagareeka Nayak\n");
		System.out.println("Choose the number to perform the operation of your choice : ");
		String menu = ("\n A. Add a file "+"\n"+" B. Delete a file "+"\n"+" C. Read a file "+ "\n"+" D. Search a file "+"\n"+" E. Exit"+"\n\n");
		String menu_=("\n1. Show Files"+"\n"+"2. User operations"+"\n"+"3. Exit"+"\n");
		int c;String ch;
		
		do {
			System.out.println(menu_);
			c=s.nextInt();
			switch(c) {
			case 1: ShowFiles.showFiles();
					break;
			case 2: System.out.println(menu);
					ch=s.next().toUpperCase();
					
					switch(ch){
						case "A" : 
							System.out.println("Please enter the filename to add : ");
							AddFile.addFile();
							break;
						case "B" :
							System.out.println("Enter the file name to delete : ");
							DeleteFile.deleteFile();
							break;
						case "C" : 
							System.out.println("Enter the file name to read it's content : ");
							ReadFile.readFile();
							break;
						case "D" :
							System.out.println("Enter the file name to search in the DB : ");
							SearchFile.search();
							break;
						case "E" : 
							return;  
						default : 
							System.out.println("Invalid Input");
							
					}
					break;
			case 3: return;
			default: System.out.println("Invalid input");
			}
		}while(c!=4);
	}

}
