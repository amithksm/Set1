package mongo.basic.demo.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Student")
public class StudentEntity {
	
	@Id
	String rollNum;
	String fName;
	String lName;
	
	@DBRef
	DemographicsEntity demographics;
	
	ProfileEntity profile;

	public String getRollNum() {
		return rollNum;
	}

	public void setRollNum(String rollNum) {
		this.rollNum = rollNum;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public DemographicsEntity getDemographics() {
		return demographics;
	}

	public void setDemographics(DemographicsEntity demographics) {
		this.demographics = demographics;
	}

	public ProfileEntity getProfile() {
		return profile;
	}

	public void setProfile(ProfileEntity profile) {
		this.profile = profile;
	}
	
}
