package com.caloriecalc.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import com.opencsv.CSVReader;

public class DataReaders {

	public static String projectProperty(String propName) {
		Properties obj = new Properties();
		FileInputStream inStream;
		try{
			inStream = new FileInputStream(new File("./project.properties"));
			obj.load(inStream);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return obj.getProperty(propName);
	}
	
	public static Iterator<String[]> CSVReader(String filePath){
		FileReader inStream = null;
		CSVReader reader = null;
		Iterator<String[]> iterator = null;
		try {
			inStream = new FileReader(new File(filePath));
			reader = new CSVReader(inStream);
			iterator = reader.readAll().iterator();
			iterator.next();
			reader.close();
		}catch(IOException e) {
			
		}finally {
			
		}
		return  iterator;
	}
}
