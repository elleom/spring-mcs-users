package com.lm.mobileappws.service;

import com.lm.mobileappws.model.request.UserDetailsRequestModel;
import com.lm.mobileappws.model.response.UserRest;
import com.lm.mobileappws.shared.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author el_le
 * @since 23/02/2022 20:31
 */
@Service
public class UserServiceImpl implements UserService {

    private final Utils utils;

    @Autowired
    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {

        UserRest user = UserRest.builder()
                .userId(utils.createNewUUID())
                .name(userDetails.getFirstname())
                .lastname(userDetails.getLastname())
                .email(userDetails.getEmail())
                .password(userDetails.getPassword())
                .build();

        return user;
    }

    @Override
    public List<UserRest> getUsers() {

        return null;
    }

    @Override
    public UserRest updateUser(String userID) {
        return null;
    }

    @Override
    public void deleteUser(String userID) {

    }
}
