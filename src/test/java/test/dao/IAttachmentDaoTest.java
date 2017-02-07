package test.dao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.dao.mysql.IAttachmentDao;
import com.po.IAttachment;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class IAttachmentDaoTest {

	@Autowired
	private IAttachmentDao iAttachmentDao;


	@Test
	public void getIAttachmentTest(){
//		ApplicationContext ctx =
//				new ClassPathXmlApplicationContext("applicationContext.xml");
//		IAttachmentDao iAttachmentDao = ctx.getBean(IAttachmentDao.class);
		List<IAttachment> list = iAttachmentDao.getIAttachment();
		System.out.println("the result is :" + list.get(0) + "结果");
	}


}
