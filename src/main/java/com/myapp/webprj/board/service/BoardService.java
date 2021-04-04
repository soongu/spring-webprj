package com.myapp.webprj.board.service;

import com.myapp.webprj.board.domain.Board;

import java.util.List;

public interface BoardService  {
    void register(Board board);

    Board get(Long bno);

    boolean modify(Board board);

    boolean remove(Long bno);

    List<Board> getList();
}
