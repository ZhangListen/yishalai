package com.gdut.action;

import com.gdut.service.MaterialService;
import com.gdut.service.PriceService;
import com.gdut.utils.Contants;
import com.gdut.vo.FinishedProductVo;
import com.gdut.vo.MaterialVo;
import com.gdut.vo.PriceVo;
import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huang on 2017/1/7.
 */
@RestController
@EnableAutoConfiguration
public class PriceAction {


    private Logger logger=Logger.getLogger(PriceAction.class);

    @Resource
    private PriceService priceService;
    @Resource
    private MaterialService materialService;

    @RequestMapping(value = "/price",method = RequestMethod.POST)
    public void save(@ModelAttribute PriceVo priceVo){
        priceService.save(priceVo);
    }

    @RequestMapping(value = "/price/{id}",method = RequestMethod.PUT)
    public void update(@PathVariable Long id, @ModelAttribute PriceVo priceVo){
        priceVo.setId(id);
        priceService.update(priceVo);
    }

    @RequestMapping(value = "/price",method = RequestMethod.GET)
    public Map<String,Object> getPrice(Long materialId,Long userId){
        Map<String,Object> result=new HashMap();
        PriceVo vo= priceService.getPrice(materialId,userId);
        if(vo==null){
            MaterialVo materialVo=materialService.getMaterialVoById(materialId);
            if(materialVo!=null){
                vo.setPrice(materialVo.getFRetail());
                vo.setMaterialId(materialVo.getId());
            }else{
                result.put("code", Contants.ERROR_SERVER);
                return result;
            }
        }
        result.put("price",vo.getPrice());
        result.put("materialId",vo.getMaterialId());
        return result;
    }
}
