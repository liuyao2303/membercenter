package com.ccq.membercenter.dao.intf;

import com.ccq.framework.lang.Page;
import com.ccq.membercenter.model.AdminUserInfo;

import java.util.List;

public interface AdminUserInfoDao {
    AdminUserInfo queryAdminUserInfoById(Long id);
    public int adminUserInfoExists(Long id,String password);
    public int addAdminUser(AdminUserInfo adminUserInfo);
    public int update(AdminUserInfo userInfo) ;
    public int userExists(String username,String password);
    public List<AdminUserInfo> queryAdminUserByPage(Page page);
}
