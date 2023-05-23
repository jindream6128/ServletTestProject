package com.bit.model.service;

import com.bit.model.dao.MultiSelectDaoImp;
import com.bit.vo.BoardVO;
import com.bit.vo.SignUpVO;


import java.util.HashMap;
import java.util.List;

public class MultiSelectServiceImp implements MultiSelectService{

	private static MultiSelectService multiSelectService=new MultiSelectServiceImp();

	public static MultiSelectService getMultiSelectService(){
		return multiSelectService;
	}
	@Override
	public void insertsignup(SignUpVO vo) {
		MultiSelectDaoImp.getMultiSelectDao().insertsignup(vo);
	}

	@Override
	public String getPass(String id) {
		return MultiSelectDaoImp.getMultiSelectDao().getPass(id);
	}

	@Override
	public String getName(String id) {
		return MultiSelectDaoImp.getMultiSelectDao().getName(id);
	}

	@Override
	public void insertBoard(BoardVO vo) {
		MultiSelectDaoImp.getMultiSelectDao().insertBoard(vo);
	}

	public List<BoardVO> selectAll(HashMap<String, Object> map){
		return MultiSelectDaoImp.getMultiSelectDao().selectAll(map);
	}

	public int totalCount(HashMap<String, Object> map){
		return MultiSelectDaoImp.getMultiSelectDao().totalCount(map);
	}

	@Override
	public void hitcnt(int no) {
			MultiSelectDaoImp.getMultiSelectDao().hitcnt(no);
	}

	public BoardVO selectinfo(int no){
		return MultiSelectDaoImp.getMultiSelectDao().selectinfo(no);
	}


}



