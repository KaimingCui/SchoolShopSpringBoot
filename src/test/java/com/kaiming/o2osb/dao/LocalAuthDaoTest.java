package com.kaiming.o2osb.dao;

import com.kaiming.o2osb.entity.LocalAuth;
import com.kaiming.o2osb.entity.PersonInfo;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocalAuthDaoTest{
	@Autowired
	private LocalAuthDao localAuthDao;
	private static final String username = "testusername";
	private static final String password = "testpassword";

	@Test
	public void testAInsertLocalAuth() throws Exception {
		// 新增一条平台帐号信息
		LocalAuth localAuth = new LocalAuth();
		PersonInfo personInfo = new PersonInfo();
		personInfo.setUserId(2L);
		// 给平台帐号绑定上用户信息
		localAuth.setPersonInfo(personInfo);
		// 设置上用户名和密码
		localAuth.setUsername(username);
		localAuth.setPassword(password);
		localAuth.setCreateTime(new Date());
		int effectedNum = localAuthDao.insertLocalAuth(localAuth);
		assertEquals(1, effectedNum);
	}

	@Test
	public void testBQueryLocalByUserNameAndPwd() throws Exception {
		// 按照帐号和密码查询用户信息
		LocalAuth localAuth = localAuthDao.queryLocalByUserNameAndPwd(username, password);
		assertEquals("测试2", localAuth.getPersonInfo().getName());
	}

	@Test
	public void testCQueryLocalByUserId() throws Exception {
		// 按照用户Id查询平台帐号，进而获取用户信息
		LocalAuth localAuth = localAuthDao.queryLocalByUserId(2L);
		assertEquals("测试2", localAuth.getPersonInfo().getName());
	}

	@Test
	public void testDUpdateLocalAuth() throws Exception {
		// 依据用户Id,平台帐号，以及旧密码修改平台帐号密码
		Date now = new Date();
		int effectedNum = localAuthDao.updateLocalAuth(2L, username, password, password + "new", now);
		assertEquals(1, effectedNum);
		// 查询出该条平台帐号的最新信息
		LocalAuth localAuth = localAuthDao.queryLocalByUserId(2L);
		// 输出新密码
		System.out.println(localAuth.getPassword());
	}

}
