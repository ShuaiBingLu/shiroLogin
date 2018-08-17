package cn.bin2.web.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	private Long id;
	private String nickName;
	private String userName;
	private String userPwd;
	private Date createTime;
	private Date lastLoginTime;
	private int loginStatus;
	public User(){};
	public User(Long id, String nickName, String userName, String userPwd, Date createTime, Date lastLoginTime,
			int loginStatus) {
		super();
		this.id = id;
		this.nickName = nickName;
		this.userName = userName;
		this.userPwd = userPwd;
		this.createTime = createTime;
		this.lastLoginTime = lastLoginTime;
		this.loginStatus = loginStatus;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", nickName=" + nickName + ", userName=" + userName + ", userPwd=" + userPwd
				+ ", createTime=" + createTime + ", lastLoginTime=" + lastLoginTime + ", loginStatus=" + loginStatus
				+ "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public int getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(int loginStatus) {
		this.loginStatus = loginStatus;
	}
}
