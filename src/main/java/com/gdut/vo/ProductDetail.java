package com.gdut.vo;

/**
 * 描述：用于从数据库一次性取出所需的成品数据
 * @author ZListen
 *
 */
public class ProductDetail extends MaterialVo {
	
	/**
	 * 成品的数量
	 */
	private Integer pNum;
    /**
     * 成品的链接
     */
    private String pUrl;
    /**
     * 属性的Id
     */
    private Long aId;
    /**
     * 属性的名字
     */
    private String attributeName;
    /**
     * 属性的数量
     */
    private Integer aNum;
    /**
     * 材料的URL
     */
    private String aUrl;    
    /**
     * 材料的ID
     */
    private Long materialId;
	public Integer getpNum() {
		return pNum;
	}
	public void setpNum(Integer pNum) {
		this.pNum = pNum;
	}
	public String getpUrl() {
		return pUrl;
	}
	public void setpUrl(String pUrl) {
		this.pUrl = pUrl;
	}
	public Long getaId() {
		return aId;
	}
	public void setaId(Long aId) {
		this.aId = aId;
	}
	public String getAttributeName() {
		return attributeName;
	}
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
	public Integer getaNum() {
		return aNum;
	}
	public void setaNum(Integer aNum) {
		this.aNum = aNum;
	}
	public String getaUrl() {
		return aUrl;
	}
	public void setaUrl(String aUrl) {
		this.aUrl = aUrl;
	}
	public Long getMaterialId() {
		return materialId;
	}
	public void setMaterialId(Long materialId) {
		this.materialId = materialId;
	}
	
}
