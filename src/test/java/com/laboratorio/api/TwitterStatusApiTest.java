package com.laboratorio.api;

import com.laboratorio.clientapilibrary.utils.ReaderConfig;
import com.laboratorio.twitterapiinterface.TwitterStatusApi;
import com.laboratorio.twitterapiinterface.impl.TwitterStatusApiImpl;
import com.laboratorio.twitterapiinterface.model.TwitterStatus;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Rafael
 * @version 1.0
 * @created 19/12/2024
 * @updated 10/05/2024
 */
public class TwitterStatusApiTest {
    private TwitterStatusApi statusApi;
    
    @BeforeEach
    public void initApi() {
        ReaderConfig config = new ReaderConfig("config//twitter_api.properties");
        String accessToken = config.getProperty("test_access_token");
        this.statusApi = new TwitterStatusApiImpl(accessToken);
    }
    
    /* @Test
    public void postStatusTest() {
        String texto = "Estado de prueba enviado desde la aplicación SocialImprove con un test unitario JUNIT. Tiene un link: https://laboratoriorafa.mooo.com y 2 hashtags #SiguemeYTeSigo #Followback";
        
        TwitterStatus status = this.statusApi.postStatus(texto);
        
        assertTrue(status.getData().getText().startsWith("Estado de prueba enviado desde la aplicación SocialImprove con un test unitario JUNIT. Tiene un link:"));
    } */
}