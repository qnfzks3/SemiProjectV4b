package zzyzzy.spring4mvc.semiprojectv4.dao;

import zzyzzy.spring4mvc.semiprojectv4.model.Board;

import java.util.List;

public interface BoardDAO {
    List<Board> selectBoard(int stbno);

    int countBoard();
}