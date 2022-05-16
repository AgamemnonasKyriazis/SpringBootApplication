package myy803.services;

import myy803.entities.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student saveStudent(Student student);

    List<Student> findAll();

    Optional<Student> findById(Integer id);

    void deleteById(Integer id);
}
