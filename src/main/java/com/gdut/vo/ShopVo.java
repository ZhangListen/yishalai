package com.gdut.vo;

/**
 * @author ZListen
 *
 */
public class ShopVo {
	private Long id;
	private String name;
	private String phone;
	private String address;
	/**
	 * 门店类型（0/null普通门店，1管理员门店）
	 */
	private int shopType;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getShopType() {
		return shopType;
	}
	public void setShopType(int shopType) {
		this.shopType = shopType;
	}
	
	
	
}
