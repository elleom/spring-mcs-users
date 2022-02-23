package com.lm.mobileappws.service;

import com.lm.mobileappws.model.request.UserDetailsRequestModel;
import com.lm.mobileappws.model.response.UserRest;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author el_le
 * @since 23/02/2022 20:27
 */
public interface UserService {
    UserRest createUser(UserDetailsRequestModel userDetailsRequestModel);
    List<UserRest> getUsers();
    UserRest updateUser(String userID);
    void deleteUser(String userID);
}
