package com.laboratorio.twitterapiinterface.impl;

import com.laboratorio.clientapilibrary.model.ApiMethodType;
import com.laboratorio.clientapilibrary.model.ApiRequest;
import com.laboratorio.clientapilibrary.model.ApiResponse;
import com.laboratorio.twitterapiinterface.TwitterAccountApi;
import com.laboratorio.twitterapiinterface.exception.TwitterException;
import com.laboratorio.twitterapiinterface.model.TwitterAccount;

/**
 *
 * @author Rafael
 * @version 1.0
 * @created 19/12/2024
 * @updated 04/05/2025
 */
public class TwitterAccountApiImpl extends TwitterBaseApi implements TwitterAccountApi {
    public TwitterAccountApiImpl(String accessToken) {
        super(accessToken);
    }

    @Override
    public TwitterAccount getAccountById(String id) {
        String endpoint = this.apiConfig.getProperty("getAccountById_endpoint");
        int okStatus = Integer.parseInt(this.apiConfig.getProperty("getAccountById_ok_status"));
        
        try {
            String url = endpoint + "/" + id;
            ApiRequest request = new ApiRequest(url, okStatus, ApiMethodType.GET);
            request.addApiHeader("Authorization", "Bearer " + this.accessToken);
            
            ApiResponse response = this.client.executeApiRequest(request);
            log.debug("Response: " + response.getResponseStr());
            
            return this.gson.fromJson(response.getResponseStr(), TwitterAccount.class);
        } catch (Exception e) {
            throw new TwitterException("Error recuperando la información de la cuenta Twitter con id: " + id, e);
        }
    }

    @Override
    public TwitterAccount getAccountByUsername(String username) {
        String endpoint = this.apiConfig.getProperty("getAccountByUsername_endpoint");
        int okStatus = Integer.parseInt(this.apiConfig.getProperty("getAccountByUsername_ok_status"));
        
        try {
            String url = endpoint + "/" + username;
            ApiRequest request = new ApiRequest(url, okStatus, ApiMethodType.GET);
            request.addApiHeader("Authorization", "Bearer " + this.accessToken);
            
            ApiResponse response = this.client.executeApiRequest(request);
            log.debug("Response: " + response.getResponseStr());
            
            return this.gson.fromJson(response.getResponseStr(), TwitterAccount.class);
        } catch (Exception e) {
            throw new TwitterException("Error recuperando la información de la cuenta Twitter con nombre: " + username, e);
        }
    }
    
}