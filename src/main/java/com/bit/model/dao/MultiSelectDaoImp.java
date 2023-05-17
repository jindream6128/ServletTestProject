package com.bit.model.dao;

import com.bit.conf.SqlSessionManager;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class MultiSelectDaoImp implements MultiSelectDao{

	private static MultiSelectDao multiSelectDao=new MultiSelectDaoImp();
	private SqlSessionFactory sessionFactory=SqlSessionManager.getSqlSessionFactory();
	public static MultiSelectDao getMultiSelectDao() {
		return multiSelectDao;
	}


}


