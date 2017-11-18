package com.ccq.membercenter;

import com.ccq.framework.lang.ConstantStatus;
import com.ccq.membercenter.dao.intf.AdminUserCertDao;
import com.ccq.membercenter.dao.intf.AdminUserInfoDao;
import com.ccq.membercenter.model.AdminUserCertInfo;
import com.ccq.membercenter.model.AdminUserInfo;
import com.sun.org.apache.xalan.internal.xsltc.runtime.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MembercenterApplicationTests {

	@Autowired
	private AdminUserInfoDao adminUserInfoDao;

	@Autowired
    private AdminUserCertDao adminUserCertDao;

	@Test
	public void contextLoads() {

        AdminUserInfo userInfo = adminUserInfoDao.queryAdminUserInfoById(101L);
        System.out.println(userInfo);
        userInfo.setAvatar("修改后的头像");
        adminUserInfoDao.update(userInfo);
    }

    @Test
    public void AdminUserCertInsertTest() {
        AdminUserCertInfo info = new AdminUserCertInfo();
        info.setStatus(1);
        info.setPassword("lyhh2303");
        info.setUserId(101L);
        adminUserCertDao.insert(info);
	}

	@Test
    public void setAdminUserInfoQueryTest() {
        AdminUserCertInfo userCertInfo = adminUserCertDao.queryAdminUserCertInfoById(1L);
        System.out.println(userCertInfo);
        AdminUserCertInfo userCertInfo1 = adminUserCertDao.queryAdminUserCertInfoByUserId(100L);
        System.out.println(userCertInfo1);
    }

    @Test
    public void setAdminUserInfoUpdateTest() {
        AdminUserCertInfo userCertInfo = adminUserCertDao.queryAdminUserCertInfoById(1L);
        System.out.println(userCertInfo);
        userCertInfo.setPassword("wozhendeshihaoren");
        adminUserCertDao.update(userCertInfo);
    }
}
