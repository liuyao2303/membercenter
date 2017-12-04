package com.ccq.membercenter.service.intf;

import com.ccq.framework.lang.Page;
import com.ccq.framework.lang.Result;
import com.ccq.membercenter.dto.UserInfoDto;

public interface AdminUserInfoService {
    public Result userCert(String username, String password);
    public Result changePwd(long userId, String oldPwd, String newPwd);
    public Result getAdminUserList(Page page);
    public Result disableAdminUser(Long userId);
    public Result addAdminUser(UserInfoDto dto);
    public Result getAdminUserList(String status,
                                   String username,
                                   int accessLevel,
                                   Page page);
}
