package com.myapp.webprj.board.mapper;

import com.myapp.webprj.board.domain.Board;
import com.myapp.webprj.paging.Criteria;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<Board> getList();

    //페이징
    List<Board> getListWithPaging(Criteria cri);
    int getTotalCount(Criteria cri);

    void save(Board board);

    Board findByBno(Long bno);

    int delete(Long bno);

    int update(Board board);

}
