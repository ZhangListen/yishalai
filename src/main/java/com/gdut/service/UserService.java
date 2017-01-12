package com.gdut.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdut.dao.UserDao;
import com.gdut.vo.UserVo;

/**
 * 描述：处理用户账号相关操作
 * 
 * @author ZListen
 *  20170107
 */
@Service
public class UserService {

	@Resource
	private UserDao userDao;
	
	public void save(UserVo userVo){
		userDao.save(userVo);
    }

    public void delete(Long id){
    	userDao.delete(id);
    }

    public void update(UserVo userVo){
    	userDao.update(userVo);
    }
    public List<UserVo> getList(){
        return userDao.getList();
    }
    public List<UserVo> get(UserVo userVo){
    	return userDao.get(userVo);
    }


    public List<UserVo> getByShopId(Long shopId) {
        return userDao.getByShopId(shopId);
    }
}
