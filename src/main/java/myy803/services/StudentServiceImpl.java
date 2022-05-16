package myy803.services;

import myy803.daos.StudentDAO;
import myy803.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    public StudentServiceImpl() {
    }

    @Override
    @Transactional
    public Student saveStudent(Student student) {
        return studentDAO.save(student);
    }

    @Override
    @Transactional
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    @Transactional
    public Optional<Student> findById(Integer id) {
        return studentDAO.findById(id);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        studentDAO.deleteById(id);
    }
}
