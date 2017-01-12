package com.gdut.vo.dto;

import java.util.ArrayList;
import java.util.List;

import com.gdut.vo.AttributeVo;
import com.gdut.vo.MaterialVo;

/**
*描述：
* @author ZListen 
* @version 创建时间：2017年1月11日 下午3:36:00
* 
*/
public class AttributeDTO extends AttributeVo{

	/**
	*描述：
	* @author ZListen
	* @version 创建时间：2017年1月11日 下午3:36:00
	*/
	
	private List<MaterialVo> materials = new ArrayList<>();

	public List<MaterialVo> getMaterials() {
		return materials;
	}

	public void setMaterials(List<MaterialVo> materials) {
		this.materials = materials;
	}
	
	
}
