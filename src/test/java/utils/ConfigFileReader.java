package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath = "configs//propiedades.properties";


    public ConfigFileReader() {
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
        if (binario != null) return binario;
        else throw new RuntimeException("binarioFirefox not specified in the Configuration.properties file.");
    }

    //urlTest - urlProd
    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if (url != null) return url;
        else throw new RuntimeException("urlTest not specified in the Configuration.properties file.");
    }

    public String getBrowser() {
        String browser = properties.getProperty("browser");
        if (browser != null) return browser;
        else throw new RuntimeException("browser not specified in the Configuration.properties file.");
    }

    public String setVisibleBrowser() {
        String visibleBrowser = properties.getProperty("visibleBrowser");
        if (visibleBrowser != null) return visibleBrowser;
        else throw new RuntimeException("visibleBrowser not specified in the Configuration.properties file.");
    }

}