package com.bit.controller;


public class MapperServlet {
	
	public static ProcessController getMapper(String cmd) {
		ProcessController processController=null;

		switch (cmd){
			case "signup":
				//System.out.println("signup");
				//path-> 이동할 경로 -> 회원가입성공하면 loginselect 실패하면 다시 sign up 으로
				processController = new SignUpController("",false);
				break;
			case "login":
				System.out.println("loginselect");
				processController = new LoginSelectController("",false);
				break;
			case "listSelect":
				System.out.println("listSelect");
				processController = new ListSelectController("views/board.jsp",false);
				break;
			case "insertboard":
				System.out.println("insertboard");
				processController = new InsertBoardController("listSelect.do?cmd=listSelect",true);
				break;

		}

		
		
		return processController; 
	}

}
