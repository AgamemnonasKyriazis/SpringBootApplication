package myy803.services;

import myy803.entities.Instructor;

import java.util.List;


public interface InstructorService {
	
	Instructor saveInstructor(Instructor instructor);

	List<Instructor> findAll();

}
