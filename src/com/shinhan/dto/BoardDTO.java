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
    Integer board_id;
    String board_title;
    String board_content;
    Date board_regdate;
    Date board_udtdate;
    Integer board_view;
    String board_active;
    Integer board_user_id;
}
