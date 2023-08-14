package org.koreait.tests;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.koreait.controllers.BoardForm;
import org.koreait.models.board.BoardSaveService;
import org.koreait.models.board.DeleteService;
import org.koreait.models.board.InfoService;
import org.koreait.models.board.RequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@DisplayName("서버 프로그램 구현")
@TestPropertySource(locations = "classpath:application.properties")
public class BoardTest {


    private BoardForm boardForm;
    @Autowired
    private BoardSaveService boardSaveService;
    @Autowired
    private InfoService infoService;

    @Autowired
    private DeleteService deleteService;


    @BeforeEach
    void init() {
        boardForm = new BoardForm();
        boardForm.setPoster("사용자1");
        boardForm.setSubject("제목");
        boardForm.setContent("내용");
    }

    @Test
    @DisplayName("게시글 저장 테스트, 성공시 예외 없음")
    public void boardSaveTest() {
        assertDoesNotThrow(() -> {
            boardSaveService.save(boardForm);
        });
    }

    @Test
    @DisplayName("제목, 작성자, 내용에 값이 들어가지 않았을 때 RequestException 발생")
    public void boardRequirementTest1() {
        boardForm.setSubject(null);
        assertThrows(RequestException.class, () -> {
            boardSaveService.save(boardForm);
        });
        boardForm.setSubject("   ");
        assertThrows(RequestException.class, () -> {
            boardSaveService.save(boardForm);
        });
        boardForm.setPoster(null);
        assertThrows(RequestException.class, () -> {
            boardSaveService.save(boardForm);
        });
        boardForm.setPoster("   ");
        assertThrows(RequestException.class, () -> {
            boardSaveService.save(boardForm);
        });
        boardForm.setContent(null);
        assertThrows(RequestException.class, () -> {
            boardSaveService.save(boardForm);
        });
        boardForm.setContent("   ");
        assertThrows(RequestException.class, () -> {
            boardSaveService.save(boardForm);
        });
    }

    @Test
    @DisplayName("값 읽어오기 / id값이 null일 때 BadRequestException 발생")
    public void nullParameterTest() {
        long id = 23l;
        assertThrows(RequestException.class, () -> {
            infoService.get(id);
        });
    }

    @Test
    @DisplayName("board 삭제 테스트 - 성공 시 오류 없음")
    public void boardDeletTest(){
        assertDoesNotThrow(()->{
            deleteService.deleteBoard(2L);
        });
    }


}
