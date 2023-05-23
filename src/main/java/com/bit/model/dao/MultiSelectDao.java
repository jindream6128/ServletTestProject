package com.bit.model.dao;


import com.bit.vo.BoardVO;
import com.bit.vo.SignUpVO;

import java.util.HashMap;
import java.util.List;

public interface MultiSelectDao {
    public void insertsignup(SignUpVO vo);
    public String getPass(String id);
    public String getName(String id);
    public void insertBoard(BoardVO vo);
    public List<BoardVO> selectAll(HashMap<String, Object> map);
    public int totalCount(HashMap<String, Object> map); //페이징을 위해서 전체를 전체 갯수 세기
    public void hitcnt(int no);
    public BoardVO selectinfo(int no);

}
