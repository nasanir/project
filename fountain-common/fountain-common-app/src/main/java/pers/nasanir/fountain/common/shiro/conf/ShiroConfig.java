package pers.nasanir.fountain.common.shiro.conf;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pers.nasanir.fountain.common.shiro.service.BaseRealm;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
	@Bean
	public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);

		Map<String, String> filterMap = new LinkedHashMap<String, String>();
		filterMap.put("/signup", "anon");
		filterMap.put("/logout", "logout");
		filterMap.put("/blog/**", "authc");
		
		shiroFilterFactoryBean.setLoginUrl("/login");
		shiroFilterFactoryBean.setSuccessUrl("/blog/a");

		shiroFilterFactoryBean.setUnauthorizedUrl("/403");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
		return shiroFilterFactoryBean;
	}

	@Bean
	public BaseRealm realm() {
		BaseRealm realm = new BaseRealm();
		return realm;
	}

	@Bean
	public DefaultWebSecurityManager securityManager() {
		DefaultWebSecurityManager  securityManager = new DefaultWebSecurityManager ();
		securityManager.setRealm(realm());
		return securityManager;
	}
}
