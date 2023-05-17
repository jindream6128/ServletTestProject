package com.bit.conf;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class SqlSessionManager {
	public static SqlSessionFactory sqlSessionFactory;
	static {

		String resource="xml 경로";
		Reader reader=null;

		try {
			reader=Resources.getResourceAsReader(resource);			
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}//staticBlock
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}	

}






