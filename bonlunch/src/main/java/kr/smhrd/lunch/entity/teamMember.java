package kr.smhrd.lunch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class teamMember {

	@NonNull
	String name;
	
	int age;
	
	String gender;
}
