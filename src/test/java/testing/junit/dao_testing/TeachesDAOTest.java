package testing.junit.dao_testing;

import myy803.daos.relational.TeachesDAO;
import myy803.entities.relational.Teaches;
import myy803.entities.relational.TeachesId;
import myy803.services.relational.TeachesServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class TeachesDAOTest {

    @Mock
    TeachesDAO teachesDAO;

    @InjectMocks
    TeachesServiceImpl teachesServiceImpl;

    @Test
    public void teachesDAOAddsCourseTest() {
        TeachesId id = new TeachesId("Menios", "MockCourse");
        Teaches teaches = new Teaches(id);

        doReturn(teaches).when(teachesDAO).save(teaches);
        Teaches savedTeaches = teachesServiceImpl.saveTeaches(teaches);

        Assert.assertEquals(savedTeaches, teaches);
    }

    @Test
    public void teachesDAODeletesTeachesTest() {
        TeachesId id = new TeachesId("Menios", "MockCourse");
        Teaches teaches = new Teaches(id);

        doNothing().when(teachesDAO).deleteByTeachesId(id);
        teachesServiceImpl.deleteByCourseNameAndInstructorUsername("Menios", "MockCourse");

        TeachesId id2 = new TeachesId("Menios", "MockCourseNot");
        List<Teaches> teachesList = new ArrayList<Teaches>();
        teachesList.add(new Teaches(id2));

        doReturn(teachesList).when(teachesDAO).findByTeachesIdInstructorUsername("Menios");
        List<Teaches> foundTeaches = teachesServiceImpl.findByInstructorUsername("Menios");

        Assert.assertEquals(teachesList, foundTeaches);
    }

}
