package postgres.basic.demo.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ContactDTO {

	@NotNull(message = "Mobile number cannot be null")
	@Pattern(regexp = "^[1-9][0-9]{9}$", message = "Invalid mobile number")
	private String mobileNum;

	public String getMobileNum() {
		return mobileNum;
	}
	
}
