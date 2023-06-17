package rw.ac.rca.webapp.orm;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "parent")
public class Parent implements Serializable {
    private static final long serialVersionUID = -8680703317249517930L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Parent() {

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private String  phoneNumber;

    public Parent(String firstName,String lastName, String phoneNumber, Date dateOfBirth, String email, String gender, int nid){
        this.firstName=firstName;
        this.lastName=lastName;
        this.phoneNumber=phoneNumber;
        this.dateOfBirth=dateOfBirth;
        this.email=email;
        this.gender=gender;
        this.nid=nid;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }


    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private int age;
    private String email;
    private String gender;
    private  int nid;
}
