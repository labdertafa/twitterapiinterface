package com.laboratorio.api;

import com.laboratorio.twitterapiinterface.TwitterSessionApi;
import com.laboratorio.twitterapiinterface.impl.TwitterSessionApiImpl;
import com.laboratorio.twitterapiinterface.model.TwitterSession;
import com.laboratorio.twitterapiinterface.utils.TwitterApiConfig;
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
 * @updated 19/12/2024
 */

public class TwitterSessionApiTest {
    protected static final Logger log = LogManager.getLogger(TwitterSessionApiTest.class);
    private TwitterSessionApi sessionApi;
    
    @BeforeEach
    public void initApi() {
        String accessToken = TwitterApiConfig.getInstance().getProperty("test_access_token");
        String refreshToken = TwitterApiConfig.getInstance().getProperty("test_refresh_token");
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