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
	private Integer comment_id;
	private String comment_content;
    private Date comment_regdate;
    private Date comment_udpdate;
    private String comment_active;
    private Integer comment_user_id;
    private Integer comment_board_id;
}
