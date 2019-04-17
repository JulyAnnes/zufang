package com.dao;

import java.util.List;

import com.model.House;






public interface HouseDao  {
	
	
	
	public void insertBean(House bean);
	
	public void deleteBean(House bean);
	
	public void updateBean(House bean);

	public House selectBean(String where);
	
	public List<House> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
	
	
}
