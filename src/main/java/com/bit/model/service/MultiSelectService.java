package com.bit.model.service;



import com.bit.vo.SignUpVO;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public interface MultiSelectService {
    public void insertsignup(SignUpVO vo); //회원가입
    public String getPass(String id); //id 중복확인 chk , logintl pass확인

}
