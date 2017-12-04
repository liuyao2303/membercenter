package com.ccq.membercenter.config;

import com.ccq.framework.jdbc.dao.JdbcTempleteDao;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class JdbcConfig {

    @Bean
    JdbcTempleteDao getJdbcTemplate(HikariDataSource ds) {
        return new JdbcTempleteDao(ds);
    }
}
