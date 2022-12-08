package com.example.petShop1.log;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

//로그인상태 유지하는 기능
@AllArgsConstructor //생성자를 자동으로 만들어줌
@Getter
@Setter
@ToString
public class UserInfo implements Serializable {
	private static final long serialVersionUID = -8057753246777826249L;
	private String id;
	private String password;
}
