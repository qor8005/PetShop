package com.example.petShop1.log;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//로그인 화면에 입력할거
@Getter
@Setter
@ToString
public class LoginInput {
	private String id;
	private String password;
}
