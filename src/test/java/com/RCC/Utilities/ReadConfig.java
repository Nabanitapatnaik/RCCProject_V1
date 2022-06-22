package com.RCC.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadConfig {
	Properties property;

	public ReadConfig() {

		File src=new File("./Configuration/config.properties");
		try {
			FileInputStream input=new FileInputStream(src);
			property=new Properties();
			property.load(input);
		}catch(Exception e) {
			System.out.println("Exception is : "+e.getMessage());
		}
	}


	public String getUrl() {
		String url=property.getProperty("baseurl");
		return url;
	}

	public String getemailid() {
		String mailid=property.getProperty("emailid");
		return mailid;
	}



}
