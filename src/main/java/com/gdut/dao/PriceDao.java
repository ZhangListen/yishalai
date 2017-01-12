package com.gdut.dao;

import com.gdut.config.SimpleUpdateExtendedLanguageDriver;
import com.gdut.vo.PriceVo;
import org.apache.ibatis.annotations.*;

/**
 * Created by huang on 2017/1/7.
 */
public interface PriceDao {

    @Insert("INSERT INTO price (price,materialId) VALUES (#{price},#{materialId})")
    public void save(PriceVo priceVo);

    @Update("UPDATE price (#{priceVo}) WHERE id =#{id}")
    @Lang(SimpleUpdateExtendedLanguageDriver.class)
    public void update(PriceVo priceVo);

    @Select("SELECT * FROM price WHERE materialId=#{materialId} AND userId=#{userId}")
    public PriceVo getPrice(Long materialId,Long userId);


}
