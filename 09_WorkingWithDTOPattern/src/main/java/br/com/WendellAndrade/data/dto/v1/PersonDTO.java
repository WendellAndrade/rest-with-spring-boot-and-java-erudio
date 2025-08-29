package br.com.WendellAndrade.data.dto.v1;

import java.io.Serializable;
import java.util.Objects;


public class PersonDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;

    private String fristName;

    private String lastName;

    private String andress;

    private String gender;

    public PersonDTO() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFristName() {
        return fristName;
    }

    public void setFristName(String fristName) {
        this.fristName = fristName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAndress() {
        return andress;
    }

    public void setAndress(String andress) {
        this.andress = andress;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PersonDTO person)) return false;
        return getId() == person.getId() && Objects.equals(getFristName(), person.getFristName()) && Objects.equals(getLastName(), person.getLastName()) && Objects.equals(getAndress(), person.getAndress()) && Objects.equals(getGender(), person.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFristName(), getLastName(), getAndress(), getGender());
    }
}
