package com.gdut.dao;

import com.gdut.config.SimpleUpdateExtendedLanguageDriver;
import com.gdut.vo.FinishedProductVo;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * Created by huang on 2017/1/7.
 */
public interface FinishProductDao {
    @Insert("INSERT INTO finished_product (num,url) VALUES (#{num},#{url})")
    public void save(FinishedProductVo materialVo);

    @Delete("DELETE  FROM finished_product WHERE id=#{id}")
    public void delete(Long id);

    @Update("UPDATE finished_product (#{finishedProductVo}) WHERE id =#{id}")
    @Lang(SimpleUpdateExtendedLanguageDriver.class)
    public void update(FinishedProductVo finishedProductVo);

    @Select("SELECT * FROM finished_product")
    public List<FinishedProductVo> get();

    @Results(
            {
                    @Result(property = "attributeVos",column ="id",
                            many  = @Many(select = "com.gdut.dao.AttributeDao.getByFinshedId"))
            }
    )
    @Select("SELECT * FROM finished_product")
	public List<FinishedProductVo> getProductDetail();
}
