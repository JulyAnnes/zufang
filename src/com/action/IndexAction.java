package com.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
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
import com.dao.ZufangDao;
import com.model.House;
import com.model.Huifu;
import com.model.Pic;
import com.model.Tiezi;
import com.model.User;
import com.model.Xinwen;
import com.model.Zufang;
import com.util.Pager;
import com.util.Util;










public class IndexAction extends BaseAction {

	private static final long serialVersionUID = -4304509122548259589L;

	private PicDao picDao;

	
	

	public PicDao getPicDao() {
		return picDao;
	}




	public void setPicDao(PicDao picDao) {
		this.picDao = picDao;
	}


	
	private XinwenDao xinwenDao;

	public XinwenDao getXinwenDao() {
		return xinwenDao;
	}

	public void setXinwenDao(XinwenDao xinwenDao) {
		this.xinwenDao = xinwenDao;
	}

	
	
	

	//网站首页
	public String index() {
		HttpServletRequest request = this.getRequest();
		Util.init(request);
		
		request.setAttribute("xinwenlist", xinwenDao.selectBeanList(0, 6, " where deletestatus=0 order by id desc  "));
		
		
		//随机取4条
		request.setAttribute("houselist",houseDao.selectBeanList(0, 4, " where  deletestatus=0  and status='租赁中' order by dianji desc  "));
		
		List<Pic> list = picDao.selectBeanList(0, 9999, " order by id   ");
		
		StringBuffer  pics= new StringBuffer();
		StringBuffer links= new StringBuffer();
		StringBuffer texts= new StringBuffer();
		
		for(int i=0;i<list.size();i++){
			pics.append("uploadfile/"+list.get(i).getPath());
			links.append(list.get(i).getHref());
			texts.append(list.get(i).getInfo());
			if(i<list.size()-1){
				pics.append("|");
				links.append("|");
				texts.append("|");
			}
			
			
		}
	
		
		request.setAttribute("pics",pics);
		request.setAttribute("links",links);
		request.setAttribute("texts",texts );
		
		
		return "success";
	}

	
	
	//新闻资讯列表
	public String xinwenlist() throws Exception {

		HttpServletRequest request = this.getRequest();
		
		
		String xtitle = request.getParameter("xtitle");
		
		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");

		if (xtitle != null && !"".equals(xtitle)) {

			sb.append("xtitle like '%" + xtitle + "%'");
			sb.append(" and ");
			request.setAttribute("xtitle", xtitle);
		}
		
		sb.append("  deletestatus=0  order by id desc ");
	
		
		String where = sb.toString();


		int currentpage = 1;
		int pagesize = 15;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		
		int total = xinwenDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		
		request.setAttribute("xinwenlist", xinwenDao.selectBeanList((currentpage - 1)* pagesize, pagesize, where));
		
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,currentpage, "indexmethod!xinwenlist", "共有" + total + "条记录"));

		request.setAttribute("url", "indexmethod!xinwenlist");
		request.setAttribute("title", "新闻资讯");
		this.setUrl("xinwenlist.jsp");
		return SUCCESS;
	}
	
	
	//跳转到查看新闻资讯页面
	public String xinwenshow() {
		HttpServletRequest request = this.getRequest();
		Xinwen bean = xinwenDao.selectBean(" where id= "+ request.getParameter("id"));
		
		xinwenDao.updateBean(bean);
		
		request.setAttribute("title", "新闻详情");
		request.setAttribute("bean", bean);
		this.setUrl("xinwenshow.jsp");
		return SUCCESS;
	}
	
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	

	//用户注册操作
	public void register() throws IOException {
		HttpServletRequest request = this.getRequest();

		PrintWriter writer = this.getPrintWriter();

		String tel = request.getParameter("tel");
		String role = request.getParameter("role");
		String password = request.getParameter("password");
		String username = request.getParameter("username");
		String xingming = request.getParameter("xingming");


		User bean = userDao.selectBean(" where deletestatus=0 and username='"+ username + "' ");
		if (bean == null) {
			bean = new User();
			
			bean.setPassword(password);
			bean.setUsername(username);
			bean.setXingming(xingming);
			bean.setTel(tel);
			
			bean.setRole(Integer.parseInt(role));
			
			userDao.insertBean(bean);
			writer
					.print("<script language=javascript>alert('注册成功');window.location.href='.';</script>");
		} else {
			writer
					.print("<script language=javascript>alert('注册失败，该用户名已经存在');window.location.href='register.jsp';</script>");
		}

	}
	

	

	// 登录操作
	public String login() throws IOException {
		HttpServletRequest request = this.getRequest();

		PrintWriter writer = this.getPrintWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User bean = userDao.selectBean(" where username = '" + username+ "' and password= '" + password+ "' and deletestatus=0 and role!=0 ");

		if (bean != null) {
			
			if(bean.getRole()!=1){
				HttpSession session = request.getSession();
				session.setAttribute("qiantai", bean);

				writer
						.print("<script language=javascript>alert('登录成功');window.location.href='.';</script>");
			}else{
				
				HttpSession session = request.getSession();
				session.setAttribute("user", bean);
				this.setUrl("manage/index.jsp");
				return "redirect";
			}
			
			
		} else {
			writer
					.print("<script language=javascript>alert('用户名或者密码错误');window.location.href='.';</script>");
		}
		
		return null;

	}

	// 用户退出
	public void loginout() throws IOException {
		HttpServletRequest request =  this.getRequest();
		PrintWriter writer = this.getPrintWriter();	
		HttpSession session = request.getSession();
		session.removeAttribute("qiantai");
		writer.print("<script language=javascript>alert('退出成功');window.location.href='.';</script>");
	}
	
	
	// 跳转到修改个人信息页面
	public String userupdate() {
		HttpServletRequest request = this.getRequest();

		HttpSession session = request.getSession();
		User uu = (User)session.getAttribute("qiantai");
		
		User bean = userDao.selectBean(" where id= "+uu.getId());
		
		request.setAttribute("bean", bean);
		
		request.setAttribute("url", "indexmethod!userupdate2?id="+bean.getId());
		request.setAttribute("title", "个人信息");
		this.setUrl("userupdate.jsp");
		return SUCCESS;
	}

	// 个人信息操作
	public void userupdate2() throws IOException {
		HttpServletRequest request = this.getRequest();

		PrintWriter writer = this.getPrintWriter();

		String tel = request.getParameter("tel");
		
		User bean = userDao.selectBean(" where id= "+request.getParameter("id"));
		
		bean.setTel(tel);
		
		userDao.updateBean(bean);
		writer
				.print("<script language=javascript>alert('修改成功');window.location.href='indexmethod!userupdate';</script>");

	}
	
	
	
	// 跳转到修改修改密码页面
	public String userupdate3() {
		HttpServletRequest request = this.getRequest();
		request.setAttribute("url", "indexmethod!userupdate4");
		request.setAttribute("title", "修改密码");
		this.setUrl("userupdate3.jsp");
		return SUCCESS;
	}

	//修改密码操作
	public void userupdate4() throws IOException {
		HttpServletRequest request = this.getRequest();

		PrintWriter writer = this.getPrintWriter();
		
		HttpSession session = request.getSession();
		User uu = (User)session.getAttribute("qiantai");

		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
	

		User bean = userDao.selectBean(" where deletestatus=0 and username='"+uu.getUsername()+"'  and password='"+password1+"'");
		
		if(bean!=null){
			bean.setPassword(password2);
			userDao.updateBean(bean);
			writer
					.print("<script language=javascript>alert('修改成功');window.location.href='indexmethod!userupdate3';</script>");
		}else{
			writer
			.print("<script language=javascript>alert('修改失败，原密码错误');window.location.href='indexmethod!userupdate3';</script>");
		}
		
		

	}

	
	private HouseDao houseDao;




	public HouseDao getHouseDao() {
		return houseDao;
	}


	public void setHouseDao(HouseDao houseDao) {
		this.houseDao = houseDao;
	}
	
	
	
	private File uploadfile;

	
	public File getUploadfile() {
		return uploadfile;
	}




	public void setUploadfile(File uploadfile) {
		this.uploadfile = uploadfile;
	}

	
	private File uploadfile02; 
	
	private File uploadfile03;
	

	public File getUploadfile02() {
		return uploadfile02;
	}




	public void setUploadfile02(File uploadfile02) {
		this.uploadfile02 = uploadfile02;
	}




	public File getUploadfile03() {
		return uploadfile03;
	}




	public void setUploadfile03(File uploadfile03) {
		this.uploadfile03 = uploadfile03;
	}

	



	//跳转到发布房源页面
	public String houseadd() throws ParseException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		
		HttpSession session = request.getSession();
		User uu = (User)session.getAttribute("qiantai");
		if(uu==null){
			writer
			.print("<script language=javascript>alert('请先登录');window.location.href='.';</script>");
			return null ;
		}
		
		
		request.setAttribute("url", "indexmethod!houseadd2");
		request.setAttribute("title", "发布房源");
		this.setUrl("houseadd.jsp");
		return SUCCESS;
	}
	
	
	//发布房源操作
	public void houseadd2() throws IOException {
		HttpServletRequest request = this.getRequest();

		PrintWriter writer = this.getPrintWriter();

		String leixing = request.getParameter("leixing");
		String mingchen = request.getParameter("mingchen");
		String quyu = request.getParameter("quyu");
		String shouming = request.getParameter("shouming");
		String zhuangxiu = request.getParameter("zhuangxiu");
		String money = request.getParameter("money");
		String mianji = request.getParameter("mianji");
		
		HttpSession session = request.getSession();
		User uu = (User)session.getAttribute("qiantai");
		
		House bean = new House();
		
		String bianhao = Util.getbianhao(houseDao.selectBeanCount(" "));
		
		bean.setBianhao(bianhao);
		
		bean.setCtime(Util.getTime());
		
		bean.setLeixing(leixing);
		bean.setMingchen(mingchen);
		bean.setQuyu(quyu);
		bean.setShouming(shouming);
		bean.setStatus("审核中");
		bean.setUser(uu);
		bean.setZhuangxiu(zhuangxiu);
		bean.setMoney(Double.parseDouble(money));
		bean.setMianji(Double.parseDouble(mianji));
		
		if(uploadfile!=null){
			String savapath = ServletActionContext.getServletContext().getRealPath("/")+"/uploadfile/";
			String time = Util.getTime2();
			String imgpath = time+".jpg";
			File file = new File(savapath+imgpath);
			Util.copyFile(uploadfile, file);

			bean.setPath(imgpath);
		}
		
		if(uploadfile02!=null){
			String savapath = ServletActionContext.getServletContext().getRealPath("/")+"/uploadfile/";
			String time = Util.getTime2();
			String imgpath = time+"02.jpg";
			File file = new File(savapath+imgpath);
			Util.copyFile(uploadfile02, file);

			bean.setPath2(imgpath);
		}
		
		if(uploadfile03!=null){
			String savapath = ServletActionContext.getServletContext().getRealPath("/")+"/uploadfile/";
			String time = Util.getTime2();
			String imgpath = time+"03.jpg";
			File file = new File(savapath+imgpath);
			Util.copyFile(uploadfile03, file);

			bean.setPath3(imgpath);
		}
		
		
		houseDao.insertBean(bean);
		
		
		writer
		.print("<script language=javascript>alert('操作成功');window.location.href='indexmethod!houselist';</script>");

	}
	
	
	//我的发布房源列表
	public String houselist() throws Exception {

		HttpServletRequest request = this.getRequest();
		
		
		String mingchen = request.getParameter("mingchen");
		
		
		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");

		
		
		if (mingchen != null && !"".equals(mingchen)) {

			sb.append(" mingchen like '%" + mingchen + "%'");
			sb.append(" and ");
			request.setAttribute("mingchen", mingchen);
		}
		
		HttpSession session = request.getSession();
		User uu = (User)session.getAttribute("qiantai");
		
		sb.append("  deletestatus=0  and user.id="+uu.getId()+" order by id desc ");
	
		
		String where = sb.toString();


		int currentpage = 1;
		int pagesize = 15;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		
		int total = houseDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		
		request.setAttribute("list", houseDao.selectBeanList((currentpage - 1)* pagesize, pagesize, where));
		
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,currentpage, "indexmethod!houselist", "共有" + total + "条记录"));

		
		request.setAttribute("url", "indexmethod!houselist");
		request.setAttribute("title", "房源管理");
		this.setUrl("houselist.jsp");
		return SUCCESS;
	}
	
	
	//删除房源操作
	public void housedelete() throws IOException {
		HttpServletRequest request = this.getRequest();

		PrintWriter writer = this.getPrintWriter();
		
		
	

		House bean = houseDao.selectBean(" where id= "+request.getParameter("id"));
		
		bean.setDeletestatus(1);
		
		houseDao.updateBean(bean);
		

		
		
		writer.print("<script language=javascript>alert('操作成功');window.location.href='indexmethod!houselist';</script>");
		
		

	}
	
	
	//跳转到查看房源页面
	public String houseupdate3() throws ParseException {
		HttpServletRequest request = this.getRequest();
		
		
		House bean = houseDao.selectBean(" where id= "+request.getParameter("id"));
		
		request.setAttribute("bean", bean);
		
		
		request.setAttribute("title", "查看房源详情");
		this.setUrl("houseupdate3.jsp");
		return SUCCESS;
	}
	
	
	
	//跳转到修改房源信息页面
	public String houseupdate() throws ParseException {
		HttpServletRequest request = this.getRequest();
		
		House bean = houseDao.selectBean(" where id= "+request.getParameter("id"));
		
		
		request.setAttribute("bean", bean);
		
		
		request.setAttribute("url", "indexmethod!houseupdate2?id="+bean.getId());
		request.setAttribute("title", "修改房源信息");
		this.setUrl("houseupdate.jsp");
		return SUCCESS;
	}
	
	
	//修改房源操作
	public void houseupdate2() throws IOException {
		HttpServletRequest request = this.getRequest();

		PrintWriter writer = this.getPrintWriter();

		String leixing = request.getParameter("leixing");
		String mingchen = request.getParameter("mingchen");
		String quyu = request.getParameter("quyu");
		String shouming = request.getParameter("shouming");
		String zhuangxiu = request.getParameter("zhuangxiu");
		
		String money = request.getParameter("money");
		String mianji = request.getParameter("mianji");
		
		House bean = houseDao.selectBean(" where id= "+request.getParameter("id"));
		
		
		bean.setLeixing(leixing);
		bean.setMingchen(mingchen);
		bean.setQuyu(quyu);
		bean.setShouming(shouming);
		bean.setStatus("审核中");

		bean.setZhuangxiu(zhuangxiu);
		bean.setMoney(Double.parseDouble(money));
		bean.setMianji(Double.parseDouble(mianji));
		
		if(uploadfile!=null){
			String savapath = ServletActionContext.getServletContext().getRealPath("/")+"/uploadfile/";
			String time = Util.getTime2();
			String imgpath = time+".jpg";
			File file = new File(savapath+imgpath);
			Util.copyFile(uploadfile, file);

			bean.setPath(imgpath);
		}
		
		
		if(uploadfile02!=null){
			String savapath = ServletActionContext.getServletContext().getRealPath("/")+"/uploadfile/";
			String time = Util.getTime2();
			String imgpath = time+"02.jpg";
			File file = new File(savapath+imgpath);
			Util.copyFile(uploadfile02, file);

			bean.setPath2(imgpath);
		}
		
		if(uploadfile03!=null){
			String savapath = ServletActionContext.getServletContext().getRealPath("/")+"/uploadfile/";
			String time = Util.getTime2();
			String imgpath = time+"03.jpg";
			File file = new File(savapath+imgpath);
			Util.copyFile(uploadfile03, file);

			bean.setPath3(imgpath);
		}
		
		
		houseDao.updateBean(bean);
		
		
		writer
		.print("<script language=javascript>alert('操作成功');window.location.href='indexmethod!houselist';</script>");

	}
	
	
	//取消租赁操作
	public void housedelete2() throws IOException {
		HttpServletRequest request = this.getRequest();

		PrintWriter writer = this.getPrintWriter();
		
		
	

		House bean = houseDao.selectBean(" where id= "+request.getParameter("id"));
		
		bean.setStatus("已取消");
		
		houseDao.updateBean(bean);
		

		
		
		writer.print("<script language=javascript>alert('操作成功');window.location.href='indexmethod!houselist';</script>");
		
		

	}
	
	
	
	//跳转到查看房源页面
	public String houseshow() throws ParseException {
		HttpServletRequest request = this.getRequest();
		
		
		House bean = houseDao.selectBean(" where id= "+request.getParameter("id"));
		
		request.setAttribute("bean", bean);
		
		bean.setDianji(bean.getDianji()+1);
		
		houseDao.updateBean(bean);
		
		
		request.setAttribute("title", "查看房源详情");
		this.setUrl("houseshow.jsp");
		return SUCCESS;
	}
	
	
	
	//所有房源列表
	public String houselist2() throws Exception {

		HttpServletRequest request = this.getRequest();
		
		
		String mingchen = request.getParameter("mingchen");
		
		
		String money1 = request.getParameter("money1");
		String money2 = request.getParameter("money2");
		String mianji1 = request.getParameter("mianji1");
		String mianji2 = request.getParameter("mianji2");
		
		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");

		
		
		if (mingchen != null && !"".equals(mingchen)) {

			sb.append(" mingchen like '%" + mingchen + "%'");
			sb.append(" and ");
			request.setAttribute("mingchen", mingchen);
		}
		
		if (money1 != null && !"".equals(money1)) {

			sb.append(" money>=  " + money1 + " ");
			sb.append(" and ");
			request.setAttribute("money1", money1);
		}
		
		if (money2 != null && !"".equals(money2)) {

			sb.append(" money<=  " + money2 + " ");
			sb.append(" and ");
			request.setAttribute("money2", money2);
		}
		
		if (mianji1 != null && !"".equals(mianji1)) {

			sb.append(" mianji>=  " + mianji1 + " ");
			sb.append(" and ");
			request.setAttribute("mianji1", mianji1);
		}
		
		if (mianji2 != null && !"".equals(mianji2)) {

			sb.append(" mianji<=  " + mianji2 + " ");
			sb.append(" and ");
			request.setAttribute("mianji2", mianji2);
		}
		
		
		
		sb.append("  deletestatus=0  and status='租赁中' order by id desc ");
	
		
		String where = sb.toString();


		int currentpage = 1;
		int pagesize = 15;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		
		int total = houseDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		
		request.setAttribute("list", houseDao.selectBeanList((currentpage - 1)* pagesize, pagesize, where));
		
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,currentpage, "indexmethod!houselist2", "共有" + total + "条记录"));

		
		request.setAttribute("url", "indexmethod!houselist2");
		request.setAttribute("title", "所有房源");
		this.setUrl("houselist2.jsp");
		return SUCCESS;
	}
	
	
	
	private ZufangDao zufangDao;




	public ZufangDao getZufangDao() {
		return zufangDao;
	}




	public void setZufangDao(ZufangDao zufangDao) {
		this.zufangDao = zufangDao;
	}
	
	
	
	//跳转到预约租房页面
	public String zufangadd() throws ParseException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		
		HttpSession session = request.getSession();
		User uu = (User)session.getAttribute("qiantai");
		if(uu==null){
			writer
			.print("<script language=javascript>alert('请先登录');window.location.href='.';</script>");
			return null ;
		}
		
		if(uu.getRole()!=3){
			writer
			.print("<script language=javascript>alert('只有租赁者才能租房');window.location.href='.';</script>");
			return null ;
			
		}
		
		String houseid = request.getParameter("houseid");
		
		
		
		
		request.setAttribute("url", "indexmethod!zufangadd2?houseid="+houseid);
		request.setAttribute("title", "预约租房");
		this.setUrl("zufangadd.jsp");
		return SUCCESS;
	}
	
	
	//预约租房操作
	public void zufangadd2() throws IOException {
		HttpServletRequest request = this.getRequest();

		PrintWriter writer = this.getPrintWriter();

		String houseid = request.getParameter("houseid");
		String shouming = request.getParameter("shouming");
		String tel = request.getParameter("tel");
		String xingming = request.getParameter("xingming");
		
		HttpSession session = request.getSession();
		User uu = (User)session.getAttribute("qiantai");
		
		Zufang bean = zufangDao.selectBean(" where deletestatus=0 and user.id="+uu.getId()+" and house.id= "+houseid);
		
		if(bean!=null){
			writer
			.print("<script language=javascript>alert('操作失败，已有预约租房记录，不可重复添加');window.location.href='indexmethod!zufanglist';</script>");
			return;
		}
		
		bean = new Zufang();
		
		bean.setCtime(Util.getTime());
		bean.setHouse(houseDao.selectBean(" where id= "+houseid));
		bean.setShouming(shouming);
		bean.setStatus("预约中");
		bean.setTel(tel);
		bean.setUser(uu);
		bean.setXingming(xingming);
		
		
		zufangDao.insertBean(bean);
		
		
		writer
		.print("<script language=javascript>alert('操作成功');window.location.href='indexmethod!zufanglist';</script>");

	}
	
	
	//我的预约租房列表
	public String zufanglist() throws Exception {

		HttpServletRequest request = this.getRequest();
		
		
		String mingchen = request.getParameter("mingchen");
		
		
		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");

		
		
		if (mingchen != null && !"".equals(mingchen)) {

			sb.append(" house.mingchen like '%" + mingchen + "%'");
			sb.append(" and ");
			request.setAttribute("mingchen", mingchen);
		}
		
		HttpSession session = request.getSession();
		User uu = (User)session.getAttribute("qiantai");
		
		sb.append("  deletestatus=0  and user.id="+uu.getId()+" order by id desc ");
	
		
		String where = sb.toString();


		int currentpage = 1;
		int pagesize = 15;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		
		int total = zufangDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		
		request.setAttribute("list", zufangDao.selectBeanList((currentpage - 1)* pagesize, pagesize, where));
		
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,currentpage, "indexmethod!zufanglist", "共有" + total + "条记录"));

		
		request.setAttribute("url", "indexmethod!zufanglist");
		request.setAttribute("title", "我的预约租房");
		this.setUrl("zufanglist.jsp");
		return SUCCESS;
	}
	
	
	//删除操作
	public void zufangdelete() throws IOException {
		HttpServletRequest request = this.getRequest();

		PrintWriter writer = this.getPrintWriter();
		
		
	

		Zufang bean = zufangDao.selectBean(" where id= "+request.getParameter("id"));
		
		bean.setDeletestatus(1);
		
		zufangDao.updateBean(bean);
		

		
		
		writer.print("<script language=javascript>alert('操作成功');window.location.href='indexmethod!zufanglist';</script>");
		
		

	}
	
	
	//跳转到查看租赁详情页面
	public String zufangupdate3() throws ParseException {
		HttpServletRequest request = this.getRequest();
		
		
		Zufang bean = zufangDao.selectBean(" where id= "+request.getParameter("id"));
		
		request.setAttribute("bean", bean);
		
		
		request.setAttribute("title", "查看租赁详情");
		this.setUrl("zufangupdate3.jsp");
		return SUCCESS;
	}
	
	
	
	//租房管理
	public String zufanglist2() throws Exception {

		HttpServletRequest request = this.getRequest();
		
		
		String mingchen = request.getParameter("mingchen");
		
		
		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");

		
		
		if (mingchen != null && !"".equals(mingchen)) {

			sb.append(" house.mingchen like '%" + mingchen + "%'");
			sb.append(" and ");
			request.setAttribute("mingchen", mingchen);
		}
		
		HttpSession session = request.getSession();
		User uu = (User)session.getAttribute("qiantai");
		
		sb.append("  deletestatus=0  and house.user.id="+uu.getId()+" order by id desc ");
	
		
		String where = sb.toString();


		int currentpage = 1;
		int pagesize = 15;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		
		int total = zufangDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		
		request.setAttribute("list", zufangDao.selectBeanList((currentpage - 1)* pagesize, pagesize, where));
		
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,currentpage, "indexmethod!zufanglist2", "共有" + total + "条记录"));

		
		request.setAttribute("url", "indexmethod!zufanglist2");
		request.setAttribute("title", "租房管理");
		this.setUrl("zufanglist2.jsp");
		return SUCCESS;
	}
	
	
	//跳转到审核租房信息页面
	public String zufangupdate() throws ParseException {
		HttpServletRequest request = this.getRequest();
		
		Zufang bean = zufangDao.selectBean(" where id= "+request.getParameter("id"));
		
		
		request.setAttribute("bean", bean);
		
		
		request.setAttribute("url", "indexmethod!zufangupdate2?id="+bean.getId());
		request.setAttribute("title", "审核租房信息");
		this.setUrl("zufangupdate.jsp");
		return SUCCESS;
	}
	
	
	//审核租房操作
	public void zufangupdate2() throws IOException {
		HttpServletRequest request = this.getRequest();

		PrintWriter writer = this.getPrintWriter();

		String status = request.getParameter("status");
		
		Zufang bean = zufangDao.selectBean(" where id= "+request.getParameter("id"));
		
		
		bean.setStatus(status);
		
		
		zufangDao.updateBean(bean);
		
		if("已同意待支付".equals(status)){
			
			List<Zufang> zflist = zufangDao.selectBeanList(0, 99999, " where deletestatus=0 and id!="+bean.getId()+"  and status='预约中' ");
			
			
			for(Zufang zf:zflist){
				zf.setStatus("租房失败");
				
				zufangDao.updateBean(zf);
				
			}
			
			House house = houseDao.selectBean(" where id= "+bean.getHouse().getId());
			
			house.setStatus("租赁成功");
			
			houseDao.updateBean(house);
			
		}
		
		
		
		writer
		.print("<script language=javascript>alert('操作成功');window.location.href='indexmethod!zufanglist2';</script>");

	}
	
	
	
	//跳转到确认支付页面
	public String zufangupdate5() throws ParseException {
		HttpServletRequest request = this.getRequest();
		
		Zufang bean = zufangDao.selectBean(" where id= "+request.getParameter("id"));
		
		
		request.setAttribute("bean", bean);
		
		
		request.setAttribute("url", "indexmethod!zufangupdate6?id="+bean.getId());
		request.setAttribute("title", "确认支付");
		this.setUrl("zufangupdate5.jsp");
		return SUCCESS;
	}
	
	
	//确认支付操作
	public void zufangupdate6() throws IOException {
		HttpServletRequest request = this.getRequest();

		PrintWriter writer = this.getPrintWriter();

		
		Zufang bean = zufangDao.selectBean(" where id= "+request.getParameter("id"));
		
		bean.setStatus("租房成功");
		
		
		
		zufangDao.updateBean(bean);
		
		
		
		writer
		.print("<script language=javascript>alert('操作成功');window.location.href='indexmethod!zufanglist';</script>");

	}
	
	
	private TieziDao tieziDao;




	public TieziDao getTieziDao() {
		return tieziDao;
	}




	public void setTieziDao(TieziDao tieziDao) {
		this.tieziDao = tieziDao;
	}
	
	
	//跳转到发帖页面
	public String tieziadd() throws ParseException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		
		HttpSession session = request.getSession();
		User uu = (User)session.getAttribute("qiantai");
		if(uu==null){
			writer
			.print("<script language=javascript>alert('请先登录');window.location.href='.';</script>");
			return null ;
		}
		String houseid = request.getParameter("houseid");
		
		
		
		
		
		request.setAttribute("url", "indexmethod!tieziadd2?houseid="+houseid);
		request.setAttribute("title", "发帖");
		this.setUrl("tieziadd.jsp");
		return SUCCESS;
	}
	
	
	//发帖操作
	public void tieziadd2() throws IOException {
		HttpServletRequest request = this.getRequest();

		PrintWriter writer = this.getPrintWriter();

		String lcontent = request.getParameter("lcontent");
		String ltitle = request.getParameter("ltitle");
		String houseid = request.getParameter("houseid");
		
		HttpSession session = request.getSession();
		User uu = (User)session.getAttribute("qiantai");
		
		Tiezi bean = new Tiezi();
		
		bean.setHouse(houseDao.selectBean(" where id= "+houseid));
		
		bean.setCtime(Util.getRiqi());
		bean.setLcontent(lcontent);
		bean.setLtitle(ltitle);
		bean.setUser(uu);
		
		tieziDao.insertBean(bean);
		
		
		writer
		.print("<script language=javascript>alert('操作成功');window.location.href='indexmethod!tiezilist2';</script>");

	}
	
	
	//我的帖子板列表
	public String tiezilist() throws Exception {

		HttpServletRequest request = this.getRequest();
		
		
		String ltitle = request.getParameter("ltitle");
		
		
		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");

		
		
		if (ltitle != null && !"".equals(ltitle)) {

			sb.append(" ltitle like '%" + ltitle + "%'");
			sb.append(" and ");
			request.setAttribute("ltitle", ltitle);
		}
		
		HttpSession session = request.getSession();
		User uu = (User)session.getAttribute("qiantai");
		
		sb.append("  deletestatus=0  and user.id="+uu.getId()+" order by id desc ");
	
		
		String where = sb.toString();


		int currentpage = 1;
		int pagesize = 15;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		
		int total = tieziDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		
		request.setAttribute("tiezilist", tieziDao.selectBeanList((currentpage - 1)* pagesize, pagesize, where));
		
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,currentpage, "indexmethod!tiezilist", "共有" + total + "条记录"));

		
		
		request.setAttribute("url", "indexmethod!tiezilist");
		request.setAttribute("title", "我的帖子");
		this.setUrl("tiezilist.jsp");
		return SUCCESS;
	}
	
	
	//删除帖子操作
	public void tiezidelete() throws IOException {
		HttpServletRequest request = this.getRequest();

		PrintWriter writer = this.getPrintWriter();

		Tiezi bean = tieziDao.selectBean(" where id= "+request.getParameter("id"));
		
		bean.setDeletestatus(1);
		
		tieziDao.updateBean(bean);

		
		writer.print("<script language=javascript>alert('操作成功');window.location.href='indexmethod!tiezilist';</script>");
		
		

	}
	
	
	//跳转到查看帖子详情页面
	public String tieziupdate3() throws ParseException {
		HttpServletRequest request = this.getRequest();
		
		Tiezi bean = tieziDao.selectBean(" where id= "+request.getParameter("id"));
		
		request.setAttribute("bean", bean);
		
		
		List<Huifu> huifulist = huifuDao.selectBeanList(0, 9999, " where deletestatus=0 and tiezi.id= "+bean.getId());
		
		request.setAttribute("huifulist", huifulist);
		
		request.setAttribute("title", "帖子详情");
		this.setUrl("tieziupdate3.jsp");
		return SUCCESS;
	}
	
	
	//交流区
	public String tiezilist2() throws Exception {

		HttpServletRequest request = this.getRequest();
		
		
		String ltitle = request.getParameter("ltitle");
		
		
		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");

		
		
		if (ltitle != null && !"".equals(ltitle)) {

			sb.append(" ltitle like '%" + ltitle + "%'");
			sb.append(" and ");
			request.setAttribute("ltitle", ltitle);
		}
		
	
		
		sb.append("  deletestatus=0  order by id desc ");
	
		
		String where = sb.toString();


		int currentpage = 1;
		int pagesize = 15;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		
		int total = tieziDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		
		request.setAttribute("tiezilist", tieziDao.selectBeanList((currentpage - 1)* pagesize, pagesize, where));
		
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,currentpage, "indexmethod!tiezilist2", "共有" + total + "条记录"));

	
		
		request.setAttribute("url", "indexmethod!tiezilist2");
		request.setAttribute("title", "交流区");
		this.setUrl("tiezilist2.jsp");
		return SUCCESS;
	}
	
	
	private HuifuDao huifuDao;




	public HuifuDao getHuifuDao() {
		return huifuDao;
	}




	public void setHuifuDao(HuifuDao huifuDao) {
		this.huifuDao = huifuDao;
	}
	
	
	//回复操作
	public void huifuadd2() throws IOException {
		HttpServletRequest request = this.getRequest();

		PrintWriter writer = this.getPrintWriter();

		String hcontent = request.getParameter("hcontent");
		
		String tieziid = request.getParameter("tieziid");
		
		HttpSession session = request.getSession();
		User uu = (User)session.getAttribute("qiantai");
		
		Huifu bean = new Huifu();
		
		bean.setCtime(Util.getShijian());
		bean.setHcontent(hcontent);

		bean.setUser(uu);
		bean.setTiezi(tieziDao.selectBean(" where id= "+tieziid));
		
		
		huifuDao.insertBean(bean);
		
		
		writer
		.print("<script language=javascript>alert('操作成功');window.location.href='indexmethod!tieziupdate3?id="+bean.getTiezi().getId()+"';</script>");

	}
	
	
	//房源帖子列表
	public String tiezilist3() throws Exception {

		HttpServletRequest request = this.getRequest();
		
		
		String ltitle = request.getParameter("ltitle");
		
		String houseid = request.getParameter("houseid");
		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");

		
		
		if (ltitle != null && !"".equals(ltitle)) {

			sb.append(" ltitle like '%" + ltitle + "%'");
			sb.append(" and ");
			request.setAttribute("ltitle", ltitle);
		}
		
		
		
		sb.append("  deletestatus=0  and house.id="+houseid+" order by id desc ");
	
		
		String where = sb.toString();


		int currentpage = 1;
		int pagesize = 15;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		
		int total = tieziDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		
		request.setAttribute("tiezilist", tieziDao.selectBeanList((currentpage - 1)* pagesize, pagesize, where));
		
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,currentpage, "indexmethod!tiezilist3?houseid="+houseid, "共有" + total + "条记录"));

		
		
		request.setAttribute("url", "indexmethod!tiezilist3?houseid="+houseid);
		request.setAttribute("title", "房源帖子");
		this.setUrl("tiezilist3.jsp");
		return SUCCESS;
	}
	
}
