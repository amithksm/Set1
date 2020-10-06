package postgres.basic.demo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class StudentEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_id")
    private Long id;
	
	private String name;
	
	@Column(name = "roll_number")
	private Integer rollNum;
	
	@Column(length = 1)
	private String gender;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	//mappedBy = "student" refers to the Class member student in the DemgraphicsEntity.class
    private Set<DemographicsEntity> address;
	
	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	//mappedBy = "student" refers to the Class member student in the ContactEntity.class
	private ContactEntity contactInfo;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRollNum() {
		return rollNum;
	}
	public void setRollNum(Integer rollNum) {
		this.rollNum = rollNum;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Set<DemographicsEntity> getAddress() {
		return address;
	}
	public void setAddress(Set<DemographicsEntity> address) {
		this.address = address;
	}
	public ContactEntity getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(ContactEntity contactInfo) {
		this.contactInfo = contactInfo;
	}
	
	
}
