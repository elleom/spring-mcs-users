package com.lm.mobileappws.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author el_le
 * @since 17/02/2022 21:06
 */

@Getter
@Setter
@Builder
public class UserDetailsRequestModel {

    @NotNull(message = "Probably an invisible lastname...")
    private String firstname;

    @NotNull(message = "Probably an invisible name...")
    private String lastname;

    @NotNull
    @Email(message = "Not an email...")
    private String email;

    @NotNull(message = "The password??") @Size(min = 8, max = 16, message = "min 8, max 16")
    private String password;
}
