package org.koreait.models.board;

import org.koreait.controllers.BoardForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class BoardDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean insert(BoardForm boardForm){
        String sql = "INSERT INTO BOARD_DATA (ID, POSTER, SUBJECT, CONTENT) "
                + " VALUES (BOARD_DATA_SEQ.nextval, ?, ?, ?)";
        int cnt = jdbcTemplate.update(sql, boardForm.getPoster(), boardForm.getSubject(), boardForm.getContent());
        return cnt > 0;
    }

}
