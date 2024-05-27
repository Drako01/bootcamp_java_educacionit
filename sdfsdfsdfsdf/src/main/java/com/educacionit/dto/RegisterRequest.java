package com.educacionit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
	
    private String email;
    private String fullname;
    private String password;
}
