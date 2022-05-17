package myy803.controllers;

import myy803.entities.Instructor;
import myy803.services.InstructorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MyApplicationController {

    @Autowired
    private InstructorService instructorService;

    public MyApplicationController() {
    }

    public MyApplicationController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping(value = "/register")
    public String showInstructorRegisterForm(Model model) {
        model.addAttribute("instructor", new Instructor());
        return "/register";
    }

    @PostMapping(value = "/register")
    public String registerInstructor(@ModelAttribute Instructor instructor, Model model) {
        model.addAttribute("instructor", instructor);
        instructorService.saveInstructor(instructor);
        return "redirect:/";
    }

    @GetMapping("/about")
    public String about(){
        return "/about";
    }

    @GetMapping("/error")
    public String error() {
        return "/error";
    }
}
