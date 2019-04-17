package com.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
//用户
@Entity
@Table(name="t_User")
public class User {

	@Id
	@GeneratedValue
	private int id;//主键
	
	private int deletestatus;//是否删除的标志，0表示正常，1表示删除
	
	private String username;//用户名
	
	private String password;//密码
	
	private int role;// 用户角色，1表示管理员，2表示房东，3表示租赁者
	
	private String xingming;//姓名
	
	private String tel;//手机号码
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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


	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getXingming() {
		return xingming;
	}

	public void setXingming(String xingming) {
		this.xingming = xingming;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getDeletestatus() {
		return deletestatus;
	}

	public void setDeletestatus(int deletestatus) {
		this.deletestatus = deletestatus;
	}
	
	

	

	
	
	
	
}
