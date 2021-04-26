package org.example.midterm.repository;


import org.example.midterm.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotesRepository  extends JpaRepository<Note, Long> {


    @Query(value = "SELECT * FROM Notes n WHERE n.id=?1", nativeQuery = true)
    Note findByIds(Long id);

   @Query(value = "SELECT * FROM Notes n WHERE n.user_id=?1 ORDER BY id", nativeQuery = true)
   List<Note> findAllByUserId(Long user_id);

}
