package com.ccq.membercenter.dao.impl;

import com.ccq.framework.dao.MybatisDao;
import com.ccq.framework.jdbc.dao.JdbcTempleteDao;
import com.ccq.framework.lang.Page;
import com.ccq.membercenter.dao.intf.AdminUserInfoDao;
import com.ccq.membercenter.model.AdminUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository("adminUserInfoDao")
public class AdminUserInfoDaoImpl extends MybatisDao implements AdminUserInfoDao{

    @Autowired
    private JdbcTempleteDao jdbcDao;

    @Override
    public int addAdminUser(AdminUserInfo adminUserInfo) {
        String sql = "INSERT admin_user_tbl (username,avatar,sex,phone_number,email,address,city_code,create_time,status) value(?,?,?,?,?,?,?,?,?)";
        return jdbcDao.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1,adminUserInfo.getUsername());
                ps.setString(2,adminUserInfo.getAvatar());
                ps.setLong(3,adminUserInfo.getSex());
                ps.setString(4,adminUserInfo.getPhone());
                ps.setString(5,adminUserInfo.getEmail());
                ps.setString(6,adminUserInfo.getAddr());
                ps.setString(7,adminUserInfo.getCity());
                ps.setLong(8,adminUserInfo.getCreateTime());
                ps.setLong(9,adminUserInfo.getStatus());
            }
        });
    }

    public int update(AdminUserInfo userInfo) {
        String sql = "UPDATE admin_user_tbl SET username = ?,avatar=?,sex=?,phone_number=?,email=?,address=?,city_code=?,create_time=?,status=? WHERE id = ?";
        return jdbcDao.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1,userInfo.getUsername());
                ps.setString(2,userInfo.getAvatar());
                ps.setLong(3,userInfo.getSex());
                ps.setString(4,userInfo.getPhone());
                ps.setString(5,userInfo.getEmail());
                ps.setString(6,userInfo.getAddr());
                ps.setString(7,userInfo.getCity());
                ps.setLong(8,userInfo.getCreateTime());
                ps.setLong(9,userInfo.getStatus());
                ps.setLong(10,userInfo.getId());
            }
        });
    }

    @Override
    public int userExists(String username, String password) {
        String sql = "select count(*) from admin_user_tbl a1 left join admin_user_cert_tbl a2 on a1.id = a2.user_id" +
                " where a1.username = ? and a2.password = ? and a1.status = 1 and a2.status = 1";
        return jdbcDao.queryForObject(sql,new Object[]{username,password},Integer.class);
    }

    @Override
    public AdminUserInfo queryAdminUserInfoById(Long id) {

        String sql = "select * from admin_user_tbl where id = ?";
        return jdbcDao.queryForObject(sql,new Object[]{id},((rs, rowNum) -> {
            AdminUserInfo r = new AdminUserInfo();
            r.setId(rs.getLong("id"));
            r.setAddr(rs.getString("address"));
            r.setAvatar(rs.getString("avatar"));
            r.setCity(rs.getString("city_code"));
            r.setCreateTime(rs.getLong("create_time"));
            r.setEmail(rs.getString("email"));
            r.setPhone(rs.getString("phone_number"));
            r.setSex(rs.getInt("sex"));
            r.setUsername(rs.getString("username"));
            r.setStatus(rs.getLong("status"));
            return r;
        }));
    }

    @Override
    public int adminUserInfoExists(Long id,String password) {
        return jdbcDao.queryForObject("select count(*) FROM admin_user_cert_tbl WHERE id = ? and password = ?"
                            ,new Object[]{id,password},Integer.class);
    }

    public List<AdminUserInfo> queryAdminUserByPage(Page page) {

        int count = jdbcDao.queryForObject("select count(*) from admin_user_tbl",Integer.class);
        int offset = jdbcDao.getPageOffset(page);
        page.setPages(((int) (count/page.getPageSize())) + ((count%page.getPageSize()>0) ? 1:0));
        String sql = "select * from admin_user_tbl offset ? limit ?";
        return jdbcDao.query(sql,new Object[]{offset,page.getPageSize()},new BeanPropertyRowMapper<AdminUserInfo>(AdminUserInfo.class));
    }
}
