package com.bit.controller;

import com.bit.model.service.MultiSelectServiceImp;
import com.bit.vo.BoardVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class ModifyController implements ProcessController{
    private String path;
    private boolean redirect;

    public ModifyController(String path, boolean redirect) {
        super();
        this.path = path;
        this.redirect = redirect;
    }

    @Override
    public ForWardController execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uploadPath = "/Users/kimjingeun/IdeaProjects/ServletTestProject/src/main/webapp/upload";
        int size = 10*1024*1024; //mb
        try{
            MultipartRequest multi = new MultipartRequest(request,
                    uploadPath,
                    size,
                    "UTF-8",
                    new DefaultFileRenamePolicy());

            Enumeration e = multi.getFileNames();
            String file = (String)e.nextElement();
            int no = Integer.parseInt(request.getParameter("no"));
            System.out.println("no이다!!!"+no);


            String nickname = multi.getParameter("nick");
            String category = multi.getParameter("categorybox");
            String pass = multi.getParameter("brdpass");
            String title = multi.getParameter("brdtitle");
            String content = multi.getParameter("brdcontent");
            int hit = Integer.parseInt(multi.getParameter("hitcnt"));
            String filename = multi.getOriginalFileName(file);

            BoardVO vo = new BoardVO(no,title,category,nickname,pass,content,filename,hit);
            System.out.println(vo);
            // MultiSelectServiceImp.getMultiSelectService().insertBoard(vo);

//            System.out.println("fileFileName: " + fileFileName); 서버에 실제 업로드 된 이름
//            System.out.println("originFileName: " + originFileName); 클라이언트가 업로드한 이름

            //이거만 no번호에서 바꾸기
            MultiSelectServiceImp.getMultiSelectService().modifyBoard(vo);

        }catch (Exception e){
            e.printStackTrace();
        }

        return new ForWardController(path,redirect);
    }
}
