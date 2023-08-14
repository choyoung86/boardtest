package org.koreait.tests;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.koreait.controllers.BoardForm;
import org.koreait.models.board.BoardDao;
import org.koreait.models.board.BoardData;
import org.koreait.models.board.BoardSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


@SpringBootTest
@DisplayName("서버 프로그램 구현")
public class BoardTest {

    private BoardForm boardForm;
    @Autowired
    private BoardSaveService boardSaveService;

    @BeforeEach
    void init(){
        boardForm=new BoardForm();
        boardForm.setPoster("사용자1");
        boardForm.setSubject("제목");
        boardForm.setContent("내용");
    }

    @Test
    @DisplayName("게시글 저장 테스트, 성공시 예외 없음")
    public void boardSaveTest(){
        assertDoesNotThrow(() -> {
            boardSaveService.save(boardForm);
        });
    }
}
