package myy803.controllers;

import myy803.entities.Course;
import myy803.services.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    public CourseController() {
    }

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping(value = "/list")
    public ModelAndView listAllCourses() {
        ModelAndView mav = new ModelAndView("courses/list_courses");
        List<Course> courses = courseService.findAll();
        mav.addObject("courses", courses);
        return mav;
    }

    @GetMapping(value = "/add")
    public String addCourse(Model model) {
        model.addAttribute("course", new Course());
        return "courses/course_form";
    }

    @GetMapping(value = "/delete")
    public String deleteCourse(@RequestParam("courseName") String courseName) {
        courseService.deleteByCourseName(courseName);
        return "redirect:/courses/list";
    }

    @GetMapping(value = "update")
    public String updateCourse(@RequestParam("courseName") String courseName, Model model) {
        Course course = courseService.findByCourseName(courseName);
        model.addAttribute("course", course);
        return "courses/course_form";
    }

    @PostMapping(value = "/save")
    public String addCourse(@ModelAttribute Course course, Model model) {
        model.addAttribute("course", course);
        courseService.saveCourse(course);
        return "redirect:/courses/list";
    }
}
