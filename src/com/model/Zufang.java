package com.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//预约租房
@Entity
@Table(name="t_Zufang")
public class Zufang {

	@Id
	@GeneratedValue
	private int id;//主键
	
	private int deletestatus;//是否删除的标志，0表示正常，1表示删除
	
	@ManyToOne
	@JoinColumn(name="userid")
	private User user;//租房的租赁者，外键
	
	@ManyToOne
	@JoinColumn(name="houseid")
	private House house;//租赁的房子，外键
	
	private String status;//预约中   租房失败   已同意待支付  租房成功
	
	private String xingming;//姓名
	
	private String tel;//手机号码
	
	@Column(name="shouming", columnDefinition="TEXT")
	private String shouming;//租房说明

	private String ctime;//申请时间
	


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getDeletestatus() {
		return deletestatus;
	}


	public void setDeletestatus(int deletestatus) {
		this.deletestatus = deletestatus;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public House getHouse() {
		return house;
	}


	public void setHouse(House house) {
		this.house = house;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getShouming() {
		return shouming;
	}


	public void setShouming(String shouming) {
		this.shouming = shouming;
	}


	public String getCtime() {
		return ctime;
	}


	public void setCtime(String ctime) {
		this.ctime = ctime;
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
	
	
	
}
