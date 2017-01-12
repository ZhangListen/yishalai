package com.gdut.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdut.dao.FinishProductDao;
import com.gdut.vo.FinishedProductVo;



/**
 * Created by huang on 2017/1/7.
 */
@Service
public class FinishProductService {

    @Resource
    private FinishProductDao finishProductDao;

    public void save(FinishedProductVo materialVo){
        finishProductDao.save(materialVo);
    }

    public void delete(Long id){
        finishProductDao.delete(id);
    }

    public void update(FinishedProductVo materialVo){
        finishProductDao.update(materialVo);
    }
    public List<FinishedProductVo> get(){
        return finishProductDao.get();
    }
    
    /**
     * @return
     */
    public List<FinishedProductVo> getProductDetails(){
    	return finishProductDao.getProductDetail();
    }
}
