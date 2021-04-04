package com.myapp.webprj.board.mapper;

import com.myapp.webprj.board.domain.Board;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class BoardMapperTest {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    void testGetList() {
        boardMapper.getList().forEach(board -> System.out.println(board));
    }

    @Test
    void testInsert() {
        Board board = new Board();
        board.setTitle("새로운 글");
        board.setContent("야야야야하하하");
        board.setWriter("홍길동");

        boardMapper.save(board);
    }

    @Test
    void testSelectOne() {
        Board byBno = boardMapper.findByBno(5L);
        System.out.println("byBno = " + byBno);
    }

    @Test
    void testDelete() {

        int delete = boardMapper.delete(6L);
        System.out.println("delete = " + delete);
    }

    @Test
    void testUpdate() {
        Board byBno = boardMapper.findByBno(4L);
        byBno.setWriter("수정맨");
        byBno.setTitle("수정수정");
        byBno.setContent("수정해버렷긔~~");
        boardMapper.update(byBno);
    }
}
