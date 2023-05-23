package com.bit.controller;

import com.bit.model.service.MultiSelectServiceImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InfoController implements ProcessController {
    private String path;
    private boolean redirect;

    public InfoController(String path, boolean redirect) {
        super();
        this.path = path;
        this.redirect = redirect;
    }

    @Override
    public ForWardController execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int no = Integer.parseInt(request.getParameter("no"));
        String job = request.getParameter("job");

        request.setAttribute("info", MultiSelectServiceImp.getMultiSelectService().selectinfo(no));
        redirect = false;

        if(request.getParameter("job").equals("modify")){
            path = "views/modify.jsp?no="+no+"&job="+job;
        }
        if(request.getParameter("job").equals("info")){
            path = "views/info.jsp?no="+no+"&job="+job;
        }
        return new ForWardController(path,redirect);
    }
}
