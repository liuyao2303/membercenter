package com.ccq.membercenter.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatasourceConfig {

    @Bean("hikariDataSource")
    public HikariDataSource hikariDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://kk.hb520.site:3306/ccq");
        config.setUsername("root");
        config.setPassword("lyhh2303");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.setIdleTimeout(60000);
        config.setConnectionTimeout(60000);
        config.setValidationTimeout(3000);
        config.setMaxLifetime(60000);
        HikariDataSource ds = new HikariDataSource(config);
        return ds;
    }
}
