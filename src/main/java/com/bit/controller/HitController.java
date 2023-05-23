package com.bit.controller;

import com.bit.model.service.MultiSelectServiceImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class HitController implements ProcessController{
    private String path;
    private boolean redirect;

    public HitController(String path, boolean redirect) {
        super();
        this.path = path;
        this.redirect = redirect;
    }

    @Override
    public ForWardController execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String job = request.getParameter("job"); //info
        int no = Integer.parseInt(request.getParameter("no")); //게시글 번호

        MultiSelectServiceImp.getMultiSelectService().hitcnt(no);

        path = "info.do?cmd=info&no="+no+"&job="+job;
        redirect= true;
        return new ForWardController(path,redirect);
    }
}
