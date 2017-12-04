package com.ccq.membercenter.api;

import com.ccq.framework.lang.JsonResult;
import com.ccq.framework.lang.Page;
import com.ccq.framework.lang.Result;
import com.ccq.membercenter.access.AccessLevel;
import com.ccq.membercenter.model.AdminUserInfo;
import com.ccq.membercenter.service.intf.AdminUserInfoService;
import com.ccq.membercenter.token.Token;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@RestController("adminUserInfoController")
@RequestMapping(value = "/manager/user")
public class AdminUserInfoController {

    @Autowired
    private AdminUserInfoService adminUserInfoService;

    /**
     * 管理员用户登录功能，最后返回给用户登录的会话信息
     *
     * @param request
     * @param username
     * @param password
     * @return
     * @throws ServletException
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JsonResult login(HttpServletRequest request, String username, String password) throws ServletException {

        Result r = adminUserInfoService.userCert(username, password);
        if (r.isSuccess()) {
            JsonResult jr = JsonResult.getSuccessResult("登录成功");
            jr.setObject(r.getObject());
            return jr;
        } else return JsonResult.getErrorResult(r.getMessage());
    }

    /**
     * 根据条件来查询status等条件来进行查询
     *
     * @param request
     * @param status
     * @param username
     * @param accessLevel
     * @param pageSize
     * @param pageNum
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public JsonResult getAdminuserInfoList(HttpServletRequest request, String status,
                                           String username, int accessLevel, int pageSize, int pageNum) {

        /* 根据分页信息构建分页对象 */
        Page page = Page.getPage(pageNum, pageSize);

        Result r = adminUserInfoService.getAdminUserList(status, username, accessLevel, page);
        if (!r.isSuccess()) return JsonResult.getErrorResult(r.getMessage());
        else {
            JsonResult jr = JsonResult.getSuccessResult("OK");
            jr.setPage(page);
            jr.setObject(r.getObject());
            return jr;
        }
    }

    /**
     * 用户更改密码接口
     *
     * @return
     */
    @RequestMapping("index")
    public JsonResult changePwd() {

        return JsonResult.getSuccessResult("yes");
    }

}