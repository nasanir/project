package pers.nasanir.fountain.common.user.entity;

import pers.nasanir.fountain.common.common.anno.PeaceField;
import pers.nasanir.fountain.common.common.anno.PeaceTable;
import pers.nasanir.fountain.common.common.entity.BaseVO;

import java.util.Date;


@PeaceTable(name = "blog_user", isView = true)
public class UserVO extends BaseVO {
	
	@PeaceField(isPk=true)
	private Long userid;
	@PeaceField
	private String usercode;
	@PeaceField
	private String username;
	@PeaceField
	private String password;
	@PeaceField
	private Integer isenable;
	@PeaceField
	private Integer islock;
	@PeaceField
	private Date lock_dt;
	@PeaceField
	private Date created_dt;
	@PeaceField
	private String email;
	@PeaceField
	private String mobile;

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getIsenable() {
		return isenable;
	}

	public void setIsenable(Integer isenable) {
		this.isenable = isenable;
	}

	public Integer getIslock() {
		return islock;
	}

	public void setIslock(Integer islock) {
		this.islock = islock;
	}

	public Date getLock_dt() {
		return lock_dt;
	}

	public void setLock_dt(Date lock_dt) {
		this.lock_dt = lock_dt;
	}

	public Date getCreated_dt() {
		return created_dt;
	}

	public void setCreated_dt(Date created_dt) {
		this.created_dt = created_dt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
