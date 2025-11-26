package com.shinhan.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter
@NoArgsConstructor
public class DTO {

	Integer user_id;
    String user_name;
    String user_pwd;
    String user_email;
    Date user_regdate;
    String user_active;

    Integer post_id;
    String post_title;
    String post_content;
    Date post_regdate;
    Date post_udtdate;
    Integer post_view;
    String post_active;
    Integer post_user_id;
}
