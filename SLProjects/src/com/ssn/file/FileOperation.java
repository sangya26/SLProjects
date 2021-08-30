package com.ssn.file;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperation {

	public static void main(String[] args) {
		
		try {
			  
			File input = new File("G:\\input.txt");
	         if(!input.exists()) {
	            input.createNewFile();
	         }
	         File output = new File("G:\\output.txt");
	         if(!output.exists()) {
	            output.createNewFile();
	         }
           
            FileReader fr = new FileReader(input);
  
            FileWriter fw = new FileWriter(output);
  
            String str = "";
  
            int i;
  
            while ((i = fr.read()) != -1) {
                str += (char)i;
            }
  
            System.out.println(str);
            fw.write(str);
  
            
            fr.close();
            fw.close();
            System.out.println("File reading, writing are completed.");
        }
        catch (IOException e) {
            System.out.println(
                "There are some IOException");
        }

	}

}
