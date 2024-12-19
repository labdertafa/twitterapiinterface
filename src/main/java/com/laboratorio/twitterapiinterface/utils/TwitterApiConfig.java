package com.laboratorio.twitterapiinterface.utils;

import java.io.FileReader;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Rafael
 * @version 1.0
 * @created 16/08/2024
 * @updated 19/12/2024
 */
public class TwitterApiConfig {
    private static final Logger log = LogManager.getLogger(TwitterApiConfig.class);
    private static TwitterApiConfig instance;
    private final Properties properties;

    private TwitterApiConfig() {
        properties = new Properties();
        loadProperties();
    }

    private void loadProperties() {
        try {
            this.properties.load(new FileReader("config//twitter_api.properties"));
        } catch (Exception e) {
            log.error("Ha ocurrido un error leyendo el fichero de configuración del API de Twitter. Finaliza la aplicación!");
            log.error(String.format("Error: %s", e.getMessage()));
            if (e.getCause() != null) {
                log.error(String.format("Causa: %s", e.getCause().getMessage()));
            }
            System.exit(-1);
        }
    }

    public static TwitterApiConfig getInstance() {
        if (instance == null) {
            synchronized (TwitterApiConfig.class) {
                if (instance == null) {
                    instance = new TwitterApiConfig();
                }
            }
        }
        
        return instance;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}