package com.ccq.membercenter.dao.impl;

import com.ccq.framework.dao.MybatisDao;
import com.ccq.framework.jdbc.dao.JdbcTempleteDao;
import com.ccq.framework.lang.Page;
import com.ccq.membercenter.dao.intf.UserInfoDao;
import com.ccq.membercenter.model.UserInfoModel;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("userInfoDao")
public class UserInfoDaoImpl extends MybatisDao implements UserInfoDao {

    @Autowired
    private JdbcTempleteDao jdbcDao;

    @Override
    public int addUser(UserInfoModel userInfo) {
        String sql = "insert into user_information_tbl (username,avatar,sex,phone_number,email,address,score,city_code,create_time,status) values (?,?,?,?,?,?,?,?,?,?);";
        return jdbcDao.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1,userInfo.getUsername());
                ps.setString(2,userInfo.getAvatar());
                ps.setInt(3,userInfo.getSex());
                ps.setString(4,userInfo.getEmail());
                ps.setString(5,userInfo.getAddress());
                ps.setInt(6,userInfo.getScore());
                ps.setString(7,userInfo.getCityCode());
                ps.setLong(8,userInfo.getCreateTime());
                ps.setInt(9,userInfo.getStatus());
                ps.setString(10,userInfo.getAvatar());
            }
        });
    }

    public UserInfoModel queryUserById(Long id) {

        String sql = "select * from user_information_tbl where id = ?";
        return jdbcDao.queryForObject(sql,new  BeanPropertyRowMapper<UserInfoModel>(UserInfoModel.class),id);
    }

    public List<UserInfoModel> queryUserInfoList(int status) {

        String sql = "select * from user_information_tbl where status = ?";
        return jdbcDao.query(sql, new Object[]{status}, (ResultSet rs, int rowNum) -> {
            UserInfoModel u = new UserInfoModel();
            u.setId(rs.getLong("id"));
            u.setAddress(rs.getString("address"));
            u.setAvatar(rs.getString("avatar"));
            u.setCityCode(rs.getString("city_code"));
            u.setCreateTime(rs.getLong("create_time"));
            u.setEmail(rs.getString("email"));
            u.setPhoneNumber(rs.getString("phone_number"));
            u.setScore(rs.getInt("score"));
            u.setSex(rs.getInt("sec"));
            u.setStatus(rs.getInt("status"));
            u.setUsername(rs.getString("username"));
            return u;
        });
    }

    public List<UserInfoModel> queryUserInfoListByPage(int status,Page page) {

        int count = jdbcDao.queryForObject("select * from user_information_tbl where status = ?",new Object[]{status},Integer.class);
        int limit = jdbcDao.getPageOffset(page);
        page.setPages(((int) (count/page.getPageSize())) + ((count%page.getPageSize()>0) ? 1:0));
        String sql = "select * from user_information_tbl where status = ? offset ? limit ?";
        return jdbcDao.query(sql, new Object[]{status,limit,page.getPageSize()}, new BeanPropertyRowMapper<UserInfoModel>(UserInfoModel.class));
    }

    @Override
    public List<UserInfoModel> queryUserInfoList(UserInfoModel userInfo,Page page) {
        return super.selectListByPage(userInfo,page);
    }
}
