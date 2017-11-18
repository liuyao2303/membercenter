package com.ccq.membercenter.api;

import com.ccq.membercenter.dto.UserInfoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/member")
@RestController("memberInfoController")
public class MemberInfoController {

    Logger logger = LoggerFactory.getLogger(MemberInfoController.class);

    @RequestMapping("/info/{id}")
    public UserInfoDto queryUserById(@PathVariable("id") Long id) {

        logger.info(id.toString());
        return UserInfoDto.getDefaultUser();
    }
}
