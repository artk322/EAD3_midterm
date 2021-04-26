package org.example.midterm.Service;

import org.example.midterm.model.UserData;
import org.example.midterm.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDataService {


    @Autowired
    private UserDataRepository userDataRepository;

    public List<UserData> findAll(){
        return userDataRepository.findAll();
    }

    public Optional<UserData> findOne(Long id){
        return userDataRepository.findById(id);
    }

    public void createUserData(UserData userData) {

        UserData newUserData = new UserData();
        newUserData.setFullName(userData.getFullName());
        newUserData.setPhoneNumber(userData.getPhoneNumber());
        userDataRepository.save(newUserData);

    }

    public void ChangeUserId(Long id, Long userId){

        UserData userData = userDataRepository.findById(id).get();
        userData.setUser_id(userId);
        userDataRepository.saveAndFlush(userData);

    }

    public void deleteUserData(Long id) {
        userDataRepository.deleteById(id);
    }



}
