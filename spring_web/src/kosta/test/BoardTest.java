package kosta.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kosta.model.BoardDao;
import kosta.model.JNDIObject;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:WebContent/WEB-INF/springapp-servlet.xml"})
public class BoardTest {

	private BoardDao dao;
	
	@Autowired
	public void setDao(BoardDao dao) {
		this.dao = dao;
	}

	@BeforeClass   //테스트 하기전에 미리 실행되어야 할 것들
	public static void setUp()throws Exception{
		new JNDIObject().jndiBind();
	}
	
	

	@Test
	public void test() {
		assertEquals(10, dao.listBoard().size());    // listBoard로부터 가져온 데이터 갯수가 실제 디비에 있는 갯수와 같은지 테스트
	}

}
