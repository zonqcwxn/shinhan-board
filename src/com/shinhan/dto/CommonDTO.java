package com.shinhan.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter
@NoArgsConstructor
public class CommonDTO {
	Integer user_id;
	String user_name;
	
	Integer board_id;
	String board_title;
	String board_content;
	Date board_udtdate;
	
	Integer comment_id;
	String comment_content;
}
