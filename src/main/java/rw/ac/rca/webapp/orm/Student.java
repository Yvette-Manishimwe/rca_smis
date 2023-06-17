package rw.ac.rca.webapp.orm;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -8680703317249517930L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private boolean isInternational;

	private boolean isPartTime;

	private boolean isRepeating;

	public Student() {

	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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




	private Date dateOfBirth;
	private String firstName;
	private String lastName;

	private String email;
	private String gender;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	private String phoneNumber;

//	public Student(String firstName, String lastName, Date dateOfBirth, int phoneNumber, String email, boolean b, boolean b1, boolean b2) {
//	}

	public Student(String firstName, String lastName, Date dateOfBirth, String email, String gender, String phoneNumber,Address address, boolean isRepeating, boolean isInternational, boolean isPartTime){
		this.address = address;
		this.firstName=firstName;
		this.lastName=lastName;
		this.dateOfBirth=dateOfBirth;
		this.email=email;
		this.gender=gender;
		this.isRepeating = isRepeating;
		this.isInternational = isInternational;
		this.isPartTime = isPartTime;
		this.phoneNumber=phoneNumber;
	}

	@OneToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "student")
	private List<Enrol> enrols;

	@ManyToOne
	@JoinColumn(name = "address_id")
	private Address address;

//	public Student(Long studentid) {
//		this.setId(studentid);
//	}


	public List<Enrol> getEnrols() {
		return enrols;
	}
	public void setEnrollments(List<Enrol> enrols) {
		this.enrols = enrols;
	}

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

//	public void setGender(String gender) {
//		this.gender = gender;
//	}
//
//	public int getIsInternational() {
//		return isInternational;
//	}

//	public void setIsInternational(int isInternational) {
//		this.isInternational = isInternational;
//	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

// @Override
// String getAllNames() {
//    return getFirstName()+ " "+ getLastName();
// }

}