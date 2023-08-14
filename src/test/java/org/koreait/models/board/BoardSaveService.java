package org.koreait.models.board;

import lombok.RequiredArgsConstructor;
import org.koreait.controllers.BoardForm;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

@Service
@RequiredArgsConstructor
public class BoardSaveService {
    private final BoardDao boardDao;
    private final SaveValidator saveValidator;

    public void save(BoardForm boardForm){
        save(boardForm, null);
    }

    public void save(BoardForm boardForm, Errors errors){
        if(errors != null && errors.hasErrors()){
            return;
        }
        saveValidator.check(boardForm);
        boardDao.insert(boardForm);
    }

}
