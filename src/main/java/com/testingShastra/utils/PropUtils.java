package com.testingShastra.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropUtils {
	public static String readPropertiesFile(String filePath,String key) {
		FileInputStream fis=null;
		  try {
			fis=new FileInputStream(filePath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   Properties prop=new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String value=prop.getProperty(key);
		return value;
		
	}
}
