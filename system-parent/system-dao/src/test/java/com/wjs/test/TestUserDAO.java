package com.wjs.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wjs.dao.IUserDao;
import com.wjs.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestUserDAO {
    //@Autowired
    //private UserMapper userMapper;
    @Autowired
    private IUserDao userDao;
    @Test
    public void testInsert() {
        User user=new User();
        user.setUserName("suemi994");
        //userDao.register(user);
        User us=userDao.login("aa", null);
        System.out.println(us.getUserName());
        List<User> listUser=userDao.queryAllUser();
        for(User u:listUser){
        	System.out.println(u.getUserName());
        }
        //user.setPasswd("123456");
        //userMapper.addUser(user);
        
    }
}
