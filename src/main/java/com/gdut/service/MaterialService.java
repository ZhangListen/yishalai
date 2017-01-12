package com.gdut.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdut.dao.MaterialDao;
import com.gdut.vo.MaterialVo;
import com.gdut.vo.ProductDetail;

/**
 * Created by huang on 2017/1/7.
 */
@Service
public class MaterialService {

    @Resource
    private MaterialDao materialDao;

    public void save(MaterialVo materialVo){
        materialDao.save(materialVo);
    }

    public void delete(Long id){
        materialDao.delete(id);
    }

    public void update(MaterialVo materialVo){
        materialDao.update(materialVo);
    }

    public List<MaterialVo> get(){
        return materialDao.get();
    }

    public MaterialVo getMaterialVoById(Long id){
        return materialDao.getVoById(id);
    }
    
   
}
