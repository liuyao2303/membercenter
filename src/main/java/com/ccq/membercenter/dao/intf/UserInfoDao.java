package com.ccq.membercenter.dao.intf;

import com.ccq.framework.lang.Page;
import com.ccq.membercenter.model.UserInfoModel;

import java.util.List;

public interface UserInfoDao {
    public int addUser(UserInfoModel userInfo);

    public List<UserInfoModel> queryUserInfoList(UserInfoModel userInfo,Page page);
    public UserInfoModel queryUserById(Long id) ;

    /**
     *
     * @param status
     * @return
     */
    public List<UserInfoModel> queryUserInfoList(int status) ;
}
