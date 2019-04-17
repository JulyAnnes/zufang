package com.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//回复
@Entity
@Table(name="t_Huifu")
public class Huifu {

	@Id
	@GeneratedValue
	private int id;
	
	private int deletestatus;//表示是否删除的状态，0表示未删除，1表示删除
	
	@ManyToOne
	@JoinColumn(name="tieziid")
	private Tiezi tiezi;//关联的帖子，外键
	
	
	@Column(name="hcontent", columnDefinition="TEXT")
	private String hcontent;//回复内容
	
	private String ctime;//回复时间

	@ManyToOne
	@JoinColumn(name="userid")
	private User user;//回复用户

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

	public Tiezi getTiezi() {
		return tiezi;
	}

	public void setTiezi(Tiezi tiezi) {
		this.tiezi = tiezi;
	}

	public String getHcontent() {
		return hcontent;
	}

	public void setHcontent(String hcontent) {
		this.hcontent = hcontent;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	
	
	
	
}
