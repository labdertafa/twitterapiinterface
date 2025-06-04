package com.laboratorio.twitterapiinterface.impl;

import com.google.gson.JsonSyntaxException;
import com.laboratorio.clientapilibrary.model.ApiMethodType;
import com.laboratorio.clientapilibrary.model.ApiRequest;
import com.laboratorio.clientapilibrary.model.ApiResponse;
import com.laboratorio.twitterapiinterface.TwitterStatusApi;
import com.laboratorio.twitterapiinterface.exception.TwitterException;
import com.laboratorio.twitterapiinterface.model.TwitterStatus;
import com.laboratorio.twitterapiinterface.model.request.TwitterStatusRequest;

/**
 *
 * @author Rafael
 * @version 1.0
 * @created 19/12/2024
 * @updated 04/05/2025
 */
public class TwitterStatusApiImpl extends TwitterBaseApi implements TwitterStatusApi {

    public TwitterStatusApiImpl(String accessToken) {
        super(accessToken);
    }

    @Override
    public TwitterStatus postStatus(String text) {
        String endpoint = this.apiConfig.getProperty("postStatus_endpoint");
        int okStatus = Integer.parseInt(this.apiConfig.getProperty("postStatus_ok_status"));
        
        try {
            TwitterStatusRequest statusRequest = new TwitterStatusRequest(text);
            String requestJson = gson.toJson(statusRequest);
            log.debug("Post a enviar: " + requestJson);
            
            String url = endpoint;
            ApiRequest request = new ApiRequest(url, okStatus, ApiMethodType.POST, requestJson);
            request.addApiHeader("Authorization", "Bearer " + this.accessToken);
            
            ApiResponse response = this.client.executeApiRequest(request);
            log.debug("Response: " + response.getResponseStr());
            
            return this.gson.fromJson(response.getResponseStr(), TwitterStatus.class);
        } catch (Exception e) {
            throw new TwitterException("Error posteando un estado en Twitter: " + text, e);
        }
    }
}