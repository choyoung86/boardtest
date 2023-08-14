package org.koreait.models.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteService {
    @Autowired
    private BoardDao boardDao;

    public void deleteBoard(Long id){
        boardDao.delete(id);
    }
}