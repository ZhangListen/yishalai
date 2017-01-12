package com.gdut.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gdut.dao.ShopDao;
import com.gdut.vo.ShopVo;


/**
 * @author ZListen
 *
 */
@Service
public class ShopService {


    private ShopDao shopDao;

    public void save(ShopVo shopVo){
    	shopDao.save(shopVo);
    }

    public void update(ShopVo shopVo){
    	shopDao.update(shopVo);
    }

    public List<ShopVo> getShops(){
        return shopDao.getShops();
    }
}
