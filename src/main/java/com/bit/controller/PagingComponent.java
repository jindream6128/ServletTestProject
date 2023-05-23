package com.bit.controller;

import com.bit.model.service.MultiSelectServiceImp;
import com.bit.vo.PageBean;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class PagingComponent {

    public void pagingCreate(HttpServletRequest request){
        HashMap<String, Object>map=new HashMap<String, Object>();
        String query=request.getParameter("query");
        String data=request.getParameter("data");

        if(query!=null && data!=null) {
            map.put("query", query);
            map.put("data", data);
        }

        int pageScale=5;//보여줄 row or block count
        int currentPage=1;
        int totalRow=MultiSelectServiceImp.getMultiSelectService().totalCount(map) ;//dao호출 (총 tuple 갯수 )
        int totalPage=totalRow%pageScale==0?(totalRow/pageScale):(totalRow/pageScale)+1;
        totalPage=totalPage==0?1:totalPage;

        try {
            if(request.getParameter("page") != null) currentPage=Integer.parseInt(request.getParameter("page"));//현재 페이지
        } catch (Exception e) {
            // TODO: handle exception
        }
        // 현재 페이지를 알면 start end값을 알수있다 !

        int start=1+(currentPage-1)*pageScale;
        int end=pageScale+(currentPage-1)*pageScale;
        //System.out.println("start="+start+" end="+end);


        int currentBlock=currentPage%pageScale==0?(currentPage/pageScale):(currentPage/pageScale)+1;
        int startPage=1+(currentBlock-1)*pageScale;
        //int endPage=(pageScale+(currentBlock-1)*pageScale)>totalPage?totalPage:(pageScale+(currentBlock-1)*pageScale);
        int endPage=(pageScale+(currentBlock-1)*pageScale);
        if(endPage>totalPage)endPage=totalPage;
        //System.out.println("startPage= "+ startPage + " EndPage"+endPage);
        request.setAttribute("pageBean", new PageBean(currentBlock, currentPage, totalPage, startPage, endPage));

        map.put("start",start);
        map.put("end",end);

        request.setAttribute("list", MultiSelectServiceImp.getMultiSelectService().selectAll(map));

    }


}
