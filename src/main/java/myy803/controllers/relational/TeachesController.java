package myy803.controllers.relational;

import myy803.entities.Course;
import myy803.entities.relational.Teaches;
import myy803.services.CourseService;
import myy803.services.relational.TeachesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/teaches")
public class TeachesController {

    @Autowired
    private TeachesService teachesService;

    @Autowired
    private CourseService courseService;

    public TeachesController() {
    }

    public TeachesController(TeachesService teachesService, CourseService courseService) {
        this.teachesService = teachesService;
        this.courseService = courseService;
    }

    @GetMapping(value = "/my_courses/list")
    public ModelAndView listCourses() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        List<Teaches> myCoursesList = teachesService.findByInstructorUsername(username);
        Map<Course, Map<String, Double>> myCourses = new HashMap<Course, Map<String, Double>>();
        for(Teaches taughtCourse : myCoursesList)
        {
            Course course = courseService.findByCourseName(taughtCourse.getTeachesId().getCourseName());
            myCourses.put(course, courseService.getCourseStatistics(course));
        }
        ModelAndView mav = new ModelAndView("teaches/list_courses");
        mav.addObject("courses", myCourses);
        return mav;
    }

    @GetMapping(value = "my_courses/delete")
    public String deleteCourse(@RequestParam("courseName") String courseName) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        teachesService.deleteByCourseNameAndInstructorUsername(courseName, username);
        return "redirect:/teaches/my_courses/list";
    }

    @GetMapping(value = "my_courses/add")
    public String addCourse(Model model) {
        model.addAttribute("courses", courseService.findAll());
        model.addAttribute("teaches", new Teaches());
        return "/teaches/course_form";
    }

    @PostMapping(value = "my_courses/save")
    public String saveCourse(@ModelAttribute("teaches") Teaches teaches) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        teaches.getTeachesId().setInstructorUsername(username);
        teachesService.saveTeaches(teaches);
        return "redirect:/teaches/my_courses/list";
    }
}
