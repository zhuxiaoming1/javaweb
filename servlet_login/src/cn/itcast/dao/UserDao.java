package cn.itcast.dao;

import cn.itcast.entity.User;
import cn.itcast.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;

/**
 * @author xiaoming
 * @create 2018-10-09-22:08
 */
public class UserDao {
    public User login(String username, String password) throws SQLException {

        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        System.out.println(username);
        System.out.println(password);
        User user = qr.query("select * from user where username=? and password=?", new BeanHandler<User>(User.class), username, password);
        System.out.println(user);
        return user;
    }
}
