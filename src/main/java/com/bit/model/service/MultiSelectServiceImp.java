package com.bit.model.service;

import com.bit.model.dao.MultiSelectDaoImp;
import com.bit.vo.SignUpVO;


import java.util.HashMap;
import java.util.Hashtable;
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
}

