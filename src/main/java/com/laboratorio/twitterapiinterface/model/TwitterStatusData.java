package com.laboratorio.twitterapiinterface.model;

import java.util.List;
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
public class TwitterStatusData {
    private List<String> edit_history_tweet_ids;
    private String id;
    private String text;
}