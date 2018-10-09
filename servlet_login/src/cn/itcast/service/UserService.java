package cn.itcast.service;

import cn.itcast.dao.UserDao;
import cn.itcast.entity.User;

import java.sql.SQLException;

/**
 * @author xiaoming
 * @create 2018-10-09-22:08
 */
public class UserService {
    public User login(String username, String password) {

        UserDao userDao = new UserDao();
        User user = null;
        try {
            user = userDao.login(username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
