package ua.epamcourses.task4.web.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

public class LanguageBundle {
	
	public static void addLanguage(String langFileURL, HttpServletRequest request){
		Properties properties = new Properties();
		InputStream in = LanguageBundle.class.getClassLoader().getResourceAsStream(langFileURL);
		try {
			InputStreamReader reader = new InputStreamReader(in, "UTF-8");	
			properties.load(reader);
		} catch (IOException e) {}
		for(String key : properties.stringPropertyNames()) {
			String value = properties.getProperty(key);
			request.getSession().setAttribute(key, value);
		}	
	}
}
