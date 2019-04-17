package com.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//房源信息
@Entity
@Table(name="t_House")
public class House {

	@Id
	@GeneratedValue
	private int id;//主键
	
	private int deletestatus;//是否删除的标志，0表示正常，1表示删除
	
	@ManyToOne
	@JoinColumn(name="userid")
	private User user;//发布的房东，外键
	
	private String status;//状态  审核中  审核失败  租赁中 租赁成功  已取消
	
	
	private String bianhao;//编号
	
	private String leixing;//房源类型
	
	private String quyu;//房源区域
	
	private String mingchen;//房源名称
	
	private String zhuangxiu;//装修程度
	
	private double money;//月租金
	
	private double mianji;//面积
	
	private String path;//房源图片01
	
	private String path2;//房源图片02
	
	private String path3;//房源图片03
	
	
	@Column(name="shouming", columnDefinition="TEXT")
	private String shouming;//租赁说明
	
	
	private String ctime;//添加时间
	
	private int dianji;//点击数


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


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getBianhao() {
		return bianhao;
	}


	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}


	public String getLeixing() {
		return leixing;
	}


	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}


	public String getQuyu() {
		return quyu;
	}


	public void setQuyu(String quyu) {
		this.quyu = quyu;
	}


	public String getMingchen() {
		return mingchen;
	}


	public void setMingchen(String mingchen) {
		this.mingchen = mingchen;
	}


	public String getZhuangxiu() {
		return zhuangxiu;
	}


	public void setZhuangxiu(String zhuangxiu) {
		this.zhuangxiu = zhuangxiu;
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


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public double getMoney() {
		return money;
	}


	public void setMoney(double money) {
		this.money = money;
	}


	public double getMianji() {
		return mianji;
	}


	public void setMianji(double mianji) {
		this.mianji = mianji;
	}


	public int getDianji() {
		return dianji;
	}


	public void setDianji(int dianji) {
		this.dianji = dianji;
	}


	public String getPath2() {
		return path2;
	}


	public void setPath2(String path2) {
		this.path2 = path2;
	}


	public String getPath3() {
		return path3;
	}


	public void setPath3(String path3) {
		this.path3 = path3;
	}
	
	
	
	
	
}
