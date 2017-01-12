package com.gdut.service;

import com.gdut.dao.PriceDao;
import com.gdut.vo.PriceVo;
import org.springframework.stereotype.Service;

/**
 * Created by huang on 2017/1/7.
 */
@Service
public class PriceService {


    private PriceDao priceDao;

    public void save(PriceVo priceVo){
        priceDao.save(priceVo);
    }

    public void update(PriceVo priceVo){
        priceDao.update(priceVo);
    }

    public PriceVo getPrice(Long materialId,Long userId){
        return priceDao.getPrice(materialId,userId);
    }
}
