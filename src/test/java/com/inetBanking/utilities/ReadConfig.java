package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() {
		
		File src = new File("./Configuration Files/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error message is" + e.getMessage());
		}
		
	}
	
	public String getBaseUrl() {
		String url = pro.getProperty("baseUrl");
		return url;
	}
	
	public String getaddcustUrl() {
		String url = pro.getProperty("addcustUrl");
		return url;
	}
	
	public String getUsername() {
		String user = pro.getProperty("username");
		return user;
	}
	
	public String getPassword() {
		String pass = pro.getProperty("password");
		return pass;
	}
	
	public String getChromePath() {
		String chrome = pro.getProperty("chromepath");
		return chrome;
	}

}
