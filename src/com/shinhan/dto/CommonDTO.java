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
	private Integer user_id;
	private String user_name;
	
	private Integer board_id;
	private String board_title;
	private String board_content;
	private Date board_udtdate;
	
	private Integer comment_id;
	private String comment_content;
}
