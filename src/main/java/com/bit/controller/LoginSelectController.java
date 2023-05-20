package com.bit.controller;

import com.bit.model.service.MultiSelectServiceImp;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginSelectController implements ProcessController{
    private String path;
    private boolean redirect;

    public LoginSelectController(String path, boolean redirect) {
        super();
        this.path = path;
        this.redirect = redirect;
    }

    @Override
    public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String pass = request.getParameter("pass");

        String dbPass = MultiSelectServiceImp.getMultiSelectService().getPass(id);
        String nickName = MultiSelectServiceImp.getMultiSelectService().getName(id);

        //System.out.println("id: " + id+ "pass: "+ pass + "dbPass" + dbPass + "nickName: " +nickName);

        if(dbPass!=null && pass.equals(dbPass)){
            //request.getSession().setAttribute("id",id);
            request.getSession().setAttribute("nickName",nickName);
            request.getSession().setMaxInactiveInterval(60*10);
            request.setAttribute("loginState","true");
        }else{
            request.setAttribute("loginState","false");
        }

        path = "views/LoginChk.jsp";
        redirect = false;

        return new ForWardController(path,redirect);
    }
}
