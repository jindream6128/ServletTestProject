package com.bit.controller;

import com.bit.model.dao.MultiSelectDaoImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MypageController implements ProcessController{
    private String path;
    private boolean redirect;

    public MypageController(String path, boolean redirect) {
        super();
        this.path = path;
        this.redirect = redirect;
    }

    @Override
    public ForWardController execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id= request.getParameter("id");
        //System.out.println(MultiSelectDaoImp.getMultiSelectDao().selectMyboard(id));
        request.setAttribute("page", MultiSelectDaoImp.getMultiSelectDao().selectMyboard(id));

        return new ForWardController(path,redirect);
    }
}
