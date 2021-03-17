package org.example.midterm.controller;

import org.example.midterm.Service.NotesServiceImpl;
import org.example.midterm.event.userLoginEvent;
import org.example.midterm.model.Note;
import org.example.midterm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Controller
public class MyController implements ApplicationEventPublisherAware {
  private static BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
  private final NotesServiceImpl notesService;
  private Long userId;
  private ApplicationEventPublisher eventPublisher;

  @Autowired
  public MyController(NotesServiceImpl notesService) {
    this.notesService = notesService;
  }

  public boolean login() throws IOException {
    System.out.println("Enter name");
    String name = read.readLine();
    System.out.println("Enter password");
    String password = read.readLine();

    if (notesService.login(name, password) != null) {

      userId = notesService.login(name, password).getId();

      this.eventPublisher.publishEvent(new userLoginEvent(this, notesService.login(name, password).getName()));
      return true;
    }
    return false;

  }

  public void registration() throws IOException {
    System.out.println("Enter name");
    String name = read.readLine();
    System.out.println("Enter password");
    String password = read.readLine();

    User newUser = new User(name, password);
    notesService.registration(newUser);
    System.out.println("You Successfully registered");
  }


  public void selectAll() {
    for (Note note : notesService.selectAll(userId)) {
      System.out.println("id: " + note.getId() + "\n" + "title: " + note.getTitle()
          + "\n" + "target date: " + note.getDate() + "\n" + "status: " + note.isStatus() + "\n");
    }
  }

  public void addNote() throws IOException {
    System.out.println("Enter title");
    String newNoteTitle = read.readLine();
    System.out.println("Enter target date DD/MM/YYYY");
    String newNoteDate = read.readLine();
    System.out.println("Enter status false or true");
    boolean newNoteStatus = Boolean.parseBoolean(read.readLine());

    Note note = new Note(newNoteTitle, newNoteDate, newNoteStatus, userId);

    notesService.addNote(note);
    System.out.println("Your note has been added");
  }


  public void updateNote() throws IOException {
    System.out.println("Enter id of the Note");
    Long noteId = Long.valueOf(read.readLine());
    System.out.println("Enter title");
    String newNoteTitle = read.readLine();
    System.out.println("Enter target date DD/MM/YYYY");
    String newNoteDate = read.readLine();
    System.out.println("Enter status false or true");
    boolean newNoteStatus = Boolean.parseBoolean(read.readLine());

    Note note = new Note(newNoteTitle, newNoteDate, newNoteStatus, userId);

    notesService.updateNote(noteId, note);
    System.out.println("Your note has been updated");

  }


  public void changeStatus() throws IOException {
    System.out.println("Enter id of the Note");
    Long noteId = Long.valueOf(read.readLine());
    System.out.println("Enter status false or true");
    boolean newNoteStatus = Boolean.parseBoolean(read.readLine());

    Note note = new Note(newNoteStatus, userId);

    notesService.changeStatus(noteId, note);
  }


  public void deleteNote() throws IOException {
    System.out.println("Enter id of the Note");
    Long noteId = Long.valueOf(read.readLine());

    notesService.deleteNote(noteId);
    System.out.println("Your note has been deleted");

  }

  @Override
  public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
    this.eventPublisher = applicationEventPublisher;
  }
}
