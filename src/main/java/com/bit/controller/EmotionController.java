package com.bit.controller;

import com.bit.model.dao.MultiSelectDaoImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class EmotionController implements ProcessController{
    private String path;
    private boolean redirect;

    public EmotionController(String path, boolean redirect) {
        super();
        this.path = path;
        this.redirect = redirect;
    }

    @Override
    public ForWardController execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String no = request.getParameter("no");
        String action = request.getParameter("action");
        HashMap<String,Object> map = new HashMap<>();

        map.put("id",id);
        map.put("no",no);
        map.put("action",action);

        //현재 db의 상태
        String curState = MultiSelectDaoImp.getMultiSelectDao().getAction(map);
        //만약에 null이면 해당하는 값 디비에 넣고 좋아요 수 늘리기
        if(curState==null){
            //null이면 그냥 인설트하기
            MultiSelectDaoImp.getMultiSelectDao().insertGNB(map);
            MultiSelectDaoImp.getMultiSelectDao().updateFirstEmotionCnt(map);
            request.setAttribute("Emotion","true");
        }else{
            //일단 db뭔가 있는걸 받아오자
            //만약 db랑 전달한 action이 같아
            if(curState.equals(action)){
                request.setAttribute("Emotion","false");
            }else{
                //db에꺼랑 달라
                MultiSelectDaoImp.getMultiSelectDao().updateEmotionAction(map);
                MultiSelectDaoImp.getMultiSelectDao().updateEmotioncnt(map);
                request.setAttribute("Emotion","true");
            }
        }

        path="views/Emotion.jsp";
        redirect=false;
        return new ForWardController(path,redirect);
    }
}
