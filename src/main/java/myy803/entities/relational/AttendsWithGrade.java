package myy803.entities.relational;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="attends")
public class AttendsWithGrade {

    @EmbeddedId
    private AttendsWithGradeId attendsWithGradeId;

    @Column(name = "grade")
    private Float grade;

    public AttendsWithGrade(AttendsWithGradeId attendsWithGradeId, Float grade) {
        this.attendsWithGradeId = attendsWithGradeId;
        this.grade = grade;
    }

    public AttendsWithGrade() {
    }

    public AttendsWithGradeId getAttendsWithGradeId() {
        return attendsWithGradeId;
    }

    public void setAttendsWithGradeId(AttendsWithGradeId attendsWithGradeId) {
        this.attendsWithGradeId = attendsWithGradeId;
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }
}
