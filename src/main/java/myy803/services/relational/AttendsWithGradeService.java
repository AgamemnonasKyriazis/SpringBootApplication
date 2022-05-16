package myy803.services.relational;

import myy803.entities.relational.AttendsWithGrade;

import java.util.List;

public interface AttendsWithGradeService {

    AttendsWithGrade saveAttendsWithGrade(AttendsWithGrade attendsWithGrade);

    List<AttendsWithGrade> findAll();

    List<AttendsWithGrade> findByCourseName(String courseName);

    void deleteByStudentIdAndCourseName(Integer studentId, String courseName);

    AttendsWithGrade findByStudentIdAndCourseName(Integer studentId, String courseName);
}
