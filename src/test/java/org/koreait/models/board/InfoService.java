package org.koreait.models.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InfoService {
    private final BoardDao boardDao;
    public BoardData get(long id){
        BoardData data=boardDao.get(id);

        return data;
    }
}
