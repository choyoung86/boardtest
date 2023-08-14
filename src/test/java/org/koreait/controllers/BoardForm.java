package org.koreait.controllers;

import lombok.Data;

@Data
public class BoardForm {

    private long id;
    private String poster; //작성자
    private String subject; //제목
    private String content; //내용

}
