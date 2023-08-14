package org.koreait.models.board;

import org.koreait.controllers.BoardForm;
import org.koreait.validators.Validator;
import org.springframework.stereotype.Component;

@Component
public class SaveValidator implements Validator<BoardForm> {
    @Override
    public void check(BoardForm boardForm) {
        String poster = boardForm.getPoster();
        String subject = boardForm.getSubject();
        String content = boardForm.getContent();

        //필수항목 검증

        if (poster == null || poster.isBlank()) {
            throw new RequestException("작성자를 입력해주세요");
        }
        if (subject == null || subject.isBlank()) {
            throw new RequestException("제목을 입력해주세요");
        }
        if (content == null || content.isBlank()) {
            throw new RequestException("내용을 입력해주세요");
        }

    }
}
