package com.gdut.dao;

import com.gdut.config.SimpleUpdateExtendedLanguageDriver;
import com.gdut.vo.AttributeVo;
import com.gdut.vo.FinishedProductVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

import static com.sun.tools.corba.se.idl.constExpr.Expression.one;

/**
 * Created by huang on 2017/1/7.
 */
public interface AttributeDao {
    @Insert("INSERT INTO attribute (finishedId,attributeName,materialId) VALUES " +
            "(#{finishedId},#{attributeName},#{materialId})")
    public void save(AttributeVo attributeVo);

    @Delete("DELETE  FROM attribute WHERE id=#{id}")
    public void delete(Long id);

    @Update("UPDATE attribute (#{attributeVo}) WHERE id =#{id}")
    @Lang(SimpleUpdateExtendedLanguageDriver.class)
    public void update(AttributeVo attributeVo);

    @Select("SELECT * FROM attribute")
    public List<AttributeVo> get();


    @Select("select * from attribute where finishedId=#{finishedId}")
    @Results(
            {
                    @Result(property = "materialVo",column ="materialId",
                            one = @One(select = "com.gdut.dao.MaterialDao.getVoById"))
            }
    )
    public List<AttributeVo> getByFinshedId(Integer finishedId);
}
