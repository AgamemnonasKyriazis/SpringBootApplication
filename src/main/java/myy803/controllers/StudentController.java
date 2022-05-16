package myy803.controllers;

import myy803.entities.Student;
import myy803.services.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/list")
    public ModelAndView listStudents() {
        ModelAndView mav = new ModelAndView("students/list_students");
        List<Student> students = studentService.findAll();
        mav.addObject("students", students);
        return mav;
    }

    @GetMapping(value = "/add")
    public String addStudent(Model model) {
        model.addAttribute("student", new Student());
        return "students/student_form";
    }

    @GetMapping(value = "/delete")
    public String deleteStudent(@RequestParam("id") Integer id) {
        studentService.deleteById(id);
        return "redirect:/students/list";
    }

    @GetMapping(value = "/update")
    public String updateStudent(@RequestParam("id") Integer id, Model model) {
        Student student = studentService.findById(id).get();
        model.addAttribute("student", student);
        return "students/student_form";
    }

    @PostMapping("/save")
    public String updateStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students/list";
    }
}
