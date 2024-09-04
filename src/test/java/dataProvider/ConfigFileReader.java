package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	private Properties properties;
	private final String propertyFilePath= "configs//propiedades.properties";

	
	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	public String setBinary() {		
		String binario = properties.getProperty("binario");
		if(binario != null) return binario;
		else throw new RuntimeException("binarioFirefox not specified in the Configuration.properties file.");		
	}
	
	//urlTest - urlProd
	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if(url != null) return url;
		else throw new RuntimeException("urlTest not specified in the Configuration.properties file.");
	}
	
	public String getBrowser() {		
		String browser = properties.getProperty("browser");
		if(browser != null) return browser;
		else throw new RuntimeException("browser not specified in the Configuration.properties file.");		
	}
	
	public String setVisibleBrowser() {		
		String visibleBrowser = properties.getProperty("visibleBrowser");
		if(visibleBrowser != null) return visibleBrowser;
		else throw new RuntimeException("visibleBrowser not specified in the Configuration.properties file.");		
	}
	
	public String getProxyUrl(){
	String proxyUrl = properties.getProperty("proxyUrl");
	if(proxyUrl != null) return proxyUrl;
	else throw new RuntimeException("proxyUrl not specified in the Configuration.properties file.");		
	}
	
	public Integer getProxyPort(){
		Integer proxyPort =  Integer.parseInt(properties.getProperty("proxyPort"));
		if(proxyPort != null) return proxyPort;
		else throw new RuntimeException("Port not specified in the Configuration.properties file.");		
		}
	
	public String getTestRailUrl(){
		String RAILS_ENGINE_URL = properties.getProperty("RAILS_ENGINE_URL");
		if(RAILS_ENGINE_URL != null) return RAILS_ENGINE_URL;
		else throw new RuntimeException("RAILS_ENGINE_URL not specified in the Configuration.properties file.");		
		}
	
	public String getTestRailUserName(){
		String TESTRAIL_USERNAME = properties.getProperty("TESTRAIL_USERNAME");
		if(TESTRAIL_USERNAME != null) return TESTRAIL_USERNAME;
		else throw new RuntimeException("TESTRAIL_USERNAME not specified in the Configuration.properties file.");		
		}
	
	public String getTestRailPassword(){
		String TESTRAIL_PASSWORD = properties.getProperty("TESTRAIL_PASSWORD");
		if(TESTRAIL_PASSWORD != null) return TESTRAIL_PASSWORD;
		else throw new RuntimeException("TESTRAIL_PASSWORD not specified in the Configuration.properties file.");		
		}
	
	public String getPassedStatus(){
		String TEST_CASE_PASSED_STATUS = properties.getProperty("TEST_CASE_PASSED_STATUS");
		if(TEST_CASE_PASSED_STATUS != null) return TEST_CASE_PASSED_STATUS;
		else throw new RuntimeException("TEST_CASE_PASSED_STATUS not specified in the Configuration.properties file.");		
		}
	
	public String getFailedStatus(){
		String TEST_CASE_FAILED_STATUS = properties.getProperty("TEST_CASE_FAILED_STATUS");
		if(TEST_CASE_FAILED_STATUS != null) return TEST_CASE_FAILED_STATUS;
		else throw new RuntimeException("TEST_CASE_FAILED_STATUS not specified in the Configuration.properties file.");		
		}
	
	
	
}