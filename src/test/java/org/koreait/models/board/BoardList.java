package org.koreait.models.board;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardList {
    private final BoardDao boardDao;

    public List<BoardData> getlist() {
        List<BoardData> boards = boardDao.getList();

        return boards;
    }
}
