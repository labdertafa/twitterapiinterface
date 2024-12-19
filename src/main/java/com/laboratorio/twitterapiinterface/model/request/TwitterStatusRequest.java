package com.laboratorio.twitterapiinterface.model.request;

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
public class TwitterStatusRequest {
    private String text;
}