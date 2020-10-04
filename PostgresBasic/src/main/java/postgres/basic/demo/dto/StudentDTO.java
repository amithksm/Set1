package postgres.basic.demo.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class StudentDTO {
	
	@NotBlank(message = "name should not be blank")
	@Size(min = 3, max = 12)
	private String name;
	
	@Min(value = 1, message = "roll num should be in range 1 to 100")
	@Max(value = 100, message = "roll num should be in range 1 to 100")
	private Integer rollNum;
	
	@Size(min = 1, max = 1, message = "gender should be one char long. M, F or T")
	@Pattern(regexp = "[M|F|T]")
	private String gender;
	
	
	
	public String getName() {
		return name;
	}
	public Integer getRollNum() {
		return rollNum;
	}
	public String getGender() {
		return gender;
	}
	
}
