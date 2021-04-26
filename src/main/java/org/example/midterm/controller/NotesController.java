package org.example.midterm.controller;


import org.example.midterm.Service.NoteService;
import org.example.midterm.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notes")
public class NotesController {

    @Autowired
    private NoteService noteService;

    @GetMapping
    public List<Note> findAllNotes(){
        return noteService.findAllNotes();
    }

    @GetMapping("/{noteId}")
    public Optional<Note> findOne(@PathVariable Long noteId) {
        return noteService.findNote(noteId);
    }

    @PostMapping
    public void createNote(@RequestBody Note note){
        noteService.createNote(note);
    }

    @DeleteMapping("/{noteId}")
    public void deleteNote(@PathVariable Long noteId){
        noteService.deleteNote(noteId);
    }


    @PutMapping("/{noteId}")
    public void updateNote(@PathVariable Long noteId, @RequestBody Note note){
        noteService.updateNote(noteId, note);
    }


}
