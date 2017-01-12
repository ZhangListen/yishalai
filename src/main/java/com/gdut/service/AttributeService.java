package com.gdut.service;

import com.gdut.dao.AttributeDao;
import com.gdut.dao.FinishProductDao;
import com.gdut.vo.AttributeVo;
import com.gdut.vo.FinishedProductVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by huang on 2017/1/7.
 */
@Service
public class AttributeService {
    @Resource
    private AttributeDao attributeDao;

    public void save(AttributeVo attributeVo){
        attributeDao.save(attributeVo);
    }

    public void delete(Long id){
        attributeDao.delete(id);
    }

    public void update(AttributeVo attributeVo){
        attributeDao.update(attributeVo);
    }
    public List<AttributeVo> get(){
        return attributeDao.get();
    }

    public List<AttributeVo> getByFinshedId(Integer finishedId) {
        return attributeDao.getByFinshedId(finishedId);
    }
}
