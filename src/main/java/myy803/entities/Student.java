package myy803.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
@Entity
@Table (name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="firstname")
    private String firstname;
    @Column(name="lastname")
    private String lastname;
    @Column(name="year_of_registration")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date yearOfRegistration;

    public Student(Integer id, String firstname, String lastname, Date yearOfRegistration) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.yearOfRegistration = yearOfRegistration;
    }

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getYearOfRegistration() {
        return yearOfRegistration;
    }

    public void setYearOfRegistration(Date yearOfRegistration) {
        System.err.println(yearOfRegistration);
        this.yearOfRegistration = yearOfRegistration;
    }

    public String toString()
    {
        return this.id.toString() + " " + this.firstname + " " + this.lastname + " " + this.yearOfRegistration.toString();
    }
}
