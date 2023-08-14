package org.koreait.models.board;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardData {
    private long id;
    private String poster; //작성자
    private String subject; //제목
    private String content; //내용
    private LocalDateTime regDt;
}
