package com.testingShastra.utils;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

public class PropertiesFile {
	static String filePath = System.getProperty("user.dir") + "/src/test/resources/config/data.properties";

	public static String getBrowser() {
		return PropUtils.readPropertiesFile(filePath, "browser_name");
	}

	public static String getUrl(String env) {
		return PropUtils.readPropertiesFile(filePath, env + "_app_url");
	}

	public static String getUserName() {
		return PropUtils.readPropertiesFile(filePath, "login_ID");
	}

	public static String getPassword() {
		return PropUtils.readPropertiesFile(filePath, "password");
	}

	

	

	
	
	
	
}
