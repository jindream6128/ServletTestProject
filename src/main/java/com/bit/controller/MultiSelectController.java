package com.bit.controller;

import com.bit.model.service.MultiSelectServiceImp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Hashtable;

public class MultiSelectController implements ProcessController {
	private String path;
	private boolean redirect;
	
	
	public MultiSelectController(String path, boolean redirect) {
		super();
		this.path = path;
		this.redirect = redirect;
	}

	@Override
	public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}
}
