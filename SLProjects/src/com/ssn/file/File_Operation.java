package com.ssn.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class File_Operation {

	public static void main(String[] args) {
		
		try {
			File output = new File("G:\\output.txt");
	         if(!output.exists()) {
	            output.createNewFile();
	         }
	         String appendStr = " Sagareeka";
	         BufferedWriter out = new BufferedWriter(new FileWriter(output, true));
	         out.write(appendStr);
	         
	         System.out.println("File appending completed.");   
	         out.close();
	         BufferedReader br = new BufferedReader(new FileReader(output));
	         String line;
	         while ((line = br.readLine()) != null) {
	           System.out.println(line);
	         }
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}

}
