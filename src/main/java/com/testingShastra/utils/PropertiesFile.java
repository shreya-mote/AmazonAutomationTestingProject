package com.testingShastra.utils;

public class PropertiesFile {
	static String filePath=System.getProperty("user.dir")+"/src/test/resources/config/data.properties";
	
    public static String getBrowser() {
    	return PropUtils.readPropertiesFile(filePath,"browser_name");
    }
    public static String getUrl(String env) {
    	return PropUtils.readPropertiesFile(filePath,env+"_app_url");
    }
}
 