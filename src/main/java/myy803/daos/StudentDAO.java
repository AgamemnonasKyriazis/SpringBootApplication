package myy803.daos;

import myy803.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLIntegrityConstraintViolationException;

@Repository
public interface StudentDAO extends JpaRepository<Student, Integer> {

    Student save(Student student);

    void deleteById(Integer id);

}
