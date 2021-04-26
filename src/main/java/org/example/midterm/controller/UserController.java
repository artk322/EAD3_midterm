package org.example.midterm.controller;

import org.example.midterm.Service.UserService;
import org.example.midterm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/{id}")
    public Optional<User> findOne(@PathVariable Long id){
        return userService.getUser(id);
    }


    @GetMapping
    public List<User> findAll(){
        return userService.findAllUsers();
    }

    @PostMapping("/signUp")
    public void signUp(@RequestBody User user){

        userService.createUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }


    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id,
                           @RequestBody User user) {

        userService.updateUser(id, user);
    }



    @PatchMapping("/{id}")
    public void updateUsername(@PathVariable Long id,
                               @RequestParam String username){

        userService.updateUserName(id, username);
    }


}
