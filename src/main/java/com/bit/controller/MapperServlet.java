package com.bit.controller;

public class MapperServlet {
	
	public static ProcessController getMapper(String cmd) {
		ProcessController processController=null;

		if(cmd.equalsIgnoreCase("multi")) {

		   processController=new MultiSelectController("/dbBase/multiView2.jsp", false);
		}

		
		
		return processController; 
	}

}
