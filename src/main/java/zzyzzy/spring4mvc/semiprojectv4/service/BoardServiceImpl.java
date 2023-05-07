package zzyzzy.spring4mvc.semiprojectv4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zzyzzy.spring4mvc.semiprojectv4.dao.BoardDAO;
import zzyzzy.spring4mvc.semiprojectv4.model.Board;

import java.util.List;

@Service("bdsrv")
public class BoardServiceImpl implements BoardService {

    @Autowired private BoardDAO bddao;

    @Override
    public List<Board> readBoard(int cpage) {
        int stbno = (cpage - 1) * 25;
        return bddao.selectBoard(stbno);
    }

    @Override
    public int countBoard() {
        return bddao.countBoard();
    }
}