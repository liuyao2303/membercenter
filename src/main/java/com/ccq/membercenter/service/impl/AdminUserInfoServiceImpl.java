package com.ccq.membercenter.service.impl;


import com.ccq.framework.annotation.ServiceTrace;
import com.ccq.framework.lang.ConstantStatus;
import com.ccq.framework.lang.Page;
import com.ccq.framework.lang.Result;
import com.ccq.membercenter.Constants.AdminUsersStatus;
import com.ccq.membercenter.access.AccessLevel;
import com.ccq.membercenter.dao.intf.AdminUserCertDao;
import com.ccq.membercenter.dao.intf.AdminUserInfoDao;
import com.ccq.membercenter.dto.AdminUserinfoDto;
import com.ccq.membercenter.dto.UserInfoDto;
import com.ccq.membercenter.model.AdminUserCertInfo;
import com.ccq.membercenter.model.AdminUserInfo;
import com.ccq.membercenter.service.intf.AdminUserInfoService;
import com.ccq.membercenter.token.Token;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
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
        AdminUserInfo user = adminUserInfoDao.queryAdminUserInfoByName(username);
        if(count == 1) {
            Result r = Result.getSuccessResult("用户存在");
            r.setObject(buildToken(user));
            return r;
        }else {
            return new Result(false,"该用户不存在");
        }
    }


    /**
     * 用户登录成功后，需要向用户返回令牌信息
     * @return
     */
    public Token buildToken(AdminUserInfo user) {
        Token token = Token.getDefaultAdminToken();
        token.setUserId(user.getId());
        token.setAccessLevel(AccessLevel.DEFAULT_LEVEL.getLevel());
        token.setUsername(user.getUsername());
        token.setUuid(UUID.randomUUID().toString());
        token.getUserCate();
        return token;
    }


    /**
     * 获取用户信息
     * @return
     */
    public AdminUserCertInfo queryUserInfo(long userId) {
        return adminUserCertDao.queryAdminUserCertInfoById(userId);
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
     *
     * @return
     */
    @Override
    public Result getAdminUserList(String status,
                                   String username,
                                   int accessLevel,
                                   Page page) {
        List<AdminUserinfoDto> users = adminUserInfoDao.queryAdminUserByPage(status,
                username,
                accessLevel,
                page)
                .stream().map(item -> AdminUserinfoDto.fromAdminUserModel(item)).collect(Collectors.toList());
        Result r = new Result(true,"");
        r.setObject(users);
        return r;
    }


    /**
     * 禁用用户
     * @param userId
     * @return
     */
    public Result disableAdminUser(Long userId) {

        AdminUserInfo admin = adminUserInfoDao.queryAdminUserInfoById(userId);
        if(admin == null)
            return Result.getErrorResult("该用户不存在！");
        return Result.getSuccessResult("操作成功！");
    }


    /**
     * 添加一个管理员用户
     * @return
     */
    @Override
    public Result addAdminUser(UserInfoDto dto) {

        AdminUserInfo userInfo = new AdminUserInfo();
        BeanUtils.copyProperties(dto,userInfo);
        userInfo.setCreateTime(new Date().getTime());
        userInfo.setStatus(Long.valueOf(AdminUsersStatus.NEW.getType()));
        int r = adminUserInfoDao.addAdminUser(userInfo);
        if(r > 0) {
            return Result.getSuccessResult("添加成功");
        }else
            return Result.getErrorResult("添加失败");
    }
}
