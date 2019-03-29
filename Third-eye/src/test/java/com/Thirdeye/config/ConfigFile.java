package com.Thirdeye.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFile
{
    public String sketchesURL;
    public String URL2;

    public ConfigFile(){
    	Properties prop = new Properties();
        try {
            File propFile = new File("./test.properties");
            prop.load(new FileInputStream(propFile));
            this.sketchesURL = prop.getProperty("baseSketchesURL");
            this.URL2 = prop.getProperty("URL2");


        } catch (IOException e) {
            System.err.println("Error in reading test.properties file");
            e.printStackTrace();

        }
    }

}