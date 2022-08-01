package projectex;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

public class readconfig1 {
	Properties property;

	// Constructor to read the data from the Config File
	public readconfig1() {

		////C:\Users\reach\Ecliipse4.17\eclipse\RCCProject\RCCProject_V1\Configuration\config.properties
		
		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream input = new FileInputStream(src);
			property = new Properties();
			property.load(input);
		} catch (Exception e) {
			System.out.println("Exception is : " + e.getMessage());
		}
	}

	public String getBaseUrl() {
		String baseurl = property.getProperty("baseurl");
		return baseurl;
	}

	public String getEmail() {
		String email = property.getProperty("email");
		return email;
	}

	public String getPwd() {
		String pwd = property.getProperty("pwd");
		return pwd;
	}

}
