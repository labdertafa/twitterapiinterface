package com.laboratorio.api;

import com.laboratorio.twitterapiinterface.TwitterStatusApi;
import com.laboratorio.twitterapiinterface.impl.TwitterStatusApiImpl;
import com.laboratorio.twitterapiinterface.model.TwitterStatus;
import com.laboratorio.twitterapiinterface.utils.TwitterApiConfig;
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
public class TwitterStatusApiTest {
    private TwitterStatusApi statusApi;
    
    @BeforeEach
    public void initApi() {
        String accessToken = TwitterApiConfig.getInstance().getProperty("test_access_token");
        this.statusApi = new TwitterStatusApiImpl(accessToken);
    }
    
    /* @Test
    public void postStatusTest() {
        String texto = "Estado de prueba enviado desde la aplicación SocialImprove con un test unitario JUNIT. Tiene un link: https://laboratoriorafa.mooo.com y 2 hashtags #SiguemeYTeSigo #Followback";
        
        TwitterStatus status = this.statusApi.postStatus(texto);
        
        assertTrue(status.getData().getText().startsWith("Estado de prueba enviado desde la aplicación SocialImprove con un test unitario JUNIT. Tiene un link:"));
    } */
}