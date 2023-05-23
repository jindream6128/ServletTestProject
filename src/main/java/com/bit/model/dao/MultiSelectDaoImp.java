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

	public List<BoardVO> selectAll(HashMap<String, Object> map){
		SqlSession sqlSession = sessionFactory.openSession();
		List<BoardVO> list =null;
		try{
			list = sqlSession.selectList("com.bit.vo.selectAll", map);
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			return list;
		}
	}

	@Override
	public int totalCount(HashMap<String, Object> map) {
		SqlSession sqlSession = sessionFactory.openSession();
		int cnt=0;
		try{
			cnt = sqlSession.selectOne("com.bit.vo.totalCount",map);
			sqlSession.commit();
		}catch (Exception e){
			e.printStackTrace();
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
		return cnt;
	}

	@Override
	public void hitcnt(int no) {
			SqlSession sqlSession = sessionFactory.openSession();
		try {
			sqlSession.update("com.bit.vo.Hitcnt",no);
			sqlSession.commit();
		}catch (Exception e){
			e.printStackTrace();
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
	}

	@Override
	public BoardVO selectinfo(int no) {
		SqlSession sqlSession = sessionFactory.openSession();
		BoardVO boardVO = null;
		try {
			boardVO = sqlSession.selectOne("com.bit.vo.selectinfo",no);
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return boardVO;
	}
}


