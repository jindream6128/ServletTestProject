package com.bit.controller;

import com.bit.model.service.MultiSelectServiceImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ScrapController implements ProcessController{
    private String path;
    private boolean redirect;

    public ScrapController(String path, boolean redirect) {
        super();
        this.path = path;
        this.redirect = redirect;
    }

    @Override
    public ForWardController execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String no = request.getParameter("no");

       /* System.out.println("id: " + id);
        System.out.println("no: "+no);*/

        HashMap<String,String> map = new HashMap<>();
        map.put("id", id);
        map.put("no",no);

        String str = MultiSelectServiceImp.getMultiSelectService().selectScrap(map);

        //null이란소린 없다
        if(str == null){
            //스크랩 테이블에 넣어주기
            MultiSelectServiceImp.getMultiSelectService().insertScrap(map);
            MultiSelectServiceImp.getMultiSelectService().updateScarpCnt(Integer.parseInt(no));
            request.setAttribute("state","add");
        }else{
            //null이 아니라는 소리 -> DB에 존재한다! 빼야함!
            MultiSelectServiceImp.getMultiSelectService().deleteScrap(map);
            MultiSelectServiceImp.getMultiSelectService().deleteScrapCnt(Integer.parseInt(no));
            request.setAttribute("state","delete");
        }

        path = "views/Scrap.jsp";
        redirect=false;
        return new ForWardController(path, redirect);
    }


}
