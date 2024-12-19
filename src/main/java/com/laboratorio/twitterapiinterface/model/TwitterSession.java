package com.laboratorio.twitterapiinterface.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Rafael
 * @version 1.0
 * @created 19/12/2024
 * @updated 19/12/2024
 */

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class TwitterSession {
    private String token_type;
    private int expires_in;
    private String access_token;
    private String scope;
    private String refresh_token;

    @Override
    public String toString() {
        return "TwitterSession{" + "token_type=" + token_type + ", expires_in=" + expires_in + ", access_token=" + access_token + ", scope=" + scope + ", refresh_token=" + refresh_token + '}';
    }
}