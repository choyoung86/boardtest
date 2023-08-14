package org.koreait.models.board;

import org.koreait.controllers.BoardForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class BoardDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean insert(BoardForm boardForm) {
        String sql = "INSERT INTO BOARD_DATA (ID, POSTER, SUBJECT, CONTENT) "
                + " VALUES (BOARD_DATA_SEQ.nextval, ?, ?, ?)";
        int cnt = jdbcTemplate.update(sql, boardForm.getPoster(), boardForm.getSubject(), boardForm.getContent());
        return cnt > 0;
    }

    public BoardData get(long id) {
        String sql = "SELECT * FROM BOARD_DATA WHERE ID = ?";
        BoardData board = jdbcTemplate.queryForObject(sql, this::BoardMapper, id);

        return board;
    }

    private BoardData BoardMapper(ResultSet rs, int i) throws SQLException {
        BoardData board = new BoardData();
        board.setId(rs.getLong("ID"));
        board.setPoster(rs.getString("POSTER"));
        board.setSubject(rs.getString("SUBJECT"));
        board.setContent(rs.getString("CONTENT"));
        board.setRegDt(rs.getTimestamp("REGDT").toLocalDateTime());

        return board;
    }

    public List<BoardData> getList() {
        String sql = "SELECT * FROM BOARD_DATA ORDER BY REGDT DESC";
        List<BoardData> boards = new ArrayList<>();
        boards = jdbcTemplate.query(sql, this::BoardMapper);

        return boards;
    }

    public boolean delete(Long id){
        String sql = "DELETE FROM BOARD_DATA WHERE ID = ?";

        int cnt = jdbcTemplate.update(sql, id);

        return cnt > 0;
    }
}
