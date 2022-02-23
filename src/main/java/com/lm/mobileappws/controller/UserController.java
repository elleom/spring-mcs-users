package com.lm.mobileappws.controller;

import com.lm.mobileappws.model.request.UserDetailsRequestModel;
import com.lm.mobileappws.model.response.UserRest;
import com.lm.mobileappws.service.UserService;
import com.lm.mobileappws.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author el_le
 * @since 29/01/2022 17:19
 */

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    Map<String, UserRest> userMap = new HashMap<>();

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page, //default value makes the value optional
                           @RequestParam(value = "limit") int limit,
                           @RequestParam(value = "sort", required = false) String sort ){
        return String.format("Called to all users, page = %s quantity = %s", page, limit);
    }

    @GetMapping(value = "/{userId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId){

        if(userMap.containsKey(userId)) {
            return new ResponseEntity<>(userMap.get(userId), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {

        UserRest user = userService.createUser(userDetails);
        userMap.put(user.getUserId(), user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping(value = "/{userId}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> updateUser(@Valid @RequestBody UserDetailsRequestModel userDetails,@PathVariable String userId) {
        if (userMap.containsKey(userId)){

            UserRest savedUser = getUser(userId).getBody();
            userMap.remove(userId); //needed?
            savedUser.setName(userDetails.getFirstname());
            savedUser.setLastname(userDetails.getLastname());
            savedUser.setEmail(userDetails.getEmail());
            savedUser.setPassword(userDetails.getPassword());
            userMap.put(userId, savedUser);

            return new ResponseEntity<>(savedUser, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId){
        if (userMap.containsKey(userId)){
            userMap.remove(userId);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }


}
