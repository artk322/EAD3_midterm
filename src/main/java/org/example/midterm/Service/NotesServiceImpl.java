package org.example.midterm.Service;

import org.example.midterm.model.Note;
import org.example.midterm.model.User;
import org.example.midterm.repository.NotesRepository;
import org.example.midterm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NotesServiceImpl {

  @Autowired
  private NotesRepository notesRepository;

  @Autowired
  private UserRepository userRepository;


  public User login(String name, String password) {
    return userRepository.findByUserNameAndPassword(name, password);
  }


  public void registration(User user) {
    userRepository.save(user);
  }


  public List<Note> selectAll(Long user_id) {
    List<Note> noteList = new ArrayList<>();

    notesRepository.findAllByUserId(user_id)
        .forEach(noteList::add);

    return noteList;
  }

  public Note selectOne(Long id) {
    return notesRepository.findByIds(id);
  }

  public void addNote(Note note) {
    notesRepository.save(note);
  }

  public void updateNote(Long id, Note note) {
    Optional<Note> noteOptional = notesRepository.findById(id);
    if (noteOptional.isPresent()) {
      Note updatedNote = noteOptional.get();
      updatedNote.setDate(note.getDate());
      updatedNote.setStatus(note.isStatus());
      updatedNote.setTitle(note.getTitle());
      updatedNote.setUser_id(note.getUser_id());
      notesRepository.save(updatedNote);
    }
  }

  public void changeStatus(Long id, Note note) {
    Optional<Note> noteOptional = notesRepository.findById(id);
    if (noteOptional.isPresent()) {
      Note updatedNote = noteOptional.get();
      updatedNote.setStatus(note.isStatus());
      notesRepository.save(updatedNote);
    }
  }

  public void deleteNote(Long id) {
    notesRepository.deleteById(id);
  }
}
