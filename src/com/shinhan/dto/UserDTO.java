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
	Integer user_id;
    String user_name;
    String user_pwd;
    String user_email;
    Date user_regdate;
    String user_active;
    String user_admin;
}