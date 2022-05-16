package myy803.controllers;

import myy803.entities.Instructor;
import myy803.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/instructors")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    public InstructorController() {
    }

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping(value = "/list")
    public ModelAndView listInstructors() {
        ModelAndView mav = new ModelAndView("instructors/list_instructors");
        List<Instructor> instructors = instructorService.findAll();
        mav.addObject("instructors", instructors);
        return mav;
    }
}
