package com.bit.controller;

import com.bit.model.service.MultiSelectServiceImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PasswordController implements ProcessController{
    private String path;
    private boolean redirect;

    public PasswordController(String path, boolean redirect) {
        super();
        this.path = path;
        this.redirect = redirect;
    }

    @Override
    public ForWardController execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String job = request.getParameter("job");
        int no = Integer.parseInt(request.getParameter("no"));
        String pass = request.getParameter("pass");

        String dbPass = MultiSelectServiceImp.getMultiSelectService().getboardPass(no);
        redirect = false;

        if(dbPass.equals(pass)){
            if(job.equals("del")){
                path = "delete.do?cmd=delete&job="+job+"&no="+no;
            }
            if(job.equals("modify")){
                path = "modify.do?cmd=info&job="+job+"&no="+no;
            }
        }else{
            path = "views/Password.jsp?job="+job+"&no="+no;
        }


        return new ForWardController(path,redirect);
    }
}
