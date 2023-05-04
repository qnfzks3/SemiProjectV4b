package zzyzzy.spring4mvc.semiprojectv4.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import zzyzzy.spring4mvc.semiprojectv4.model.Board;

import java.util.List;

@Repository("bddao")
public class BoardDAOImpl implements BoardDAO {

    @Autowired private SqlSession sqlSession;

    @Override
    public List<Board> selectBoard(int stbno) {
        return sqlSession.selectList("board.selectBoard", stbno);
    }

}
