package com.laboratorio.api;

import com.laboratorio.clientapilibrary.utils.ReaderConfig;
import com.laboratorio.twitterapiinterface.TwitterSessionApi;
import com.laboratorio.twitterapiinterface.impl.TwitterSessionApiImpl;
import com.laboratorio.twitterapiinterface.model.TwitterSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

public class TwitterSessionApiTest {
    protected static final Logger log = LogManager.getLogger(TwitterSessionApiTest.class);
    private TwitterSessionApi sessionApi;
    
    @BeforeEach
    public void initApi() {
        ReaderConfig config = new ReaderConfig("config//twitter_api.properties");
        String accessToken = config.getProperty("test_access_token");
        String refreshToken = config.getProperty("test_refresh_token");
        this.sessionApi = new TwitterSessionApiImpl(accessToken, refreshToken);
    }
    
/*    @Test
    public void refreshSessionTest() {
        TwitterSession session = this.sessionApi.refreshSession();
        
        log.info("Info: {}", session.toString());
        
        assertEquals("bearer", session.getToken_type());
        assertEquals(7200, session.getExpires_in());
    } */
}