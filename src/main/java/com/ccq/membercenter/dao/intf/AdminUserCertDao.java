package com.ccq.membercenter.dao.intf;

import com.ccq.membercenter.model.AdminUserCertInfo;

public interface AdminUserCertDao {
    public AdminUserCertInfo queryAdminUserCertInfoByUserId(long id);
    public AdminUserCertInfo queryAdminUserCertInfoById(long id);
    public int update(AdminUserCertInfo userCertInfo);
    public int insert(AdminUserCertInfo userCertInfo);
}
