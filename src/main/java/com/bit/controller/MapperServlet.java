package com.bit.controller;

public class MapperServlet {
	
	public static ProcessController getMapper(String cmd) {
		ProcessController processController=null;

		switch (cmd){
			case "signup":
				System.out.println("signup");
				//path-> 이동할 경로 -> 회원가입성공하면 loginselect 실패하면 다시 sign up 으로
				processController = new SignUpController("",false);
				break;
		}

		
		
		return processController; 
	}

}
