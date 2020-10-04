package postgres.basic.demo.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class DemographicsDTO {
	
	@NotNull(message = "Address 1 is mandatory")
	private String address1;
	
	@NotNull(message = "Address 2 is mandatory")
	private String address2;
	
	@NotNull(message = "Pin code is mandatore")
	@Pattern(regexp = "^[1-9][0-9]{5}$")
	private String pinCode;
	
	public String getAddress1() {
		return address1;
	}
	public String getAddress2() {
		return address2;
	}
	public String getPinCode() {
		return pinCode;
	}

}
