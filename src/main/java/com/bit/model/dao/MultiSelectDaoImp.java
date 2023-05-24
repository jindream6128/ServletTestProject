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

	@Override
	public String getboardPass(int no) {
		SqlSession sqlSession = sessionFactory.openSession();
		String dbBoardPass = null;
		try{
			dbBoardPass = sqlSession.selectOne("com.bit.vo.getboardPass", no);
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return dbBoardPass;
	}

	@Override
	public void deleteBoardone(int no) {
		SqlSession sqlSession = sessionFactory.openSession();
		try {
			sqlSession.delete("com.bit.vo.deleteBoardone",no);
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}

	@Override
	public void modifyBoard(BoardVO vo) {
		SqlSession sqlSession = sessionFactory.openSession();
		try {
			sqlSession.update("com.bit.vo.modifyBoard",vo);
			sqlSession.commit();
		}catch (Exception e){
			e.printStackTrace();
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
	}

	@Override
	public String getAction(HashMap<String, Object> map) {
		SqlSession sqlSession = sessionFactory.openSession();
		String Action = null;
		try {
			Action = sqlSession.selectOne("com.bit.vo.getAction",map).toString();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return Action;
	}

	@Override
	public void insertGNB(HashMap<String, Object> map) {
		SqlSession sqlSession = sessionFactory.openSession();
		try{
			sqlSession.insert("com.bit.vo.insertGNB", map);
			sqlSession.commit();
		}catch (Exception e){
			e.printStackTrace();
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
	}

	@Override
	public void updateEmotioncnt(HashMap<String, Object> map) {
		SqlSession sqlSession = sessionFactory.openSession();
		try {
			sqlSession.update("com.bit.vo.updateEmotioncnt",map);
			sqlSession.commit();
		}catch (Exception e){
			e.printStackTrace();
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
	}

	@Override
	public void updateFirstEmotionCnt(HashMap<String, Object> map) {
		SqlSession sqlSession = sessionFactory.openSession();
		try {
			sqlSession.update("com.bit.vo.updateFirstEmotionCnt",map);
			sqlSession.commit();
		}catch (Exception e){
			e.printStackTrace();
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
	}

	@Override
	public void updateEmotionAction(HashMap<String, Object> map) {
		SqlSession sqlSession = sessionFactory.openSession();
		try {
			sqlSession.update("com.bit.vo.updateEmotionAction",map);
			sqlSession.commit();
		}catch (Exception e){
			e.printStackTrace();
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
	}

}


