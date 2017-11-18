package com.ccq.membercenter.config;

import com.ccq.framework.jdbc.dao.JdbcTempleteDao;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class JdbcConfig {

    @Bean
    JdbcTempleteDao getJdbcTemplate(BasicDataSource ds) {
        return new JdbcTempleteDao(ds);
    }
}
