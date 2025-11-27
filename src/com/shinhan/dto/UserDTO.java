package com.shinhan.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter
@NoArgsConstructor
public class UserDTO {
	private Integer user_id;
    private String user_name;
    private String user_pwd;
    private String user_email;
    private Date user_regdate;
    private String user_active;
    private String user_admin;
}