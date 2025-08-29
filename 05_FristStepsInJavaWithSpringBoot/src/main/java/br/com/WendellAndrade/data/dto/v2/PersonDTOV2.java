package br.com.WendellAndrade.data.dto.v2;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class PersonDTOV2 implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String fristName;
    private String lastName;
    private String andress;
    private String gender;
    private Date birthDay;

    public PersonDTOV2() {}

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

    public Date getBirthDay() { return birthDay; }

    public void setBirthDay(Date birthDay) {this.birthDay = birthDay; }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PersonDTOV2 that)) return false;
        return getId() == that.getId() && Objects.equals(getFristName(), that.getFristName()) && Objects.equals(getLastName(), that.getLastName()) && Objects.equals(getAndress(), that.getAndress()) && Objects.equals(getGender(), that.getGender()) && Objects.equals(getBirthDay(), that.getBirthDay());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFristName(), getLastName(), getAndress(), getGender(), getBirthDay());
    }
}
