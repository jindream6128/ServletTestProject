package com.bit.model.dao;

import com.bit.conf.SqlSessionManager;
import com.bit.vo.BoardVO;
import com.bit.vo.SignUpVO;
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

	@Override
	public void insertsignup(SignUpVO vo) {
		//com.bit.vo.insertsignup, vo
		SqlSession sqlSession = sessionFactory.openSession();

		try{
			sqlSession.insert("com.bit.vo.insertsignup",vo);
			sqlSession.commit();
		}catch (Exception e){
			e.printStackTrace();
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
	}

	@Override
	public String getPass(String id) {
		SqlSession sqlSession = sessionFactory.openSession();
		String dbpass = null;
		try{
			dbpass = sqlSession.selectOne("com.bit.vo.getPass",id);
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return dbpass;
	}

	@Override
	public String getName(String id) {
		SqlSession sqlSession = sessionFactory.openSession();
		String name=null;
		try {
			name = sqlSession.selectOne("com.bit.vo.getName",id);
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return name;
	}

	@Override
	public void insertBoard(BoardVO vo) {
		SqlSession sqlSession = sessionFactory.openSession();

		try{
			sqlSession.insert("com.bit.vo.insertBoard", vo);
			sqlSession.commit();
		}catch (Exception e){
			e.printStackTrace();
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
	}
}


