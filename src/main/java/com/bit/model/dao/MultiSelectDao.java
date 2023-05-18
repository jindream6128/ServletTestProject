package com.bit.model.dao;


import com.bit.vo.SignUpVO;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public interface MultiSelectDao {
    public void insertsignup(SignUpVO vo);
    public String getPass(String id);
}
