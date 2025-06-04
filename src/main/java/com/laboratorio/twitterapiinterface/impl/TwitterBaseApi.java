package com.laboratorio.twitterapiinterface.impl;

import com.google.gson.Gson;
import com.laboratorio.clientapilibrary.ApiClient;
import com.laboratorio.clientapilibrary.utils.ReaderConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Rafael
 * @version 1.1
 * @created 19/12/2024
 * @updated 04/05/2025
 */
public class TwitterBaseApi {
    protected static final Logger log = LogManager.getLogger(TwitterBaseApi.class);
    protected final ApiClient client;
    protected final String accessToken;
    protected ReaderConfig apiConfig;
    protected final Gson gson;

    public TwitterBaseApi(String accessToken) {
        this.client = new ApiClient();
        this.accessToken = accessToken;
        this.apiConfig = new ReaderConfig("config//twitter_api.properties");
        this.gson = new Gson();
    }
}