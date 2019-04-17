package com.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
//新闻资讯
@Entity
@Table(name="t_Xinwen")
public class Xinwen {

	@Id
	@GeneratedValue
	private int id;//主键
	
	private int deletestatus;//是否删除的标志，0表示正常，1表示删除
	
	private String xtitle;//新闻标题
	
	@Column(name="xcontent", columnDefinition="TEXT")
	private String xcontent;//新闻内容
	
	private String ctime;//添加时间

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

	public String getXtitle() {
		return xtitle;
	}

	public void setXtitle(String xtitle) {
		this.xtitle = xtitle;
	}

	public String getXcontent() {
		return xcontent;
	}

	public void setXcontent(String xcontent) {
		this.xcontent = xcontent;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	
	
	
	
	
	
}
