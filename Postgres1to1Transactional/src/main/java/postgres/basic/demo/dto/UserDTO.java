package postgres.basic.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class UserDTO {
	
	private String uName;
	private String password;
	private Integer age;
	private String fName;
	private String lName;

}
