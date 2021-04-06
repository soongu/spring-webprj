package com.myapp.webprj.board.service;

import com.myapp.webprj.board.domain.Board;
import com.myapp.webprj.paging.Criteria;

import java.util.List;

public interface BoardService {
    void register(Board board);

    Board get(Long bno);

    boolean modify(Board board);

    boolean remove(Long bno);

    //    List<Board> getList();
    List<Board> getList(Criteria cri);
    int getTotal(Criteria cri);
}
