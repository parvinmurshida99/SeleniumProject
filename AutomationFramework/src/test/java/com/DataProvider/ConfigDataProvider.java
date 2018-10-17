package com.DataProvider;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class ConfigDataProvider {
	
	public static Properties pro;
	
	public ConfigDataProvider(){ //constractor
		File src = new File("./Configuration/config.properties");

			try {
				FileInputStream fis =new FileInputStream(src);
				pro = new Properties();
				pro.load(fis);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
	}

	// function for geting Url from config.properties file
	public String getApplicationUrl(){
		String url = pro.getProperty("url");
		return url;
		
	}
	// function for geting chrome path from config.properties file
	public String getChromePath(){
		String chromePath = pro.getProperty("chromeDriverPath");
		return chromePath;
		
	}
	// function for geting IE path from config.properties file
	public String getIEPath(){
		String IEPath = pro.getProperty("IEDriverPath");
		return IEPath;
		
	}
}
