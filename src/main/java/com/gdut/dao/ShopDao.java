package com.gdut.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.gdut.config.SimpleUpdateExtendedLanguageDriver;
import com.gdut.vo.ShopVo;


/**
 * @author ZListen
 *
 */
public interface ShopDao {

    @Insert("INSERT INTO shop (name,address,phone,shopType) VALUES (#{name},#{address},#{phone},#{shopType})")
    public void save(ShopVo ShopVo);

    @Update("UPDATE shop (#{shopVo}) WHERE id =#{id}")
    @Lang(SimpleUpdateExtendedLanguageDriver.class)
    public void update(ShopVo ShopVo);

    /**获得所有的店铺
     * @return
     */
    @Select("SELECT * FROM shop ")
    public List<ShopVo> getShops();


}
