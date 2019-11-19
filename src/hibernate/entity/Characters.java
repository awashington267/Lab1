package hibernate.entity;

import javax.validation.constraints.NotNull;


import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
@Table(name="characters")
public class Characters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "char_id")
    private int characterID;

    @NotNull(message = "required")
    @Size()
    @Column(name = "char_nm")
    private String name;

    @ManyToOne(cascade={CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name="class_id")
    private Class classID;

    @Column(name = "pic")
    private String picture;

    @Column(name = "sex")
    private String sex;

    @Column(name = "description")
    private String description;



    public Characters() {
    }

    public Characters(String name, String picture, String sex, String description) {

        this.name = name;

        this.picture = picture;
        this.sex = sex;
        this.description = description;
    }

    public int getCharacterID() {
        return characterID;
    }

    public void setCharacterID(int characterID) {
        this.characterID = characterID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getClassID() {
        return classID;
    }

    public void setClassID(Class classID) {
        this.classID = classID;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Characters{" +
                "characterID=" + characterID +
                ", name='" + name + '\'' +
                ", classID=" + classID +
                ", picture='" + picture + '\'' +
                ", sex='" + sex + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
