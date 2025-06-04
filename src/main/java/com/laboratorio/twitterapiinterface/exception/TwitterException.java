package com.laboratorio.twitterapiinterface.exception;

/**
 *
 * @author Rafael
 * @version 1.1
 * @created 01/08/2024
 * @updated 04/05/2025
 */
public class TwitterException extends RuntimeException {
    private Throwable causaOriginal = null;
    
    public TwitterException(String message) {
        super(message);
    }
    
    public TwitterException(String message, Throwable causaOriginal) {
        super(message);
        this.causaOriginal = causaOriginal;
    }
    
    @Override
    public String getMessage() {
        if (this.causaOriginal != null) {
            return super.getMessage() + " | Causa original: " + this.causaOriginal.getMessage();
        }
        
        return super.getMessage();
    }
}