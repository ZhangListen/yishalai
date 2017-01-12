package com.gdut.action;

import com.alibaba.fastjson.JSON;
import com.gdut.service.AttributeService;
import com.gdut.utils.Contants;
import com.gdut.utils.ReturnUtils;
import com.gdut.vo.AttributeVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huang on 2017/1/7.
 */
@RestController
@EnableAutoConfiguration
public class AttributeAction {
    @Resource
    private AttributeService attributeService;

    private Logger logger=Logger.getLogger(AttributeAction.class);

    @RequestMapping(value = "/admin/attribute",method = RequestMethod.POST)
    public Map<String,Object> save(@ModelAttribute AttributeVo attributeVo){
        Map<String,Object> result=new HashMap<>();
        if(attributeVo.getMaterialId()==null || attributeVo.getFinishedId()==null){
            result.put("code",Contants.ERROR_PARAM);
            return result;
        }
        try{
            attributeService.save(attributeVo);
        }catch(Exception e){
            logger.error("AttributeAction.save()---------------------"+e.getMessage());
            result.put("code",Contants.ERROR_SERVER);
            return result;
        }
        result.put("code",Contants.SUCCESS);
        return result;
    }

    @RequestMapping(value = "/admin/attribute/{id}",method = RequestMethod.DELETE)
    public Map<String,Object> delete(@PathVariable("id") Long id){
        Map<String,Object> result=new HashMap<>();
        try{
            attributeService.delete(id);
            result.put("code",Contants.SUCCESS);
            return  result;
        }catch(Exception e){
            logger.error("AttributeAction.delete()---------------------"+e.getMessage());
            result.put("code",Contants.ERROR_SERVER);
            return result;
        }
    }

    @RequestMapping(value = "/attribute/{id}",method = RequestMethod.PUT)
    public Map<String,Object> update(@PathVariable Long id,@ModelAttribute AttributeVo attributeVo){
        Map<String,Object> result=new HashMap<>();
        try{
            attributeVo.setId(id);
            attributeService.update(attributeVo);
            result.put("code",Contants.SUCCESS);
            return result;
        }catch(Exception e){
            logger.error("AttributeAction.update()---------------------"+e.getMessage());
            result.put("code",Contants.ERROR_SERVER);
            return  result;
        }

    }

    @RequestMapping(value = "/attribute/getByFinshedId",method = RequestMethod.GET)
    public Map<String,Object> getByFinshedId(Integer finishedId){
        Map<String,Object> map=new HashMap<>();
        if(finishedId<=0){
            return ReturnUtils.getParamErrorReturn();
        }
        try{
            List<AttributeVo> attributeVoList=attributeService.getByFinshedId(finishedId);
            map.put("data", JSON.toJSON(attributeVoList));
        }catch (Exception e){
            logger.error("AttributeAction.get()---------------------"+e.getMessage());
            map.put("code",Contants.ERROR_SERVER);
            return map;
        }
        return map;
    }
}
