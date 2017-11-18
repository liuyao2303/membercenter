package com.ccq.membercenter.dao.impl;

import com.ccq.framework.jdbc.dao.JdbcTempleteDao;
import com.ccq.membercenter.dao.intf.AdminUserCertDao;
import com.ccq.membercenter.model.AdminUserCertInfo;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository("AdminUserCertInfo")
public class AdminUserCertDaoImpl implements AdminUserCertDao{

    @Autowired
    private JdbcTempleteDao jdbcDao;

    public int insert(AdminUserCertInfo userCertInfo) {
        String sql = "insert into admin_user_cert_tbl (user_id,password,status) values (?,?,?);";
        return jdbcDao.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setLong(1,userCertInfo.getUserId());
                ps.setString(2,userCertInfo.getPassword());
                ps.setInt(3,userCertInfo.getStatus());
            }
        });
    }

    public int update(AdminUserCertInfo userCertInfo) {
        String sql = "update admin_user_cert_tbl set user_id = ?, password = ?, status = ? where id = ? ;";
        return jdbcDao.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setLong(1,userCertInfo.getUserId());
                ps.setString(2,userCertInfo.getPassword());
                ps.setInt(3,userCertInfo.getStatus());
                ps.setLong(4,userCertInfo.getId());
            }
        });
    }

    public AdminUserCertInfo queryAdminUserCertInfoById(long id) {
        String sql  = "select id, user_id AS userId, password , status from admin_user_cert_tbl WHERE id = ?";
        return jdbcDao.queryForObject(sql, new Object[]{id}, new RowMapper<AdminUserCertInfo>() {
            @Override
            public AdminUserCertInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
                AdminUserCertInfo r = new AdminUserCertInfo();
                r.setId(rs.getLong("id"));
                r.setUserId(rs.getLong("userId"));
                r.setPassword(rs.getString("password"));
                r.setStatus(rs.getInt("status"));
                return r;
            }
        });
    }

    public AdminUserCertInfo queryAdminUserCertInfoByUserId(long id) {
        String sql  = "select id, user_id AS userId, password , status from admin_user_cert_tbl WHERE user_id = ?";
        return jdbcDao.queryForObject(sql, new Object[]{id}, new RowMapper<AdminUserCertInfo>() {
            @Override
            public AdminUserCertInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
                AdminUserCertInfo r = new AdminUserCertInfo();
                LoggerFactory.getLogger(AdminUserCertInfo.class).debug("返回新的数据");
                r.setId(rs.getLong("id"));
                r.setUserId(rs.getLong("userId"));
                r.setPassword(rs.getString("password"));
                r.setStatus(rs.getInt("status"));
                return r;
            }
        });
    }
}
