package testing.junit.dao_testing;

import myy803.daos.relational.AttendsWithGradeDAO;
import myy803.entities.relational.AttendsWithGrade;
import myy803.entities.relational.AttendsWithGradeId;
import myy803.services.relational.AttendsWithGradeServiceImpl;
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
public class AttendsWithGradeDAOTest {

    @Mock
    AttendsWithGradeDAO attendsWithGradeDAO;

    @InjectMocks
    AttendsWithGradeServiceImpl attendsWithGradeServiceImpl;

    @Test
    public void attendsWithGradeDAOReturnsCorrectObject() {
        AttendsWithGradeId id = new AttendsWithGradeId(0, "MockCourse");
        AttendsWithGrade attendsWithGrade = new AttendsWithGrade(id, 4.5F);

        doReturn(attendsWithGrade).when(attendsWithGradeDAO).findByAttendsWithGradeId(id);
        AttendsWithGrade foundAttendsWithGrade = attendsWithGradeServiceImpl.findByStudentIdAndCourseName(id.getStudentId(), id.getCourseName());

        Assert.assertEquals(attendsWithGrade.getAttendsWithGradeId(), foundAttendsWithGrade.getAttendsWithGradeId());
    }

    @Test
    public void attendsWithGradeDAOReturnsCorrectObjects() {
        List<AttendsWithGrade> attendsWithGradeList = new ArrayList<AttendsWithGrade>();
        attendsWithGradeList.add(new AttendsWithGrade(new AttendsWithGradeId(0, "MockCourse"), 4.5F));
        attendsWithGradeList.add(new AttendsWithGrade(new AttendsWithGradeId(1, "MockCourse"), 1.F));
        attendsWithGradeList.add(new AttendsWithGrade(new AttendsWithGradeId(2, "MockCourseNot"), 9.f));

        doReturn(attendsWithGradeList).when(attendsWithGradeDAO).findByAttendsWithGradeIdCourseName("MockCourse");
        List<AttendsWithGrade> foundAttendsWithGradeList = attendsWithGradeServiceImpl.findByCourseName("MockCourse");

        Assert.assertEquals(attendsWithGradeList.subList(0, 1), foundAttendsWithGradeList.subList(0, 1));
    }

    @Test
    public void attendsWithGradeDAODeletesCorrectObject() {
        AttendsWithGradeId id = new AttendsWithGradeId(0, "MockCourse");
        AttendsWithGrade attendsWithGrade = new AttendsWithGrade(id, 4.5F);

        doNothing().when(attendsWithGradeDAO).deleteByAttendsWithGradeId(id);
        attendsWithGradeServiceImpl.deleteByStudentIdAndCourseName(0,"MockCourse");

        doReturn(null).when(attendsWithGradeDAO).findByAttendsWithGradeId(id);
        AttendsWithGrade foundAttendsWithGrade = attendsWithGradeServiceImpl.findByStudentIdAndCourseName(0, "MockCourse");

        Assert.assertNull(foundAttendsWithGrade);
    }
}
