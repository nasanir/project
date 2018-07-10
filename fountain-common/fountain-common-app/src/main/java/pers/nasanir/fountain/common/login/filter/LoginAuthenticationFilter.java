package pers.nasanir.fountain.common.login.filter;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class LoginAuthenticationFilter extends FormAuthenticationFilter {
	private boolean isAjax(ServletRequest request){
		if(((HttpServletRequest)request).getHeader("X-Requested-With")!=null){
			
		}
		
		return false;
	}
}
