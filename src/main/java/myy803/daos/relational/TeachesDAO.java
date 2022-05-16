package myy803.daos.relational;

import myy803.entities.relational.Teaches;
import myy803.entities.relational.TeachesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeachesDAO extends JpaRepository<Teaches, TeachesId> {

    List<Teaches> findByTeachesIdInstructorUsername(String instructorUsername);

    void deleteByTeachesId(TeachesId teachesId);
}
