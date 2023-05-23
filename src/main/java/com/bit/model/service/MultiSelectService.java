package com.bit.model.service;



import com.bit.vo.BoardVO;
import com.bit.vo.SignUpVO;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Objects;

public interface MultiSelectService {
    public void insertsignup(SignUpVO vo); //회원가입
    public String getPass(String id); //id 중복확인 chk , login시 pass확인
    public String getName(String id); //닉네임 가져오기
    public void insertBoard(BoardVO vo); //게시글 넣기
    public List<BoardVO> selectAll(HashMap<String, Object> map);//게시글 가져오기

    public int totalCount(HashMap<String, Object> map); //페이징을 위해서 전체를 전체 갯수 세기

    public void hitcnt(int no);
    public BoardVO selectinfo(int no);
}
