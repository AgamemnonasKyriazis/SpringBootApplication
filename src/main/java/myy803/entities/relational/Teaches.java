package myy803.entities.relational;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="teaches")
public class Teaches {

    @EmbeddedId
    private TeachesId teachesId;

    public Teaches() {
    }

    public Teaches(TeachesId teachesId) {
        this.teachesId = teachesId;
    }

    public TeachesId getTeachesId() {
        return teachesId;
    }

    public void setTeachesId(TeachesId teachesId) {
        this.teachesId = teachesId;
    }
}
