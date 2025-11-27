package com.shinhan.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter
@NoArgsConstructor
public class CommentDTO {
	Integer comment_id;
	String comment_content;
    Date comment_regdate;
    Date comment_udpdate;
    String comment_active;
    Integer comment_user_id;
    Integer comment_board_id;
    Integer d;
}
