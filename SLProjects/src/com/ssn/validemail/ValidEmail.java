package com.ssn.validemail;

import java.util.Arrays;
import java.util.Scanner;

public class ValidEmail {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter number of email ID you want to store : ");
		int n=s.nextInt();
		String[] ar=new String[n];
		System.out.println("Enter the emails : ");
		for(int i=0;i<n;i++) {
			ar[i]=s.next();
		}
		System.out.println("Enter the email you want to search : ");
		String email=s.next();
		if(Arrays.asList(ar).contains(email)) {
			System.out.println("Searched email ID found : "+email);
		}else {
			System.out.println("Searched email ID not found.");
		}
	}

}
