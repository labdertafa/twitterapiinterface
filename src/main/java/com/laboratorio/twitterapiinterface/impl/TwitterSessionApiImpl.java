package com.laboratorio.twitterapiinterface.impl;

import com.google.gson.JsonSyntaxException;
import com.laboratorio.clientapilibrary.exceptions.ApiClientException;
import com.laboratorio.clientapilibrary.model.ApiMethodType;
import com.laboratorio.clientapilibrary.model.ApiRequest;
import com.laboratorio.clientapilibrary.model.ApiResponse;
import com.laboratorio.twitterapiinterface.TwitterSessionApi;
import com.laboratorio.twitterapiinterface.model.TwitterSession;

/**
 *
 * @author Rafael
 * @version 1.0
 * @created 19/12/2024
 * @updated 19/12/2024
 */
public class TwitterSessionApiImpl extends TwitterBaseApi implements TwitterSessionApi {
    private final String refreshToken;
    
    public TwitterSessionApiImpl(String accessToken, String refreshToken) {
        super(accessToken);
        this.refreshToken = refreshToken;
    }

    @Override
    public TwitterSession refreshSession() {
        String endpoint = this.apiConfig.getProperty("refreshSession_endpoint");
        int okStatus = Integer.parseInt(this.apiConfig.getProperty("refreshSession_ok_status"));
        String clientId = this.apiConfig.getProperty("twitter_client_id");
        
        try {
            String url = endpoint;
            ApiRequest request = new ApiRequest(url, okStatus, ApiMethodType.POST);
            request.addApiPathParam("refresh_token", this.refreshToken);
            request.addApiPathParam("grant_type", "refresh_token");
            request.addApiPathParam("client_id", clientId);
            
            ApiResponse response = this.client.executeApiRequest(request);
            
            return this.gson.fromJson(response.getResponseStr(), TwitterSession.class);
        } catch (JsonSyntaxException e) {
            logException(e);
            throw  e;
        } catch (ApiClientException e) {
            throw  e;
        }
    }
}