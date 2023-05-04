import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import zzyzzy.spring4mvc.semiprojectv4.model.Member;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/root-context.xml"})
public class MemberDAOTest {

    @Autowired SqlSession sqlSession;

    @Test
    public void selectLogin() {
        Member m = new Member();
        m.setUserid("abc123");
        m.setPasswd("abc123");
        assertEquals(1, (int)sqlSession.selectOne("member.selectLogin", m));

        m.setUserid("abc123a");
        m.setPasswd("abc123a");
        assertEquals(0, (int)sqlSession.selectOne("member.selectLogin", m));
    }

}
