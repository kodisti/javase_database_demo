package hu.ulyssys.java.course.database.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "student")
public class Student extends AbstractPerson implements Serializable {

    @Column(name = "friends_number")
    private int friendsNumber;

    public int getFriendsNumber() {
        return friendsNumber;
    }

    public void setFriendsNumber(int friendsNumber) {
        this.friendsNumber = friendsNumber;
    }
}
