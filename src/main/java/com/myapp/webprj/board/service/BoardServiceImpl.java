package com.myapp.webprj.board.service;

import com.myapp.webprj.board.domain.Board;
import com.myapp.webprj.board.mapper.BoardMapper;
import com.myapp.webprj.paging.Criteria;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    @Override
    public void register(Board board) {
       log.info("register...." + board);
       boardMapper.save(board);
    }

    @Override
    public Board get(Long bno) {
        return boardMapper.findByBno(bno);
    }

    @Override
    public boolean modify(Board board) {
        return boardMapper.update(board) == 1;
    }

    @Override
    public boolean remove(Long bno) {
        return boardMapper.delete(bno) == 1;
    }

    @Override
    public List<Board> getList(Criteria cri) {
        return boardMapper.getListWithPaging(cri);
    }

    @Override
    public int getTotal(Criteria cri) {
        return boardMapper.getTotalCount(cri);
    }

}
