package com.gdut.dao;

import com.gdut.config.SimpleUpdateExtendedLanguageDriver;
import com.gdut.vo.FinishedProductVo;
import com.gdut.vo.MaterialVo;
import com.gdut.vo.ProductDetail;

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
    
    @Select("SELECT fd.id as id,fd.num as pNum,fd.url as pUrl,attr.id as aId,attributeName," +
            "attr.num as aNum,attr.url as aUrl,mater.id as mId,FMaterial,FVol,FUnit,FCost,FWidth,FHight,FCategory,FCut,FTotal,FPart,FRetail " +
            "FROM finishedproduct fd INNER JOIN attribute attr " +
            "ON fd.id = attr.finishedId INNER JOIN material mater ON attr.materialId = mater.id")
	public List<ProductDetail> getProductDetail();
}
