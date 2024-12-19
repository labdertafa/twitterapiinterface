package com.laboratorio.twitterapiinterface.impl;

import com.google.gson.Gson;
import com.laboratorio.clientapilibrary.ApiClient;
import com.laboratorio.twitterapiinterface.utils.TwitterApiConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Rafael
 * @version 1.0
 * @created 19/12/2024
 * @updated 19/12/2024
 */
public class TwitterBaseApi {
    protected static final Logger log = LogManager.getLogger(TwitterBaseApi.class);
    protected final ApiClient client;
    protected final String accessToken;
    protected TwitterApiConfig apiConfig;
    protected final Gson gson;

    public TwitterBaseApi(String accessToken) {
        this.client = new ApiClient();
        this.accessToken = accessToken;
        this.apiConfig = TwitterApiConfig.getInstance();
        this.gson = new Gson();
    }
    
    protected void logException(Exception e) {
        log.error("Error: " + e.getMessage());
        if (e.getCause() != null) {
            log.error("Causa: " + e.getCause().getMessage());
        }
    }
}