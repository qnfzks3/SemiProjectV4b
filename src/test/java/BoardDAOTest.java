import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import zzyzzy.spring4mvc.semiprojectv4.model.Board;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/root-context.xml"})
public class BoardDAOTest {

    @Autowired SqlSession sqlSession;

    @Test
    public void selectBoard() {
        assertNotNull( sqlSession.selectList("board.selectBoard") );
    }

    @Test
    public void selectFindBoard(){
        Map<String,Object> params = new HashMap<>();
        params.put("stbno", 0);
        params.put("ftype", "titcont");
        params.put("fkey", "석가");



        //System.out.println(sqlSession.selectList("board.selectFindBoard",params));

    }
    @Test
    public void countFindBoard(){
        Map<String,Object> params = new HashMap<>();
        params.put("ftype", "titcont");
        params.put("fkey", "석가");


        assertNotEquals(0,(int)sqlSession.selectOne("board.countFindBoard",params));
        //System.out.println(sqlSession.selectList("board.selectFindBoard",params));

    }

    @Test
    public void insertBoard(){
        Board b= new Board();
        b.setTitle("테스트를 해보쟈!테스트 테스트");
        b.setUserid("abc123");
        b.setContent("테스트~랍니다 테스트 아아 !!");
        assertEquals(1,(int)sqlSession.insert("board.insertBoard",b));

    }


}
