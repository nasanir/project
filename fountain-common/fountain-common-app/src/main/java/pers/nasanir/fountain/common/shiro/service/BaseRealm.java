package pers.nasanir.fountain.common.shiro.service;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import pers.nasanir.fountain.common.db.service.JdbcBaseServiceImpl;
import pers.nasanir.fountain.common.user.entity.UserVO;


public class BaseRealm extends AuthorizingRealm {
	@Autowired
	private JdbcBaseServiceImpl jdbcBaseService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		String username = token.getPrincipal().toString();
		SimpleAuthenticationInfo authInfo = null;

		String password = new String((char[]) token.getCredentials());
		UserVO userVO = new UserVO();
		userVO.setUsername(username);
		userVO = (UserVO) jdbcBaseService.query(userVO);
		if (userVO.getUserid() != null) {
			String psd = userVO.getPassword();
			if (!psd.equals(password)) {
				throw new IncorrectCredentialsException("密码错误");
			}
		} else {
			throw new UnknownAccountException("此用户不存在");
		}

		authInfo = new SimpleAuthenticationInfo(token.getPrincipal(), token.getCredentials(), getName());

		return authInfo;
	}

}
