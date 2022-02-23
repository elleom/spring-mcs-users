package com.lm.mobileappws.model.response.exception;

import lombok.*;

import java.util.Date;

/**
 * @author el_le
 * @since 23/02/2022 19:41
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    private Date timestamp;
    private String message;
}
