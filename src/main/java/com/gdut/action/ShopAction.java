package com.gdut.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gdut.service.MaterialService;
import com.gdut.service.ShopService;
import com.gdut.utils.Contants;
import com.gdut.vo.MaterialVo;
import com.gdut.vo.ShopVo;


/**
 * @author ZListen
 *
 */
@RestController
@EnableAutoConfiguration
public class ShopAction {


    private Logger logger=Logger.getLogger(ShopAction.class);

    @Resource
    private ShopService shopService;
    @Resource
    private MaterialService materialService;

    @RequestMapping(value = "/shop",method = RequestMethod.POST)
    public void save(@ModelAttribute ShopVo shopVo){
    	shopService.save(shopVo);
    }

    @RequestMapping(value = "/shop/{id}",method = RequestMethod.PUT)
    public void update(@PathVariable Long id, @ModelAttribute ShopVo shopVo){
    	shopVo.setId(id);
        shopService.update(shopVo);
    }

	@RequestMapping(value = "/shops",method = RequestMethod.GET)
    public Map<String,Object> getShop(){
		Map<String,Object> result=new HashMap();
        List<ShopVo> list= shopService.getShops();
        if(list!=null && list.size() >0){
            for (int i = 0; i < list.size(); i++) {
				result.put("id", list.get(i).getId());
				result.put("name", list.get(i).getName());
				result.put("address", list.get(i).getAddress());
				result.put("phone", list.get(i).getPhone());
				result.put("shopType", list.get(i).getShopType());
			}
        }else{
            result.put("code", Contants.ERROR_SERVER);
            return result;
        }
        return result;
    }
}
