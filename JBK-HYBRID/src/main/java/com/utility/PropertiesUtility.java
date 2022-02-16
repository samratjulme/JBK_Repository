package com.utility;

import java.io.FileInputStream;
import java.util.Properties;

import com.base.BaseClass;

public class PropertiesUtility extends BaseClass{

	public static FileInputStream fis;
	
	public static String readProperty(String key) {

		log.info("Reading properties file for key ==>>"+key);
		
		Properties prop = new Properties();
		
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
		    prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("value not found in config file");
		}
		log.info("value assigned to key is found as==>>"+prop.getProperty(key));
		return prop.getProperty(key);
		
	}
}