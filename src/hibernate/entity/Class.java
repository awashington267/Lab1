package hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "class")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private int classID;

    @Column(name = "class_nm")
    private String role;

    public Class() {
    }

    public Class(String role) {
        this.role = role;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Class{" +
                "classID=" + classID +
                ", role='" + role + '\'' +
                '}';
    }
}
