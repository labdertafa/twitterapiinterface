package com.laboratorio.twitterapiinterface;

import com.laboratorio.twitterapiinterface.model.TwitterSession;

/**
 *
 * @author Rafael
 * @version 1.0
 * @created 19/12/2024
 * @updated 19/12/2024
 */
public interface TwitterSessionApi {
    TwitterSession refreshSession();
}