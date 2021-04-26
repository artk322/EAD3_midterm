package org.example.midterm.repository;

import org.example.midterm.model.Note;
import org.example.midterm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public interface UserRepository   extends JpaRepository<User, Long> {


    @Query(value = "SELECT * FROM Users u Where u.name=?1 and u.password=?2", nativeQuery = true)
    User findByUserNameAndPassword(String name, String password);

    User findByUsername(String username);
}
