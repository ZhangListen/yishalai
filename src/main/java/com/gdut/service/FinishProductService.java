package com.gdut.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdut.dao.AttributeDao;
import com.gdut.dao.FinishProductDao;
import com.gdut.vo.AttributeVo;
import com.gdut.vo.FinishedProductVo;
import com.gdut.vo.MaterialVo;
import com.gdut.vo.ProductDetail;
import com.gdut.vo.dto.AttributeDTO;
import com.gdut.vo.dto.ProductDTO;
import com.sun.javafx.collections.MappingChange.Map;

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
    public Map<String,Object> getProductDetails(){
    	
    	//用于返回前端的数据
    	HashMap<String, Object> result=new HashMap<>();
    	//待组装数据
    	List<ProductDetail> details = finishProductDao.getProductDetail();
    	List<ProductDTO> products = new ArrayList<>();    	
    	result.put("data", products);
    	
    	
    	List<AttributeDTO> attributes = new ArrayList<>();
    	List<MaterialVo> maters = new ArrayList<>();
    	
    	
    	Long pId = null;
    	Long aId = null;
    	
    	ProductDTO pTemp = new ProductDTO();
    	pTemp.setAttrbutes(new ArrayList<AttributeDTO>());
    	AttributeDTO aTemp  = new AttributeDTO();
    	aTemp.setMaterials(new ArrayList<MaterialVo>());
    	
    	HashMap<Long,ProductDTO> product = new HashMap<>();
    	HashMap<Long,AttributeDTO> attr = new HashMap<>();
    	HashMap<Long,MaterialVo> mater = new HashMap<>();
    	//
    	for (ProductDetail vo : details) {
			//
    		if(pId == null){
				pId = vo.getId();
				pTemp.setId(vo.getId());
				pTemp.setNum(vo.getpNum());
				pTemp.setUrl(vo.getpUrl());
			}
    		
    		//
			if(aId == null){
				aId = vo.getaId();
				aTemp.setAttributeName(vo.getAttributeName());
				aTemp.setFinishedId(vo.getId());
				aTemp.setId(vo.getaId());
				aTemp.setMaterialId(vo.getMaterialId());
				aTemp.setUrl(vo.getaUrl());
			}
			MaterialVo m = new MaterialVo();
			m.setFCategory(vo.getFCategory());
			m.setFCost(vo.getFCost());
			m.setFCut(vo.getFCut());
			m.setFHeight(vo.getFHeight());
			m.setFID(vo.getFID());
			m.setFMaterial(vo.getFMaterial());
			m.setFName(vo.getFName());
			m.setFPart(vo.getFPart());
			m.setFRetail(vo.getFRetail());
			m.setFTotal(vo.getFTotal());
			m.setFUnit(vo.getFUnit());
			m.setFVol(vo.getFVol());
			m.setFWidth(vo.getFWidth());
			m.setId(vo.getMaterialId());
			mater.put(vo.getMaterialId(), m);
			
			if(aId != null){
				attr.put(aId, aTemp);
				aId = vo.getaId();
				aTemp = new AttributeDTO();
		    	aTemp.setMaterials(new ArrayList<MaterialVo>());
				aTemp.setAttributeName(vo.getAttributeName());
				aTemp.setFinishedId(vo.getId());
				aTemp.setId(vo.getaId());
				aTemp.setMaterialId(vo.getMaterialId());
				aTemp.setUrl(vo.getaUrl());
			}
			
    		
			if(pId != vo.getId()){
				product.put(pId, pTemp);
				pId = vo.getId();
				pTemp = new ProductDTO();
		    	pTemp.setAttrbutes(new ArrayList<AttributeDTO>());
				pTemp.setId(vo.getId());
				pTemp.setNum(vo.getpNum());
				pTemp.setUrl(vo.getpUrl());
			}
			
		}
    	//添加最后的数据
    	product.put(pId, pTemp);
    	attr.put(aId, aTemp);
    	
    	//组装返回数据
    	for(Long attrId : attr.keySet()){
    		product.get(attr.get(attrId).getFinishedId()).getAttrbutes().add(attr.get(attrId));
    	}
    	
    	
    	return null; 
    }
}
