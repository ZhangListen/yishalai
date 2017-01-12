package com.gdut.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.gdut.vo.UserVo;
/**
 * 描述：拦截器——用于检查用户是否是管理员
 * 
 * @author ZListen 20170108
 */
public class AdminSecurityInterceptor  implements HandlerInterceptor {  
  
    @Override  
    public boolean preHandle(HttpServletRequest request,  
            HttpServletResponse response, Object handler) throws Exception {  
    	HttpSession session = request.getSession();
		UserVo user = (UserVo) session.getAttribute("userInfo");
		if(user != null && user.getUserType()==1)
			System.out.println("——————————管理员用戶"+user.getName()+"已登录");
		// TODO Auto-generated method stub
        return true;  
    }  
  

	@Override  
    public void postHandle(HttpServletRequest request,  
            HttpServletResponse response, Object handler,  
            ModelAndView modelAndView) throws Exception {  
    }  
  
    @Override  
    public void afterCompletion(HttpServletRequest request,  
            HttpServletResponse response, Object handler, Exception ex)  
            throws Exception {  
  
    }  
  
}  