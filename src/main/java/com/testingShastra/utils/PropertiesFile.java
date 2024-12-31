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

    public static String EnterText() {
    	return PropUtils.readPropertiesFile(filePath,"EnterTshirt");
    }
    
    public static String switchToTshirtWindowUrl() {
    	return PropUtils.readPropertiesFile(filePath,"switchToTshirtWindowUrl");
    }
    
    public static String Enterdress() {
    	return PropUtils.readPropertiesFile(filePath,"dress");
    }
    
    public static String switchTodressWindowUrl() {
    	return PropUtils.readPropertiesFile(filePath,"switchtodressWindow");
    }
    
    public static String entertshirtturns() {
    	return PropUtils.readPropertiesFile(filePath,"tshirtturms");
    }
    
    public static String switchTotshirtturmsWindowUrl() {
    	return PropUtils.readPropertiesFile(filePath,"switchtodressWindow");
    }
    
    public static String switchToproductTitlewindow() {
    	return PropUtils.readPropertiesFile(filePath,"switchtoProductwindow");
    }
    
    public static String switchTodeleteWindow() {
    	return PropUtils.readPropertiesFile(filePath,"deletewindow");
    }
    
    public static String switchToanothertshirtWindow() {
    	return PropUtils.readPropertiesFile(filePath,"switchtoAnotherTshirtCombo");
    }
    
    
    

}
