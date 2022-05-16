package myy803.services;

import java.util.List;

import myy803.daos.InstructorDAO;
import myy803.entities.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	private InstructorDAO instructorDAO;

	public InstructorServiceImpl() {
	}
	
	@Override
	@Transactional
	public Instructor saveInstructor(Instructor instructor) {
		return instructorDAO.save(instructor);
	}

	@Override
	@Transactional
	public List<Instructor> findAll() {
		return instructorDAO.findAll();
	}
}
