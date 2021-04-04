package com.myapp.webprj.board.mapper;

import org.apache.ibatis.jdbc.SQL;

public class BoardSQL {

    public String findAll() {

        return new SQL()
                .SELECT("*")
                .FROM("tbl_board")
                .WHERE("bno > 0")
                .toString();
    }
}
