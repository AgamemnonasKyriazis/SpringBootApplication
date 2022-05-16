package myy803.entities.relational;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AttendsWithGradeId implements Serializable {

    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "course_name")
    private String courseName;

    public AttendsWithGradeId() {

    }

    public AttendsWithGradeId(Integer studentId, String courseName) {
        this.studentId = studentId;
        this.courseName = courseName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
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
        if (!(o instanceof AttendsWithGradeId)) return false;
        AttendsWithGradeId that = (AttendsWithGradeId) o;
        return Objects.equals(studentId, that.studentId) && Objects.equals(courseName, that.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, courseName);
    }
}
