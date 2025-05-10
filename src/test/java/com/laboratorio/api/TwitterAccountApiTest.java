package com.laboratorio.api;

import com.laboratorio.clientapilibrary.utils.ReaderConfig;
import com.laboratorio.twitterapiinterface.TwitterAccountApi;
import com.laboratorio.twitterapiinterface.impl.TwitterAccountApiImpl;
import com.laboratorio.twitterapiinterface.model.TwitterAccount;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Rafael
 * @version 1.0
 * @created 19/12/2024
 * @updated 10/05/2025
 */
public class TwitterAccountApiTest {
    private TwitterAccountApi accountApi;
    
    @BeforeEach
    public void initApi() {
        ReaderConfig config = new ReaderConfig("config//twitter_api.properties");
        String accessToken = config.getProperty("test_access_token");
        this.accountApi = new TwitterAccountApiImpl(accessToken);
    }
    
    /* @Test
    public void getAccountByIdTest() {
        String id = "1657362213437427713";
        
        TwitterAccount account = this.accountApi.getAccountById(id);
        
        assertEquals(id, account.getData().getId());
    }
    
    @Test
    public void getAccountByUsernameTest() {
        String username = "humordespierto";
        
        TwitterAccount account = this.accountApi.getAccountByUsername(username);
        
        assertEquals(username, account.getData().getUsername());
    } */
}