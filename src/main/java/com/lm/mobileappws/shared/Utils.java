package com.lm.mobileappws.shared;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author el_le
 * @since 23/02/2022 20:51
 */

@Service
public class Utils {
    public String createNewUUID(){
        return UUID.randomUUID().toString();
    }
}
