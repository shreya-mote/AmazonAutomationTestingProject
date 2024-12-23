package com.testingShastra.utils;

import java.util.Set;

import com.testingShastra.Base.Keyword;

public class SwitchWindowfor {
	public static void switchingWindow(String url) {
		//String Parent_WindowHandle = Keywords.driver.getWindowHandle();
		//System.out.println(Parent_WindowHandle);
	Set<String > multiple_WindowHandle=	Keyword.driver.getWindowHandles();
	for (String multipleWindow : multiple_WindowHandle) {
		Keyword.driver.switchTo().window(multipleWindow);
		 String currentWindow_url =Keyword.driver.getCurrentUrl();
		if(currentWindow_url.contains(url)) {
			break;
		}else {
			continue;
		}
	
	}

	}

}
