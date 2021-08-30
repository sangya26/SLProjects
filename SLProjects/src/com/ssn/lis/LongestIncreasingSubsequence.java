package com.ssn.lis;

import java.util.Scanner;

public class LongestIncreasingSubsequence {

	static int incre_subseq(int arr[], int len){
	      int seq_arr[] = new int[len];
	      int i, j, max = 0;
	      for (i = 0; i < len; i++) {
	    	  seq_arr[i] = 1;
	      } 
	      for (i = 1; i < len; i++) {
	    	  for (j = 0; j < i; j++) {
	    		  if (arr[i] > arr[j] && seq_arr[i] < seq_arr[j] + 1)
		    	      seq_arr[i] = seq_arr[j] + 1;
	    	  }    
	      }
	      for (i = 0; i < len; i++) {
    	   	  if (max < seq_arr[i])
    	   	      max = seq_arr[i];
          }
	      return max;
	   }
	
	public static void main(String[] args) {
	
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the length of the array : ");
		int n=s.nextInt();
		int[] ar=new int[n];
		System.out.println("Enter the array elements : ");
		for(int i=0;i<n;i++) {
			ar[i]=s.nextInt();
		}
		System.out.println("The length of the longest increasing subsequence is " +  incre_subseq(ar, n));

	}

}
