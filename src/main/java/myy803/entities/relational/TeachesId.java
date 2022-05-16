package myy803.entities.relational;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TeachesId implements Serializable {

    @Column(name = "instructor_username")
    private String instructorUsername;

    @Column(name = "course_name")
    private String courseName;

    public TeachesId() {

    }

    public TeachesId(String instructorUsername, String courseName) {
        this.instructorUsername = instructorUsername;
        this.courseName = courseName;
    }

    public String getInstructorUsername() {
        return instructorUsername;
    }

    public void setInstructorUsername(String instructorUsername) {
        this.instructorUsername = instructorUsername;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeachesId)) return false;
        TeachesId teachesId = (TeachesId) o;
        return Objects.equals(instructorUsername, teachesId.instructorUsername) && Objects.equals(courseName, teachesId.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instructorUsername, courseName);
    }
}
