package org.example.midterm.Service;

import org.example.midterm.model.Note;
import org.example.midterm.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {


    @Autowired
    private NotesRepository notesRepository;


    public List<Note> findAllNotes(){
        return notesRepository.findAll();
    }

    public Optional<Note> findNote(Long id){
        return notesRepository.findById(id);
    }

    public void deleteNote(Long id){
        notesRepository.deleteById(id);
    }

    public void updateNote(Long id, Note note){
        Note myNote = notesRepository.findById(id).orElse(null);

        if(myNote != null){
            myNote.setTitle(note.getTitle());
            myNote.setStatus(note.isStatus());
            myNote.setDate(note.getDate());

            notesRepository.saveAndFlush(myNote);

        }
    }


    public void createNote(Note note){

        Note mySomeNote = new Note();
        mySomeNote.setTitle(note.getTitle());
        mySomeNote.setDate(note.getDate());
        mySomeNote.setStatus(note.isStatus());

        notesRepository.saveAndFlush(mySomeNote);
    }




}
