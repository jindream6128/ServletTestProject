package com.bit.controller;

import com.bit.model.service.MultiSelectServiceImp;
import com.bit.vo.BoardVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

public class InsertBoardController implements ProcessController{
    private String path;
    private boolean redirect;

    public InsertBoardController(String path, boolean redirect) {
        super();
        this.path = path;
        this.redirect = redirect;
    }



    @Override
    public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("InsertController");
        String uploadPath = "/Users/kimjingeun/IdeaProjects/ServletTestProject/src/main/webapp/upload";
        int size = 10*1024*1024; //mb

        try {
            MultipartRequest multi = new MultipartRequest(request,
                    uploadPath,
                    size,
                    "UTF-8",
                    new DefaultFileRenamePolicy());


            Enumeration e = multi.getFileNames();
            String file = (String)e.nextElement();

            String nickname = multi.getParameter("nick");
            String category = multi.getParameter("categorybox");
            String pass = multi.getParameter("brdpass");
            String title = multi.getParameter("brdtitle");
            String content = multi.getParameter("brdcontent");
            String filename = multi.getOriginalFileName(file);

           BoardVO vo = new BoardVO(nickname,category,pass,title,content,filename);

           /* MultiSelectServiceImp.getMultiSelectService().insertBoard(vo);*/

//            System.out.println("fileFileName: " + fileFileName); 서버에 실제 업로드 된 이름
//            System.out.println("originFileName: " + originFileName); 클라이언트가 업로드한 이름
            MultiSelectServiceImp.getMultiSelectService().insertBoard(vo);

        }catch (Exception e){

        }

        return new ForWardController(path,redirect);
    }
}
