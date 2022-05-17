package myy803.services.relational;

import myy803.entities.relational.AttendsWithGradeId;
import myy803.daos.relational.AttendsWithGradeDAO;
import myy803.entities.relational.AttendsWithGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AttendsWithGradeServiceImpl implements AttendsWithGradeService {

    @Autowired
    private AttendsWithGradeDAO attendsWithGradeDAO;

    public AttendsWithGradeServiceImpl() {

    }

    public AttendsWithGradeServiceImpl(AttendsWithGradeDAO attendsWithGradeDAO) {
        this.attendsWithGradeDAO = attendsWithGradeDAO;
    }

    @Override
    @Transactional
    public AttendsWithGrade saveAttendsWithGrade(AttendsWithGrade attendsWithGrade) {
        return attendsWithGradeDAO.save(attendsWithGrade);
    }

    @Override
    @Transactional
    public List<AttendsWithGrade> findAll() {
        return attendsWithGradeDAO.findAll();
    }

    @Override
    @Transactional
    public List<AttendsWithGrade> findByCourseName(String courseName) {
        return attendsWithGradeDAO.findByAttendsWithGradeIdCourseName(courseName);
    }

    @Override
    @Transactional
    public void deleteByStudentIdAndCourseName(Integer studentId, String courseName) {
        attendsWithGradeDAO.deleteByAttendsWithGradeId(new AttendsWithGradeId(studentId, courseName));
    }

    @Override
    public AttendsWithGrade findByStudentIdAndCourseName(Integer studentId, String courseName) {
        return attendsWithGradeDAO.findByAttendsWithGradeId(new AttendsWithGradeId(studentId, courseName));
    }

}
