package com.wjs.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.wjs.dao.IUserDao;
import com.wjs.model.User;

@Repository
public class UserDaoImpl extends SqlSessionDaoSupport implements IUserDao {
  
	private static final String NAME_SPACE="com.wjs.dao.impl.UserDaoImpl.";
	//@Autowired
	//private UserMapper userMapper;

	
	public boolean register(User user) {
		return this.getSqlSession().insert(NAME_SPACE+"insertUser", user) !=0 ? true : false;
		//userMapper.insertUser(user) == 1 ? true : false;
	}
    
	@Resource
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	public User login(String username, String password) {
		return this.getSqlSession().selectOne(NAME_SPACE+"selectUserInfo");//userMapper.selectByUsernameAndPwd(username, password);
	}
	
	public List<User> queryAllUser() {
		return this.getSqlSession().selectList(NAME_SPACE+"selectAllUserInfo");//userMapper.selectByUsernameAndPwd(username, password);
	}
}
