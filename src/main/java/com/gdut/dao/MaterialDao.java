package com.gdut.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.gdut.config.SimpleUpdateExtendedLanguageDriver;
import com.gdut.vo.MaterialVo;
import com.gdut.vo.ProductDetail;

/**
 * Created by huang on 2017/1/7.
 */

public interface MaterialDao {

	@Insert("INSERT INTO material (FName,FID,FMaterial,FVol,FUnit,FCost,"
			+ "FWidth,FHeight,FCategory,FCut,FTotal,FPart,FRetail)"
			+ " VALUES(#{FName},#{FID},#{FMaterial},#{FVol},#{FUnit},#{FCost},#{FWidth},"
			+ "#{FHeight},#{FCategory},#{FCut},#{FTotal},#{FPart},#{FRetail})")
	public void save(MaterialVo materialVo);

	@Delete("DELETE  FROM material WHERE id=#{id}")
	public void delete(Long id);

	@Update("UPDATE material (#{materialVo}) WHERE id =#{id}")
	@Lang(SimpleUpdateExtendedLanguageDriver.class)
	public void update(MaterialVo materialVo);

	@Select("SELECT * FROM material")
	public List<MaterialVo> get();

	@Select("SELECT * FROM material WHERE id=#{id}")
	public MaterialVo getVoById(Long id);

}
