package testing.junit.dao_testing;

import myy803.daos.CourseDAO;
import myy803.entities.Course;
import myy803.services.CourseServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class CourseDAOTest {

    @Mock
    CourseDAO courseDAO;

    @InjectMocks
    CourseServiceImpl courseServiceImpl;

    @Test
    public void testCourseDAOReturnsCorrectCourse(){
        Course course = new Course("MockCourse", 6, "...");

        doReturn(course).when(courseDAO).findByCourseName("MockCourse");
        Course foundCourse = courseServiceImpl.findByCourseName(course.getCourseName());

        Assert.assertEquals(course.getCourseName(), foundCourse.getCourseName());
    }

    @Test
    public void testCourseDAODeletesCorrectCourse(){
        Course course = new Course("MockCourse", 6, "...");

        doNothing().when(courseDAO).deleteByCourseName("MockCourse");
        courseDAO.deleteByCourseName("MockCourse");

        doReturn(null).when(courseDAO).findByCourseName("MockCourse");
        Course foundCourse = courseServiceImpl.findByCourseName(course.getCourseName());

        Assert.assertNull(foundCourse);
    }

}
