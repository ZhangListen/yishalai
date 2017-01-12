package com.gdut.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.gdut.utils.ReturnUtils;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gdut.service.UserService;
import com.gdut.utils.Contants;
import com.gdut.vo.UserVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 描述：处理登陆、权限相关操作
 * 
 * @author ZListen 20170107
 */

@RestController
@EnableAutoConfiguration
public class UserAction {

	@Resource
	private UserService userService;

	private Logger logger = Logger.getLogger(UserAction.class);

	/**
	 * 描述：增加账号，只限管理员操作
	 * 
	 * @param userVo
	 */
	@RequestMapping(value = "/admin/user", method = RequestMethod.POST)
	public String save(@ModelAttribute UserVo userVo) {

		if (userVo.getAccount() == null || userVo.getName() == null || userVo.getPassword() == null) {
			return Contants.ERROR_PARAM;
		}
		try {
			userService.save(userVo);
		} catch (Exception e) {
			logger.error("UserAction.save()---------------------" + e.getMessage());
			return Contants.ERROR_SERVER;
		}
		return Contants.SUCCESS;
	}

	/**
	 * 描述：删除账号，只限管理员操作
	 * 
	 * @param userVo
	 */
	@RequestMapping(value = "/admin/user/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id) {
		try {
			userService.delete(id);
		} catch (Exception e) {
			logger.error("UserAction.delete()---------------------" + e.getMessage());
			return Contants.ERROR_SERVER;
		}
		return Contants.SUCCESS;

	}

	/**
	 * 描述：更新账号，只限管理员操作
	 * 
	 * @param userVo
	 */
	@RequestMapping(value = "/admin/user/{id}", method = RequestMethod.PUT)
	public String update(@PathVariable Long id, @ModelAttribute UserVo userVo) {
		try {
			userVo.setId(id);
			userService.update(userVo);
		} catch (Exception e) {
			logger.error("UserAction.update()---------------------" + e.getMessage());
			return Contants.ERROR_SERVER;
		}
		return Contants.SUCCESS;
	}

	/**
	 * 描述：批量获得账号，只限管理员操作
	 *
	 */
	@RequestMapping(value = "/admin/user", method = RequestMethod.GET)
	public Map<String, Object> get(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		try {
			String strPageNum = request.getParameter("pageNum");
			String strPageSize = request.getParameter("pageSize");

			Integer pageNum = Integer.valueOf(strPageNum);
			Integer pageSize = Integer.valueOf(strPageSize);

			Page<?> page = PageHelper.startPage(pageNum, pageSize, true);
			map.put("data", userService.getList());
			map.put("total", page.getTotal());
			map.put("per_page", strPageSize);
			map.put("current_page", pageNum);
		} catch (Exception e) {
			logger.error("UserAction.get()---------------------" + e.getMessage());
			map.put("code", "901");
			return map;
		}
		return map;

	}


	@RequestMapping(value = "/user/getByShopId/{shopId}", method = RequestMethod.GET)
	public Map<String,Object> getUserByShopId(@PathVariable("shopId")Long shopId){
		if(shopId<=0){
			return ReturnUtils.getParamErrorReturn();
		}
		Map<String,Object> result=new HashMap<>();
		try{
			List<UserVo> userVos=userService.getByShopId(shopId);
			result.put("data",userVos);
			return result;
		}catch (Exception e){
			logger.error("UserAction.getUserByShopId()---------->"+e.getMessage());
			return ReturnUtils.getServerErrorReturn();
		}
	}

	/**
	 * 描述：单个查找，可用于登录操作
	 * 
	 * @param userVo
	 */
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String get(@ModelAttribute UserVo userVo, HttpSession httpSession) {

		if (userVo.getAccount() == null || userVo.getPassword() == null) {
			return Contants.ERROR_PARAM;
		}

		try {
			List<UserVo> list = userService.get(userVo);
			if (list != null && list.size() > 0) {
				UserVo vo = list.get(0);
				if (vo != null) {
					UserVo user = new UserVo();
					//去掉用户密码后保存到Session
					user.setPassword(null);
					httpSession.setAttribute("user", user);
					return Contants.SUCCESS;
				}
			}

		} catch (Exception e) {
			logger.error("UserAction.get()---------------------" + e.getMessage());
			return Contants.ERROR_SERVER;
		}
		return Contants.SUCCESS;
	}
}
