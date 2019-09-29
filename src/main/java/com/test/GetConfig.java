package com.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class GetConfig {

	
	@Test
	public static String getData(String env1) throws IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\Waheguru\\Documents\\workspace-spring-tool-suite-4-4.3.2.RELEASE\\Testing2\\config.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String env=prop.getProperty(env1);
		
		System.out.println(env);
		return env;
	}
}
