package com.lm.mobileappws.model.response;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author el_le
 * @since 02/02/2022 21:54
 */

@Builder
@RestController
@AllArgsConstructor
@RequiredArgsConstructor
public class UserRest {
    private String name;
    private String lastname;
    private String email;
    private String userId;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() { return password;}

    public void setPassword(String password) {this.password = password;}
}
