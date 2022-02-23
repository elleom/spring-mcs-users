package com.lm.mobileappws.exception.custom;

/**
 * @author el_le
 * @since 23/02/2022 20:00
 */
public class UserServiceException  extends RuntimeException {
                 
    public UserServiceException() {
    }

    public UserServiceException(String message) {
        super(message);
    }

    public UserServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserServiceException(Throwable cause) {
        super(cause);
    }

    public UserServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
