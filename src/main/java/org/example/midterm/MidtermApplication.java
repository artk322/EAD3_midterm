package org.example.midterm;


import org.example.midterm.config.Config;
import org.example.midterm.controller.MyController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MidtermApplication {

  private static Boolean bool = true;
  private static BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        Config.class
    );
    MyController controller = context.getBean("myController", MyController.class);
    System.out.println("1. Sign in");
    System.out.println("2. Sign up");
    System.out.println("0. Exit");

    String ch = read.readLine();

    if (ch.equals("1")) {
      if (controller.login()) {
        while (bool) {
          System.out.println("1. To Return all My Notes");
          System.out.println("2. To update Note");
          System.out.println("3. To Add new Note");
          System.out.println("4. To change status of the Note");
          System.out.println("5. To delete Note");
          System.out.println("0. To Quit");
          String choice = read.readLine();

          switch (choice) {
            case "1":
              controller.selectAll();
              break;
            case "2":
              controller.updateNote();
              break;
            case "3":
              controller.addNote();
              break;
            case "4":
              controller.changeStatus();
              break;
            case "5":
              controller.deleteNote();
              break;
            default:
              bool = false;
          }
        }
      } else {
        System.out.println("Incorrect username or password");
      }
    } else if (ch.equals("2")) {

      controller.registration();

    } else {
      System.out.println("Bye");
    }

  }
}