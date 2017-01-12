package com.gdut.vo.dto;

import java.util.ArrayList;
import java.util.List;

import com.gdut.vo.AttributeVo;
import com.gdut.vo.FinishedProductVo;

/**
*描述：
* @author ZListen 
* @version 创建时间：2017年1月11日 下午3:33:24
* 
*/
public class ProductDTO  extends FinishedProductVo{

	/**
	*描述：
	* @author ZListen
	* @version 创建时间：2017年1月11日 下午3:33:24
	*/
	
	private List<AttributeDTO> attrbutes = new ArrayList<>();

	public List<AttributeDTO> getAttrbutes() {
		return attrbutes;
	}

	public void setAttrbutes(List<AttributeDTO> attrbutes) {
		this.attrbutes = attrbutes;
	} 
	
}
