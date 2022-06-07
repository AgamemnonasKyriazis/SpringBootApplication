package myy803.entities;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table (name="courses")
public class Course {

    @Id
    @Column(name="courseName")
    private String courseName;
    @Column(name="semester")
    private Integer semester;
    @Column(name="description")
    private String description;

    public Course(String courseName, Integer semester, String description) {
        this.courseName = courseName;
        this.semester = semester;
        this.description = description;
    }

    public Course() {

    }

    public String getCourseName() { return courseName; }

    public void setCourseName(String courseName) { this.courseName = courseName; }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String toString() {
    	return this.courseName;
    }
}
