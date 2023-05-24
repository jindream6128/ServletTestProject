package com.bit.controller;

import com.bit.model.service.MultiSelectServiceImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteController implements ProcessController{
    private String path;
    private boolean redirect;

    public DeleteController(String path, boolean redirect) {
        super();
        this.path = path;
        this.redirect = redirect;
    }

    @Override
    public ForWardController execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int no = Integer.parseInt(request.getParameter("no"));

        MultiSelectServiceImp.getMultiSelectService().deleteBoardone(no);

        return new ForWardController(path,redirect);
    }
}
