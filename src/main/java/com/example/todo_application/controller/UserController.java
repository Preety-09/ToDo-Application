package com.example.todo_application.controller;

import com.example.todo_application.dto.UserDTO;
import com.example.todo_application.exceptions.UserAlreadyExistsException;
import com.example.todo_application.exceptions.UserDoesNotExistsException;
import com.example.todo_application.exceptions.UserTableEmptyException;
import com.example.todo_application.service.UserService;
import com.example.todo_application.utility.SuccessResponseHandler;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.todo_application.utility.Constants.NEW_USER_SUCCESSFULLY_CREATED;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody UserDTO userDTO)
            throws UserAlreadyExistsException {
        userService.addUser(userDTO);
        return new SuccessResponseHandler().generateResponse(NEW_USER_SUCCESSFULLY_CREATED, HttpStatus.CREATED);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<UserDTO>> getAllUsers() throws UserTableEmptyException {
        List<UserDTO> fetchedUsersList = userService.fetchAllUsers();
        return new ResponseEntity<>(fetchedUsersList, HttpStatus.OK);
    }

    @GetMapping(value = "/users/{user_id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Integer user_id) throws UserDoesNotExistsException {
        UserDTO fetchedUser = userService.fetchUser(user_id);
        return new ResponseEntity<>(fetchedUser, HttpStatus.OK);
    }
}
