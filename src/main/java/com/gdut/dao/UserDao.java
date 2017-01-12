package com.gdut.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.gdut.config.SimpleUpdateExtendedLanguageDriver;
import com.gdut.vo.UserVo;

/**
 * 描述：用户表DAO
 * 
 * @author ZListen 20170107
 */
public interface UserDao {
	@Insert("INSERT INTO user (account,password,name,shopId) VALUES "
			+ "(#{account},#{password},#{name},#{shopId})")
	public void save(UserVo userVo);

	@Delete("DELETE  FROM user WHERE id=#{id}")
	public void delete(Long id);

	@Update("UPDATE user (#{userVo}) WHERE id =#{id}")
	@Lang(SimpleUpdateExtendedLanguageDriver.class)
	public void update(UserVo userVo);

	@Select("SELECT * FROM user")
	public List<UserVo> getList();

	@Select("SELECT * FROM user WHERE  account=#{account} and password=#{password}")
	public List<UserVo> get(UserVo userVo);

	@Select("SELECT * FROM user WHERE  shopId=#{shopId}")
    public List<UserVo> getByShopId(Long shopId);
}