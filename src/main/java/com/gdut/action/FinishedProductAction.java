package com.gdut.action;

import com.gdut.service.FinishProductService;
import com.gdut.utils.Contants;
import com.gdut.utils.ReturnUtils;
import com.gdut.vo.FinishedProductVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import java.io.*;
import java.util.*;

/**
 * Created by huang on 2017/1/7.
 */
@RestController
@EnableAutoConfiguration
public class FinishedProductAction {

    @Resource
    private FinishProductService finishProductService;

    private Logger logger=Logger.getLogger(FinishedProductAction.class);

    @RequestMapping(value = "/finish/upload",method = RequestMethod.POST)
    public Map<String,Object> fileUpload(@RequestParam(value = "picture") MultipartFile file){
        if(file.isEmpty()){
            return ReturnUtils.getParamErrorReturn();
        }

        String name=file.getOriginalFilename();
        String lastName=name.split(".")[1];

        if(!"jpg".equals(lastName) && !"gif".equals(lastName) && !"bmp".equals(lastName) && !"png".equals(lastName)){
            return ReturnUtils.getParamErrorReturn();
        }
        logger.debug("FinishedProductAction------------->fileUpload,name"+name);
        File drFile = new File("picture");
        if (!drFile.exists())
            drFile.mkdirs();
        String fileName = randomString()+".jpg";
        System.out.println(drFile.getAbsolutePath());
        try {
            writeToFile(file.getInputStream(), drFile.getPath()+File.separator+fileName);
            Map<String,Object> result=new HashMap<>();
            result.put("url",fileName);
            return result;
        } catch (IOException e) {
            return ReturnUtils.getServerErrorReturn();
        }
    }


    public static String randomString() {
        return UUID.randomUUID().toString();
    }

    public static void writeToFile(InputStream in, String path) {
        try (OutputStream out = new FileOutputStream(path)){
            byte[] buffer = new byte[4096];
            int length;
            while ((length = in.read(buffer)) != -1) {
                out.write(buffer, 0, length);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/admin/finish",method = RequestMethod.POST)
    public Map<String,Object> save(@ModelAttribute FinishedProductVo finishedProductVo,HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();;
        if(finishedProductVo==null){
            return ReturnUtils.getParamErrorReturn();
        }
        try{
            finishProductService.save(finishedProductVo);
            map.put("code", Contants.SUCCESS);
            return map;
        }catch (Exception e){
            logger.error("FinishedProductAction-----------save()"+e);
            map.put("code", Contants.ERROR_SERVER);
            return map;
        }

    }

    @RequestMapping(value = "/admin/finish/{id}",method = RequestMethod.DELETE)
    public Map<String,Object> delete(@PathVariable("id") Long id){

        try{
            finishProductService.delete(id);
            return ReturnUtils.getSuccessReturn();
        }catch(Exception e){
            logger.error("FinishedProductAction-----------delete()"+e);
            return ReturnUtils.getServerErrorReturn();
        }
    }

    @RequestMapping(value = "/admin/finish/{id}",method = RequestMethod.PUT)
    public Map<String,Object> update(@PathVariable Long id,@ModelAttribute FinishedProductVo finishedProductVo){
        try{
            finishedProductVo.setId(id);
            finishProductService.update(finishedProductVo);
            return ReturnUtils.getSuccessReturn();
        }catch (Exception e){
            logger.error("FinishedProductAction-----------update()"+e);
            return ReturnUtils.getServerErrorReturn();
        }
    }

    @RequestMapping(value = "/finish",method = RequestMethod.GET)
    public Map<String,Object> getById(HttpServletRequest request){

        try{
            String strPageNum=request.getParameter("pageNum");
            String strPageSize=request.getParameter("pageSize");

            Integer pageNum=Integer.valueOf(strPageNum);
            Integer pageSize=Integer.valueOf(strPageSize);

            Page<?> page = PageHelper.startPage(pageNum,pageSize,true);
            Map<String,Object> map=new HashMap<>();
            map.put("data",finishProductService.get());
            map.put("total",page.getTotal());
            map.put("per_page",strPageSize);
            map.put("current_page",pageNum);
            return map;
        }catch (Exception e){
            logger.error("FinishedProductAction-----------get()"+e);
            return ReturnUtils.getServerErrorReturn();
        }

    }


    @RequestMapping(value = "/productdetails",method = RequestMethod.GET)
    public Map<String,Object> getProductDetails(){
        Map<String,Object> result=new HashMap<>();
        try{
            result.put("data",finishProductService.getProductDetails());
            return result;
        }catch (Exception e){
            logger.error("FinishedProductAction-----------get()"+e);
            return ReturnUtils.getServerErrorReturn();
        }
    }
}
