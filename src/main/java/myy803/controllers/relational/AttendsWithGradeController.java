package myy803.controllers.relational;

import myy803.entities.Student;
import myy803.entities.relational.AttendsWithGrade;
import myy803.services.StudentService;
import myy803.services.relational.AttendsWithGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping("/attends")
public class AttendsWithGradeController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private AttendsWithGradeService attendsWithGradeService;

    public AttendsWithGradeController() {
    }

    public AttendsWithGradeController(AttendsWithGradeService attendsWithGradeService) {
        this.attendsWithGradeService = attendsWithGradeService;
    }

    @GetMapping(value = "/attendants/list")
    public ModelAndView listStudentsByCourseName(@RequestParam(value="courseName") String courseName) {
        ModelAndView mav = new ModelAndView("attends/list_students");
        List<AttendsWithGrade> attendsWithGradeList = attendsWithGradeService.findByCourseName(courseName);
        Map<Student, Float> studentsWithGrades = new HashMap<Student, Float>();
        for(AttendsWithGrade attendsWithGrade : attendsWithGradeList) {
            Optional<Student> student = studentService.findById(attendsWithGrade.getAttendsWithGradeId().getStudentId());
            if(student.isPresent()) {
                studentsWithGrades.put(student.get(), attendsWithGrade.getGrade());
            }
        }
        mav.addObject("studentsWithGrades", studentsWithGrades);
        return mav;
    }

    @GetMapping(value = "/attendants/delete")
    public String deleteAttendant(@RequestParam("studentId") Integer studentId,
                                  @RequestParam("courseName") String courseName,
                                  Model model) {
        attendsWithGradeService.deleteByStudentIdAndCourseName(studentId, courseName);
        return "redirect:/attends/attendants/list?courseName="+courseName;
    }

    @GetMapping(value = "/attendants/add")
    public String addAttendant(Model model) {
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("attendsWithGrade", new AttendsWithGrade());
        return "attends/student_form";
    }

    @GetMapping(value = "/attendants/update")
    public String updateAttendant(@RequestParam("studentId") Integer studentId,
                                  @RequestParam("courseName") String courseName,
                                  Model model) {
        AttendsWithGrade attendsWithGrade =
                attendsWithGradeService.findByStudentIdAndCourseName(studentId, courseName);
        model.addAttribute("attendsWithGrade", attendsWithGrade);
        return "attends/update_student_form";
    }

    @PostMapping(value = "/attendants/save")
    public String saveAttendant(@ModelAttribute AttendsWithGrade attendsWithGrade,
                                @RequestParam("courseName") String courseName,
                                Model model) {
        attendsWithGrade.getAttendsWithGradeId().setCourseName(courseName);
        model.addAttribute("attendsWithGrade", attendsWithGrade);
        attendsWithGradeService.saveAttendsWithGrade(attendsWithGrade);
        return "redirect:/attends/attendants/list?courseName="+courseName;
    }
}
