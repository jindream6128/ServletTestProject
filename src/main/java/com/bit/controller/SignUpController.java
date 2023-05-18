package com.bit.controller;

import com.bit.model.service.MultiSelectServiceImp;
import com.bit.vo.SignUpVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUpController implements ProcessController{
    private String path;
    private boolean redirect;

    public SignUpController(String path, boolean redirect) {
        super();
        this.path = path;
        this.redirect = redirect;
    }

    @Override
    public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String pass = request.getParameter("pass");
        String name = request.getParameter("name");

        String dbPass = MultiSelectServiceImp.getMultiSelectService().getPass(id);

        System.out.println("dpPass: "+dbPass);
        System.out.println(id + " " + pass + " " + name);
        System.out.println("---------------------");

        if(dbPass != null){
            System.out.println("exist");
            request.setAttribute("state", "exist"); //아이디가 존재할때
        }else{
            System.out.println("empty");
            request.setAttribute("state","empty");// 아이디가 없을때
            SignUpVO vo = new SignUpVO(id,pass,name);
            MultiSelectServiceImp.getMultiSelectService().insertsignup(vo);
        }

        path = "views/Manufacture_signup.jsp";
        redirect = false;


        return new ForWardController(path,redirect);
    }
}
