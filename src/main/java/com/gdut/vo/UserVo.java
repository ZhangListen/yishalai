package com.gdut.vo;
/**
 * 描述：用户账号VO
 * 
 * @author ZListen
 *  20170107
 */
public class UserVo {
	 private Long id;
	 private String account;
	 private String password;
	 private String name;
	 private Long shopId;
	 
	/**
	 * 查询店铺Id所属后，保存用户类型
	 */
	private int userType;	 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getShopId() {
		return shopId;
	}
	public void setUserType(Long shopId) {
		this.shopId = shopId;
	}
//	public UserVo getUserVo() {
//		return this;
//	}
//	public void setUserVo(UserVo userVo) {
//		this.id = userVo.getId();
//		this.account = userVo.getAccount();
//		this.password = userVo.getPassword();
//		this.name = userVo.getName();
//		this.userType = userVo.getUserType();
//		
//	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	 
}
