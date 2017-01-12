package com.gdut.action;

import com.gdut.service.MaterialService;
import com.gdut.utils.Contants;
import com.gdut.vo.MaterialVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.StringUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.util.StringUtils;
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
public class MaterialAction {

    @Resource
    private MaterialService materialService;

    private Logger logger=Logger.getLogger(MaterialAction.class);

    @RequestMapping(value = "/admin/material",method = RequestMethod.POST)
    public Map<String,Object> save(@ModelAttribute MaterialVo materialVo){

        Map<String,Object> result=new HashMap<>();
        if(materialVo==null){
            result.put("code", Contants.ERROR_PARAM);
            return result;
        }
        try{
            materialService.save(materialVo);
            result.put("code",Contants.SUCCESS);
            return result;
        }catch(Exception e){
            logger.error("MaterialAction------->save()"+e.getMessage());
            result.put("code",Contants.ERROR_SERVER);
            return result;
        }

    }

    @RequestMapping(value = "/admin/material/{id}",method = RequestMethod.DELETE)
    public Map<String,Object> delete(@PathVariable("id") Long id){
        Map<String,Object> result=new HashMap<>();
        if(id==null || id<=0){
            result.put("code", Contants.ERROR_PARAM);
            return result;
        }
        try{
            materialService.delete(id);
            result.put("code",Contants.SUCCESS);
            return result;
        }catch (Exception e){
            logger.error("MaterialAction------->delete()"+e.getMessage());
            result.put("code",Contants.ERROR_SERVER);
            return result;
        }

    }

    @RequestMapping(value = "/admin/material/{id}",method = RequestMethod.PUT)
    public Map<String,Object> update(@PathVariable Long id,@ModelAttribute MaterialVo materialVo){
        Map<String,Object> result=new HashMap<>();
        if(id==null || id<=0 || materialVo==null){
            result.put("code", Contants.ERROR_PARAM);
            return result;
        }
        try{
            materialVo.setId(id);
            materialService.update(materialVo);
            result.put("code",Contants.SUCCESS);
            return result;
        }catch (Exception e){
            logger.error("MaterialAction------->update()"+e.getMessage());
            result.put("code",Contants.ERROR_SERVER);
            return result;
        }

    }

    @RequestMapping(value = "/material",method = RequestMethod.GET)
    public Map<String,Object> get(HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try{
            String strPageNum=request.getParameter("pageNum");
            String strPageSize=request.getParameter("pageSize");

            if(StringUtil.isEmpty(strPageNum) ||StringUtil.isEmpty(strPageSize)){
                map.put("code",Contants.ERROR_PARAM);
                return map;
            }

            Integer pageNum=Integer.valueOf(strPageNum);
            Integer pageSize=Integer.valueOf(strPageSize);

            Page<?> page = PageHelper.startPage(pageNum,pageSize,true);

            map.put("data",materialService.get());
            map.put("total",page.getTotal());
            map.put("per_page",strPageSize);
            map.put("current_page",pageNum);
            return map;
        }catch (Exception e){
            logger.error("MaterialAction------->update()"+e.getMessage());
            map.put("code",Contants.ERROR_SERVER);
            return map;
        }

    }
}
