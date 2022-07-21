package com.revature.controllers;

import com.revature.dtos.UserDto;
import com.revature.models.User;
import com.revature.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"}, allowCredentials = "true")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(
            method = RequestMethod.PATCH,
            value = "resetPW",
            consumes = {"application/json"}
    )
    public void resetPW(
            @RequestBody UserDto userDto
    ) {
        userService.resetPW(userDto);
    }
}
