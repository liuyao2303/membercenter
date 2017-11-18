package com.ccq.membercenter.service.impl;


import com.ccq.framework.annotation.ServiceTrace;
import com.ccq.framework.lang.ConstantStatus;
import com.ccq.framework.lang.Page;
import com.ccq.framework.lang.Result;
import com.ccq.membercenter.dao.intf.AdminUserCertDao;
import com.ccq.membercenter.dao.intf.AdminUserInfoDao;
import com.ccq.membercenter.dto.AdminUserinfoDto;
import com.ccq.membercenter.model.AdminUserCertInfo;
import com.ccq.membercenter.model.AdminUserInfo;
import com.ccq.membercenter.service.intf.AdminUserInfoService;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@ServiceTrace
public class AdminUserInfoServiceImpl implements AdminUserInfoService{

    @Autowired
    private AdminUserCertDao adminUserCertDao;

    @Autowired
    private AdminUserInfoDao adminUserInfoDao;

    /**
     * 用户登录验证
     * @return
     */
    public Result userCert(String username,String password) {
        int count = adminUserInfoDao.userExists(username,password);
        if(count == 1) {
            return new Result(true,"");
        }else {
            return new Result(false,"该用户不存在");
        }
    }

    /**
     * 用户修改密码
     * @return
     */
    public Result changePwd(long userId, String oldPwd, String newPwd) {

        AdminUserCertInfo certInfo = adminUserCertDao.queryAdminUserCertInfoByUserId(userId);
        if(certInfo == null || !(certInfo.getStatus() == ConstantStatus.USING)) {
            return new Result(false,"该用户不存在");
        }else if(certInfo.getPassword().equals(oldPwd)) {

            certInfo.setPassword(newPwd);
            int i = adminUserCertDao.update(certInfo);
            if(i < 0)
                return new Result(false,"用户名或密码不正确！");
            else
                new Result(true,"更新成功！");
        }

        return new Result(false,"用户名或密码不正确！");
    }

    /**
     *
     * @return
     */
    public Result getAdminUserList(Page page) {
        List<AdminUserinfoDto> users = adminUserInfoDao.queryAdminUserByPage(page)
                            .stream().map(item -> AdminUserinfoDto.fromAdminUserModel(item)).collect(Collectors.toList());
        Result r = new Result(true,"");
        r.setObject(users);
        return r;
    }


    /**
     * 警用用户
     * @param userId
     * @return
     */
    public Result disableAdminUser(Long userId) {

        AdminUserInfo admin = adminUserInfoDao.queryAdminUserInfoById(userId);
        if(admin == null)
            return Result.getErrorResult("该用户不存在！");
        return Result.getSuccessResult("操作成功！");
    }

    public Result addAdminUser() {

        return Result.getErrorResult("un support operation!");
    }
}
