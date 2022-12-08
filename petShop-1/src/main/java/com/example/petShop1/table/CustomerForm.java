package com.example.petShop1.table;

import javax.validation.constraints.NotEmpty;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerForm {
	//private Integer userNo;
	
	@NotEmpty
    private String id;

    @NotEmpty
    private String password;
    
    @NotEmpty
    private String name;
    
    
    private String birth;
    
    
    private String gender;
    
    @NotEmpty
    private String email;
    
    @NotEmpty
    private String pon;
}
