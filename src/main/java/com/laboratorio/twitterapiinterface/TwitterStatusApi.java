package com.laboratorio.twitterapiinterface;

import com.laboratorio.twitterapiinterface.model.TwitterStatus;

/**
 *
 * @author Rafael
 * @version 1.0
 * @created 19/12/2024
 * @updated 19/12/2024
 */
public interface TwitterStatusApi {
    TwitterStatus postStatus(String text);
}