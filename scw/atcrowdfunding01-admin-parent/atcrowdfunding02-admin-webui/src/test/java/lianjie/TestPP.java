package lianjie;




import java.sql.SQLException;
import java.sql.Connection;

import javax.sql.DataSource;
import javax.xml.transform.Source;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.mapper.AdminMapper;
import com.atguigu.crowd.service.api.AdminService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml","classpath:spring-persist-tx.xml"})
public class TestPP {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private AdminService adminService;

 	
	@Test
	public void testgetConnection() throws SQLException {
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
		
	}
	
	@Test 
	public void testAdmin() {
		Admin admin = new Admin(null,"tom","123123","��ķ","tom@qqcom",null);
		int i = adminMapper.insert(admin);
		System.out.println(i);
		
	}
	@Test
	public void testLog() {
		//1����ȡLogger����
		Logger logger = LoggerFactory.getLogger(TestPP.class);
		logger.debug("Hello , i am  debug");
		logger.debug("Hello , i am  debug");
		logger.debug("Hello , i am  debug");
		logger.debug("Hello , i am  debug");
		logger.debug("Hello , i am  debug");
		
		logger.info("Hello ,i am  info");
		logger.info("Hello ,i am  info");
		logger.info("Hello ,i am  info");
		logger.info("Hello ,i am  info");
		
		
		logger.warn("Hello ,i am  warn");
		logger.warn("Hello ,i am  warn");
		logger.warn("Hello ,i am  warn");
		logger.warn("Hello ,i am  warn");
		
		logger.error("Hello ,i am  error");
		logger.error("Hello ,i am  error");
		logger.error("Hello ,i am  error");
		logger.error("Hello ,i am  error");
		logger.error("Hello ,i am  error");
		
	}
	
	@Test
	public void testService() {
	
		Admin admin = new Admin(null,"jack","123123","�ܿ�","jack@qqcom",null);
		int saveAdmin = adminService.saveAdmin(admin);
		System.out.println(saveAdmin);
		
		
	}
	@Test
	public void test1() {
		Admin admin = new Admin(null,"jack","123123","杰克","jack@qqcom",null);
		System.out.println(admin);
	}
	
	@Test
	public void testResultEntity() {
		
	}
	
	

		
		
	
	

}
