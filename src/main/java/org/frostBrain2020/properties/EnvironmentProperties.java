package org.frostBrain2020.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import static java.lang.String.format;

public class EnvironmentProperties {

    private static final Properties properties = new Properties();
    private static final Logger log = LoggerFactory.getLogger(EnvironmentProperties.class);

    static {
        String environment = System.getProperty("envConfig"); // -DenvConfig=....
        try {
            properties.load(EnvironmentProperties.class.getClassLoader()
                    .getResourceAsStream(format("environments\\%s.properties", environment)));
        } catch (IOException | NullPointerException e) {
            log.error("Unable to find property file from environment {}", System.getProperty("envConfig"));
            e.printStackTrace();
        }
    }

    public static final String BASE_URL = properties.getProperty("base.url");
    public static final String USERNAME = properties.getProperty("username");
    public static final String USERNAME_REQUIRED_FIELD = properties.getProperty("username.required.field");
}
