package com.ccq.membercenter;

import com.ccq.membercenter.dao.intf.UserInfoDao;
import com.ccq.membercenter.model.UserInfoModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberTest {

    @Autowired
    private UserInfoDao userInfoDao;

    @Test
    public void testSelect() {
        UserInfoModel userInfo = userInfoDao.queryUserById(1L);
        System.out.println(userInfo);
    }
}
