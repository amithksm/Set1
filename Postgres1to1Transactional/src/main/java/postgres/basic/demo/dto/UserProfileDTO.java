package postgres.basic.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
public class UserProfileDTO {
	
	private String fName;
	private String lName;
	private Integer age;

}
