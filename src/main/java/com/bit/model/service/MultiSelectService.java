package com.bit.model.service;



import com.bit.vo.BoardVO;
import com.bit.vo.SignUpVO;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Objects;

public interface MultiSelectService {
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


    //id랑 no로 action 가져오기
    public String getAction(HashMap<String,Object> map);

    //GNB table에 넣기
    public void insertGNB(HashMap<String,Object> map);

    //좋아요 싫어요 수
    public void updateEmotioncnt(HashMap<String,Object>map);

    //GNB테이블 변경 -> Good인데 누르면 -> Good떨구고 bad 늘리기
    public void updateEmotionAction(HashMap<String,Object> map);
    //최초의 조회수 올릴때
    public void updateFirstEmotionCnt(HashMap<String,Object>map);

    //스크랩 테이블에 id랑 no넣기
    public void insertScrap(HashMap<String,String> map);

    //id랑 no로 테이블 찾기
    public String selectScrap(HashMap<String,String> map);
    //no로 게시글 scrap횟수 늘리기
    public void updateScarpCnt(int no);

    //db에 해단 글을 스크랩했을때 삭제하기
    public void deleteScrap(HashMap<String,String> map);

    //cnt줄이기
    public void deleteScrapCnt(int no);

    //Scrap한 글 땡겨오기
    public List<BoardVO> selectMyboard(String id);
}
