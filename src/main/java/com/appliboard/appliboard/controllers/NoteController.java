package com.appliboard.appliboard.controllers;

import com.appliboard.appliboard.models.JobApplication;
import com.appliboard.appliboard.models.Note;
import com.appliboard.appliboard.models.User;
import com.appliboard.appliboard.repositories.JobApplicationRepository;
import com.appliboard.appliboard.repositories.NoteRepository;
import com.appliboard.appliboard.repositories.UserRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.time.Instant;
import java.util.Date;

@Controller
public class NoteController {
    private final NoteRepository noteDao;
    private final UserRepository userDao;
    private final JobApplicationRepository jobApplicationDao;

    public NoteController(NoteRepository noteDao, UserRepository userDao, JobApplicationRepository jobApplicationDao) {
        this.noteDao = noteDao;
        this.userDao = userDao;
        this.jobApplicationDao = jobApplicationDao;
    }

    @GetMapping("/notes/create")
    public String createNoteForm(Model model){
        model.addAttribute("note", new Note());
        return "/notes/create";
    }

    @PostMapping("/notes/create")
    public String createNote(@ModelAttribute Note note, @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss") Date fromDate){

        // JobApplication jobApplication = (JobApplication) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        note.setJobApplication(jobApplicationDao.findById(1));
        note.setDate(fromDate);

        noteDao.save(note);
        return "redirect:/notes/index";
    }


    @GetMapping("/notes/edit")
    public String takeToEditProfileForm (Model model){
//        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        model.addAttribute("user", currentUser);
        return "/notes/edit";
    }

    @PostMapping("/notes/{id}/edit")
    public String saveEditsOnProfile (@PathVariable long id, Model model, @ModelAttribute JobApplication jobApplication){
        JobApplication jobApp = jobApplicationDao.getById(id);

//        User userFromDb = usersDao.getById(id);
//        user.setId(id);
//        user.setPassword(userFromDb.getPassword());
//        user.setGender(userFromDb.getGender());
//        usersDao.save(user);
//
////      User details code updates the new saved user information into user details for the front end to have access to it
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User userDetails = (User) authentication.getPrincipal();
//        userDetails.setUsername(user.getUsername());
//        userDetails.setEmail(user.getEmail());
//        userDetails.setPassword(user.getPassword());
//        userDetails.setGender(user.getGender());
//        userDetails.setAge(user.getAge());
//        userDetails.setLocation(user.getLocation());

        return "redirect:/profile";
    }

    @GetMapping("/notes/index")
    public String viewNotes(Model model) {
        model.addAttribute("notes", noteDao.findAll());
        return "/notes/index";
    }

    @PostMapping("/notes/delete/{id}")
    public String deleteNote(@PathVariable long id){
//        noteDao.delete(noteDao.findById(id));
        noteDao.deleteById(id);
        return "redirect:/notes/index";
    }

}
