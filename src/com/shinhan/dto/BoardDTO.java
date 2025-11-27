package com.shinhan.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter
@NoArgsConstructor
public class BoardDTO {
    private Integer board_id;
    private String board_title;
    private String board_content;
    private Date board_regdate;
    private Date board_udtdate;
    private Integer board_view;
    private String board_active;
    private Integer board_user_id;
}
