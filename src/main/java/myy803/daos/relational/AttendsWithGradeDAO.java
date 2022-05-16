package myy803.daos.relational;

import myy803.entities.relational.AttendsWithGrade;
import myy803.entities.relational.AttendsWithGradeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendsWithGradeDAO extends JpaRepository<AttendsWithGrade, AttendsWithGradeId> {

    List<AttendsWithGrade> findByAttendsWithGradeIdCourseName(String courseName);

    void deleteByAttendsWithGradeId(AttendsWithGradeId attendsWithGradeId);

    AttendsWithGrade findByAttendsWithGradeId(AttendsWithGradeId attendsWithGradeId);
}
