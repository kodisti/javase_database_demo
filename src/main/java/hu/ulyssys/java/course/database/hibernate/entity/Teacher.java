package hu.ulyssys.java.course.database.hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "teacher")
public class Teacher extends AbstractPerson implements Serializable {

    @Column(name = "courses_number")
    private int coursesNumber;

    public int getCoursesNumber() {
        return coursesNumber;
    }

    public void setCoursesNumber(int coursesNumber) {
        this.coursesNumber = coursesNumber;
    }
}
