package com.bit.model.dao;


import com.bit.vo.BoardVO;
import com.bit.vo.SignUpVO;

import java.util.HashMap;
import java.util.List;

public interface MultiSelectDao {
    //회원가입
    public void insertsignup(SignUpVO vo);
    //DB비밀번호 가지고오기
    public String getPass(String id);
    //id로 nickname가지고오기
    public String getName(String id);
    //게시글 삽입
    public void insertBoard(BoardVO vo);
    //전체 리스트뿌리기
    public List<BoardVO> selectAll(HashMap<String, Object> map);
    //페이징을 위해서 전체를 전체 갯수 세기
    public int totalCount(HashMap<String, Object> map);
    //조회수 올리기
    public void hitcnt(int no);
    //info로 뿌리기위해 게시글 번호로 전부 가져오기
    public BoardVO selectinfo(int no);
    //no에 대한 passowrd 받아오기 / id에대한 password아님
    public String getboardPass(int no);
    //no받고 해당 번호 게시글 삭제하기
    public void deleteBoardone(int no);

    //modify 해당 번호에 게시글을 update하기
    public void modifyBoard(BoardVO vo);

}
