package com.bit.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListSelectController implements ProcessController{
    private String path;
    private boolean redirect;
    private PagingComponent pagingComponent = new PagingComponent();

    public ListSelectController(String path, boolean redirect) {
        super();
        this.path = path;
        this.redirect = redirect;
    }

    @Override
    public ForWardController execute(HttpServletRequest request, HttpServletResponse response){

        pagingComponent.pagingCreate(request);
        return new ForWardController(path,redirect);
    }
}
