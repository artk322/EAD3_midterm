package org.example.midterm.controller;

import org.example.midterm.Service.UserDataService;
import org.example.midterm.model.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/userData")
public class UserDataController {

    @Autowired
    private UserDataService userDataService;


    @GetMapping
    public List<UserData> findAllUserData(){
    return userDataService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<UserData> getOne(@PathVariable Long id){
        return  userDataService.findOne(id);
    }

    @PostMapping()
    public void createUserData(@RequestBody UserData userData){
        userDataService.createUserData(userData);
    }

    @PatchMapping("/{id}")
    public void changeUserId(@PathVariable Long id, @RequestParam Long userId){
        userDataService.ChangeUserId(id, userId);
    }

    @DeleteMapping("/{id}")
    public void deleteUserData(@RequestParam Long id){
        userDataService.deleteUserData(id);
    }
}
