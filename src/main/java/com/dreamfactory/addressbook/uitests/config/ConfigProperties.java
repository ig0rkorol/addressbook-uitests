package com.dreamfactory.addressbook.uitests.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
    private ConfigProperties(){}
    private static final Properties props = new Properties();
    private static final Logger logger = LoggerFactory.getLogger(ConfigProperties.class);
    private static final String HTTP_URL = "http://%s";
    private static final String PATH_TO_RESOURCES = "src/main/resources/";
    public static final String DOMAIN;
    public static final String LOGIN_URL;
    public static final String REGISTER_API_URL;

    static {
        readProperties();
        DOMAIN = String.format(HTTP_URL, getProperty("DOMAIN"));
        LOGIN_URL = getProperty("LOGIN.URL").replace("${DOMAIN}", DOMAIN);
        REGISTER_API_URL = getProperty("REGISTER.API.URI").replace("${DOMAIN}", DOMAIN);;
    }

    private static void readProperties() throws AssertionError {
        String configFile = PATH_TO_RESOURCES + "/config.properties";
        try {
            logger.info(String.format("Reading configuration data from '%s' file", configFile));
            props.load(new FileReader(configFile));
        } catch (IOException e) {
            throw new AssertionError(String.format("An exception occurs during loading of '%s' config file", configFile), e);
        }
    }

    private static String getProperty(String propertyName, String defaultValue) {
        return System.getProperty(propertyName.toLowerCase(), props.getProperty(propertyName, defaultValue));
    }

    private static String getProperty(String propertyName) {
        return getProperty(propertyName, null);
    }

    private static boolean getBooleanProperty(String propertyName) {
        return Boolean.parseBoolean(getProperty(propertyName));
    }

    private static int getIntegerProperty(String propertyName) {
        return Integer.parseInt(getProperty(propertyName));
    }

    private static int getIntegerProperty(String propertyName, int defaultValue) {
        return  Integer.parseInt(System.getProperty(propertyName.toLowerCase(), props.getProperty(propertyName, defaultValue + "")));
    }
}
