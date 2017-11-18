package com.ccq.membercenter.api;

import com.ccq.framework.lang.JsonResult;
import com.ccq.framework.lang.Result;
import com.ccq.membercenter.service.intf.AdminUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@RestController("adminUserInfoController")
public class AdminUserInfoController {

    @Autowired
    private AdminUserInfoService adminUserInfoService;

    @RequestMapping(value = "/login")
    public JsonResult login(HttpServletRequest request, String username, String password) throws ServletException {

        Result r = adminUserInfoService.userCert(username,password);
        if(r.isSuccess()) {
            request.getSession().setAttribute("username",username);
            return JsonResult.getSuccessResult(r.getMessage());
        }else return JsonResult.getErrorResult(r.getMessage());
    }
}
