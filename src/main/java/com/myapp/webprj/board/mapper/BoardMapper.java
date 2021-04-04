package com.myapp.webprj.board.mapper;

import com.myapp.webprj.board.domain.Board;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<Board> getList();

    void save(Board board);

    Board findByBno(Long bno);

    int delete(Long bno);

    int update(Board board);

}
