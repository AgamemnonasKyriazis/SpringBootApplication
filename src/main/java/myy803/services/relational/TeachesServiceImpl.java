package myy803.services.relational;

import myy803.daos.relational.TeachesDAO;
import myy803.entities.relational.Teaches;
import myy803.entities.relational.TeachesId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeachesServiceImpl implements TeachesService {

    @Autowired
    private TeachesDAO teachesDAO;

    public TeachesServiceImpl() {
    }

    public TeachesServiceImpl(TeachesDAO teachesDAO) {
        this.teachesDAO = teachesDAO;
    }

    @Override
    @Transactional
    public Teaches saveTeaches(Teaches teaches) {
        return teachesDAO.save(teaches);
    }

    @Override
    @Transactional
    public List<Teaches> findAll() {
        return teachesDAO.findAll();
    }

    @Override
    @Transactional
    public List<Teaches> findByInstructorUsername(String instructorUsername) {
        return teachesDAO.findByTeachesIdInstructorUsername(instructorUsername);
    }

    @Override
    @Transactional
    public void deleteByCourseNameAndInstructorUsername(String courseName, String username) {
        teachesDAO.deleteByTeachesId(new TeachesId(courseName, username));
    }
}
