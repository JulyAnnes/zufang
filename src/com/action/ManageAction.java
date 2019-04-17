package com.action;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.HouseDao;
import com.dao.HuifuDao;
import com.dao.PicDao;
import com.dao.TieziDao;
import com.dao.UserDao;
import com.dao.XinwenDao;
import com.model.House;
import com.model.Huifu;
import com.model.Pic;
import com.model.Tiezi;
import com.model.User;
import com.model.Xinwen;
import com.util.Pager;
import com.util.Util;

public class ManageAction extends BaseAction {

	private static final long serialVersionUID = -4304509122548259589L;

	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
	
//登入请求
	public String login() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = userDao.selectBean(" where username = '" + username
				+ "' and password= '" + password + "' and role=1  ");
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			this.setUrl("manage/index.jsp");
			return "redirect";
		} else {
			writer.print("<script language=javascript>alert('用户名或者密码错误');window.location.href='login.jsp';</script>");
		}
		return null;
	}
//用户退出
	public String loginout() {
		HttpServletRequest request = this.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		this.setUrl("login.jsp");
		return SUCCESS;
	}

//修改密码操作
	public void changepwd2() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("user");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		User bean = userDao.selectBean(" where username= '"+u.getUsername()+"' and password= '"+password1+"' ");
		if(bean!=null){
			bean.setPassword(password2);
			userDao.updateBean(bean);
			
			writer.print("<script language=javascript>alert('修改成功');window.location.href='password.jsp';</script>");
			
		}else{
			
			writer.print("<script language=javascript>alert('原密码错误');window.location.href='password.jsp';</script>");
			
		}
	}
	
	
	private PicDao picDao;

	public PicDao getPicDao() {
		return picDao;
	}

	public void setPicDao(PicDao picDao) {
		this.picDao = picDao;
	}

	
	private File uploadfile;
	
	

	public File getUploadfile() {
		return uploadfile;
	}

	public void setUploadfile(File uploadfile) {
		this.uploadfile = uploadfile;
	}
	
	//首页图片列表
	public String piclist() {
		HttpServletRequest request = this.getRequest();
		StringBuffer sb = new StringBuffer();
		sb.append(" where 1=1 order by id desc");
		String where = sb.toString();

		request.setAttribute("list", picDao.selectBeanList(0, 9999, where));
		this.setUrl("pic/piclist.jsp");
		return SUCCESS;

	}

//跳转到更新首页图片页面
	public String picupdate() {
		HttpServletRequest request = this.getRequest();
		Pic bean = picDao.selectBean(" where id= "
				+ request.getParameter("id"));
		request.setAttribute("bean", bean);
		request.setAttribute("url", "method!picupdate2.action?id="+bean.getId());
		request.setAttribute("title", "首页图片信息修改");
		this.setUrl("pic/picupdate.jsp");
		return SUCCESS;
	}
//更新首页图片操作
	public void picupdate2() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		
		String info = request.getParameter("info");
		String href = request.getParameter("href");
		
		
		Pic bean = picDao.selectBean(" where id= "+ request.getParameter("id"));
		bean.setInfo(info);
		bean.setHref(href);
		
		
		
		if(uploadfile!=null){
			String savapath = ServletActionContext.getServletContext().getRealPath("/")+"/uploadfile/";
			String time = Util.getTime2();
			String imgpath = time+".jpg";
			File file = new File(savapath+imgpath);
			Util.copyFile(uploadfile, file);

			bean.setPath(imgpath);
		}
		
		picDao.updateBean(bean);
		
		writer.print("<script language=javascript>alert('操作成功');window.location.href='method!piclist.action';</script>");
		
	}
	
	
	
	private XinwenDao xinwenDao;

	public XinwenDao getXinwenDao() {
		return xinwenDao;
	}

	public void setXinwenDao(XinwenDao xinwenDao) {
		this.xinwenDao = xinwenDao;
	}
	
	
	//新闻资讯列表
	public String xinwenlist() {
		HttpServletRequest request = this.getRequest();
		String xtitle = request.getParameter("xtitle");
		
		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");

		if (xtitle != null && !"".equals(xtitle)) {

			sb.append("xtitle like '%" + xtitle + "%'");
			sb.append(" and ");
			request.setAttribute("xtitle", xtitle);
		}
		

		sb.append("   deletestatus=0 order by id desc ");
		String where = sb.toString();


		int currentpage = 1;
		int pagesize = 10;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = xinwenDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		request.setAttribute("list", xinwenDao.selectBeanList((currentpage - 1)
				* pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "method!xinwenlist.action", "共有" + total + "条记录"));
		request.setAttribute("url", "method!xinwenlist.action");
		request.setAttribute("url2", "method!xinwen");
		request.setAttribute("title", "新闻资讯管理");
		this.setUrl("xinwen/xinwenlist.jsp");
		return SUCCESS;

	}
//跳转到添加新闻资讯页面
	public String xinwenadd() {
		HttpServletRequest request = this.getRequest();
		request.setAttribute("url", "method!xinwenadd2.action");
		
		
		request.setAttribute("title", "新闻资讯添加");
		this.setUrl("xinwen/xinwenadd.jsp");
		return SUCCESS;
	}
//添加新闻资讯操作
	public void xinwenadd2() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		
		String xcontent = request.getParameter("xcontent");
		String xtitle = request.getParameter("xtitle");
		
		Xinwen bean = new Xinwen();
		
		bean.setCtime(Util.getTime());
		bean.setXcontent(xcontent);
		bean.setXtitle(xtitle);
		
		
		xinwenDao.insertBean(bean);
		
		
		writer.print("<script language=javascript>alert('操作成功');window.location.href='method!xinwenlist.action';</script>");
		
	}
//跳转到更新新闻资讯页面
	public String xinwenupdate() {
		HttpServletRequest request = this.getRequest();
		Xinwen bean = xinwenDao.selectBean(" where id= "
				+ request.getParameter("id"));
		request.setAttribute("bean", bean);
		request.setAttribute("url", "method!xinwenupdate2.action?id="+bean.getId());
		request.setAttribute("title", "新闻资讯信息修改");
		this.setUrl("xinwen/xinwenupdate.jsp");
		return SUCCESS;
	}
	
//更新新闻资讯操作
	public void xinwenupdate2() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		
		String xcontent = request.getParameter("xcontent");
		String xtitle = request.getParameter("xtitle");
		
		Xinwen bean = xinwenDao.selectBean(" where id= "
				+ request.getParameter("id"));
		
		bean.setXcontent(xcontent);
		bean.setXtitle(xtitle);
		
		xinwenDao.updateBean(bean);
		
		writer.print("<script language=javascript>alert('操作成功');window.location.href='method!xinwenlist.action';</script>");
		
	}
	
	
	//删除新闻资讯操作
	public void xinwendelete() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		
		Xinwen bean = xinwenDao.selectBean(" where id= "
				+ request.getParameter("id"));
		
		bean.setDeletestatus(1);
		
		xinwenDao.updateBean(bean);
		
		
		writer.print("<script language=javascript>alert('操作成功');window.location.href='method!xinwenlist.action';</script>");
		
	}
	
	
	//跳转到查看新闻资讯页面
	public String xinwenupdate3() {
		HttpServletRequest request = this.getRequest();
		Xinwen bean = xinwenDao.selectBean(" where id= "
				+ request.getParameter("id"));
		request.setAttribute("bean", bean);
		request.setAttribute("url", "method!xinwenupdate2.action?id="+bean.getId());
		request.setAttribute("title", "新闻资讯信息查看");
		this.setUrl("xinwen/xinwenupdate3.jsp");
		return SUCCESS;
	}
	
	
	private HouseDao houseDao;

	public HouseDao getHouseDao() {
		return houseDao;
	}

	public void setHouseDao(HouseDao houseDao) {
		this.houseDao = houseDao;
	}
	
	
	
	//房源信息列表
	public String houselist() {
		HttpServletRequest request = this.getRequest();
		String mingchen = request.getParameter("mingchen");
		
		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");

		if (mingchen != null && !"".equals(mingchen)) {

			sb.append("mingchen like '%" + mingchen + "%'");
			sb.append(" and ");
			request.setAttribute("mingchen", mingchen);
		}
		

		sb.append("   deletestatus=0  and status='审核中' order by id desc ");
		String where = sb.toString();


		int currentpage = 1;
		int pagesize = 10;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = houseDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		request.setAttribute("list", houseDao.selectBeanList((currentpage - 1)
				* pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "method!houselist.action", "共有" + total + "条记录"));
		request.setAttribute("url", "method!houselist.action");
		request.setAttribute("url2", "method!house");
		request.setAttribute("title", "房源信息审核");
		this.setUrl("house/houselist.jsp");
		return SUCCESS;

	}
	
	
//跳转到审核房源信息页面
	public String houseupdate() {
		HttpServletRequest request = this.getRequest();
		House bean = houseDao.selectBean(" where id= "
				+ request.getParameter("id"));
		request.setAttribute("bean", bean);
		request.setAttribute("url", "method!houseupdate2.action?id="+bean.getId());
		request.setAttribute("title", "审核房源信息");
		this.setUrl("house/houseupdate.jsp");
		return SUCCESS;
	}
	
//审核房源信息操作
	public void houseupdate2() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		String status = request.getParameter("status");
		
		House bean = houseDao.selectBean(" where id= "
				+ request.getParameter("id"));
		
		
		bean.setStatus(status);
		
		houseDao.updateBean(bean);
		
		writer.print("<script language=javascript>alert('操作成功');window.location.href='method!houselist.action';</script>");
		
	}
	
	
	//删除房源信息操作
	public void housedelete() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		
		House bean = houseDao.selectBean(" where id= "
				+ request.getParameter("id"));
		
		bean.setDeletestatus(1);
		
		houseDao.updateBean(bean);
		
		
		writer.print("<script language=javascript>alert('操作成功');window.location.href='method!houselist.action';</script>");
		
	}
	
	
	//跳转到查看房源信息页面
	public String houseupdate3() {
		HttpServletRequest request = this.getRequest();
		
		House bean = houseDao.selectBean(" where id= "
				+ request.getParameter("id"));
		request.setAttribute("bean", bean);
		request.setAttribute("url", "method!houseupdate2.action?id="+bean.getId());
		request.setAttribute("title", "房源信息信息查看");
		this.setUrl("house/houseupdate3.jsp");
		return SUCCESS;
	}
	
	
	
	
	//所有房源列表
	public String houselist2() {
		HttpServletRequest request = this.getRequest();
		String mingchen = request.getParameter("mingchen");
		
		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");

		if (mingchen != null && !"".equals(mingchen)) {

			sb.append("mingchen like '%" + mingchen + "%'");
			sb.append(" and ");
			request.setAttribute("mingchen", mingchen);
		}
		

		sb.append("   deletestatus=0   order by id desc ");
		String where = sb.toString();


		int currentpage = 1;
		int pagesize = 10;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = houseDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		request.setAttribute("list", houseDao.selectBeanList((currentpage - 1)
				* pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "method!houselist2.action", "共有" + total + "条记录"));
		request.setAttribute("url", "method!houselist2.action");
		request.setAttribute("url2", "method!house");
		request.setAttribute("title", "所有房源");
		this.setUrl("house/houselist2.jsp");
		return SUCCESS;

	}
	
	
	//租赁中房源列表
	public String houselist3() {
		HttpServletRequest request = this.getRequest();
		String mingchen = request.getParameter("mingchen");
		
		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");

		if (mingchen != null && !"".equals(mingchen)) {

			sb.append("mingchen like '%" + mingchen + "%'");
			sb.append(" and ");
			request.setAttribute("mingchen", mingchen);
		}
		

		sb.append("   deletestatus=0 and status='租赁中'  order by id desc ");
		String where = sb.toString();


		int currentpage = 1;
		int pagesize = 10;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = houseDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		request.setAttribute("list", houseDao.selectBeanList((currentpage - 1)
				* pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "method!houselist3.action", "共有" + total + "条记录"));
		request.setAttribute("url", "method!houselist3.action");
		request.setAttribute("url2", "method!house");
		request.setAttribute("title", "租赁中房源");
		this.setUrl("house/houselist3.jsp");
		return SUCCESS;

	}
	
	
	
	//用户列表
	public String userlist() {
		HttpServletRequest request = this.getRequest();
		String username = request.getParameter("username");
		
		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");

		if (username != null && !"".equals(username)) {

			sb.append("username like '%" + username + "%'");
			sb.append(" and ");
			request.setAttribute("username", username);
		}
		

		sb.append("   deletestatus=0  and role!=1  order by id desc ");
		String where = sb.toString();


		int currentpage = 1;
		int pagesize = 10;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = userDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		request.setAttribute("list", userDao.selectBeanList((currentpage - 1)
				* pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "method!userlist.action", "共有" + total + "条记录"));
		request.setAttribute("url", "method!userlist.action");
		request.setAttribute("url2", "method!user");
		request.setAttribute("title", "用户管理");
		this.setUrl("user/userlist.jsp");
		return SUCCESS;

	}
	
	
	
	
	//删除用户操作
	public void userdelete() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		
		User bean = userDao.selectBean(" where id= "
				+ request.getParameter("id"));
		
		bean.setDeletestatus(1);
		
		userDao.updateBean(bean);
		
		
		writer.print("<script language=javascript>alert('操作成功');window.location.href='method!userlist.action';</script>");
		
	}
	
	
	private TieziDao tieziDao;
	
	private HuifuDao huifuDao;

	public TieziDao getTieziDao() {
		return tieziDao;
	}

	public void setTieziDao(TieziDao tieziDao) {
		this.tieziDao = tieziDao;
	}

	public HuifuDao getHuifuDao() {
		return huifuDao;
	}

	public void setHuifuDao(HuifuDao huifuDao) {
		this.huifuDao = huifuDao;
	}
	
	
	
	//帖子列表
	public String tiezilist() {
		HttpServletRequest request = this.getRequest();
		String ltitle = request.getParameter("ltitle");
		
		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");

		if (ltitle != null && !"".equals(ltitle)) {

			sb.append("ltitle like '%" + ltitle + "%'");
			sb.append(" and ");
			request.setAttribute("ltitle", ltitle);
		}
		

		sb.append("   deletestatus=0 order by id desc ");
		String where = sb.toString();


		int currentpage = 1;
		int pagesize = 10;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = tieziDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		request.setAttribute("list", tieziDao.selectBeanList((currentpage - 1)
				* pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "method!tiezilist.action", "共有" + total + "条记录"));
		request.setAttribute("url", "method!tiezilist.action");
		request.setAttribute("url2", "method!tiezi");
		request.setAttribute("title", "帖子管理");
		this.setUrl("tiezi/tiezilist.jsp");
		return SUCCESS;

	}
	
	
	//删除帖子操作
	public void tiezidelete() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		
		Tiezi bean = tieziDao.selectBean(" where id= "
				+ request.getParameter("id"));
		
		bean.setDeletestatus(1);
		
		tieziDao.updateBean(bean);
		
		
		List<Huifu> list = huifuDao.selectBeanList(0, 9999, " where deletestatus=0 and tiezi.id= "+bean.getId());
		
		for(Huifu h:list){
			h.setDeletestatus(1);
			huifuDao.updateBean(h);
			
		}
		
		writer.print("<script language=javascript>alert('操作成功');window.location.href='method!tiezilist.action';</script>");
		
	}
	
	
	//回复列表
	public String huifulist() {
		HttpServletRequest request = this.getRequest();
		String hcontent = request.getParameter("hcontent");
		
		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");

		if (hcontent != null && !"".equals(hcontent)) {

			sb.append("hcontent like '%" + hcontent + "%'");
			sb.append(" and ");
			request.setAttribute("hcontent", hcontent);
		}
		

		sb.append("   deletestatus=0 order by id desc ");
		String where = sb.toString();


		int currentpage = 1;
		int pagesize = 10;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = huifuDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		request.setAttribute("list", huifuDao.selectBeanList((currentpage - 1)
				* pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "method!huifulist.action", "共有" + total + "条记录"));
		request.setAttribute("url", "method!huifulist.action");
		request.setAttribute("url2", "method!huifu");
		request.setAttribute("title", "回复管理");
		this.setUrl("huifu/huifulist.jsp");
		return SUCCESS;

	}
	
	
	//删除回复操作
	public void huifudelete() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		
		Huifu bean = huifuDao.selectBean(" where id= "
				+ request.getParameter("id"));
		
		bean.setDeletestatus(1);
		
		huifuDao.updateBean(bean);
		
		
		writer.print("<script language=javascript>alert('操作成功');window.location.href='method!huifulist.action';</script>");
		
	}
	
}
