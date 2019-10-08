package spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import spring.services.IQuote;

@Component
public class Character {
    @Value("${c1.id}")
    private int characterID;
    @Value("${c1.name}")
    private String name;
    private  int classID;
    private String picture;
    private String sex;
    private String description;
    @Autowired
    private IQuote quotes;

    public void setQuotes(IQuote quotes) {
        this.quotes = quotes;
    }

    public Character() {
        this.characterID = characterID;
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

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
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
}
