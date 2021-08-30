package com.ssn.lockme_com;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Comparator;

public class ShowFiles {
	
	public static void showFiles() {
		File dir = new File(".");
		if(dir.isDirectory())
	    {
		  File[] files = dir.listFiles();
	      FileFilter fileFilter = new FileFilter()
	      {
	        @Override
	        public boolean accept(File file) {
	          return !file.isDirectory();
	        }
	      };
	      files = dir.listFiles(fileFilter);
	      Arrays.sort(files, new Comparator<Object>()
	      {
	        @Override
	        public int compare(Object f1, Object f2) {
	          return ((File) f1).getName().compareTo(((File) f2).getName());
	        }
	      });
	      for(File file:files)
	      {
	        System.out.println(file.getName());
	      }
	    }
	}
}
