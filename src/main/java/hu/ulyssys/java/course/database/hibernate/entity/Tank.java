package hu.ulyssys.java.course.database.hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tank")
public class Tank extends AbstractEntity implements Serializable {


    @Column(name = "type")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
