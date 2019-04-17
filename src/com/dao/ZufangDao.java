package com.dao;

import java.util.List;

import com.model.Zufang;






public interface ZufangDao  {
	
	
	
	public void insertBean(Zufang bean);
	
	public void deleteBean(Zufang bean);
	
	public void updateBean(Zufang bean);

	public Zufang selectBean(String where);
	
	public List<Zufang> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
	
	
}
