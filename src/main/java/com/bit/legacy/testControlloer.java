/*
package com.bit.legacy;

import com.bit.controller.ForWardController;
import com.bit.controller.ProcessController;
import com.bit.vo.BoardVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import java.util.Enumeration;

public class testControlloer implements ProcessController {
    private String path;
    private boolean redirect;

    public testControlloer(String path, boolean redirect) {
        super();
        this.path = path;
        this.redirect = redirect;
    }

    private String getFileName(String part) {
        String contentDisposition = part.getHeader("content-disposition");
        String[] tokens = contentDisposition.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length() - 1);
            }
        }
        return "";
    }

    @Override
    public ForWardController execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 멀티파트 설정 추가
        String uploadPath = "/Users/kimjingeun/IdeaProjects/ServletTestProject/src/main/webapp/upload"; // 파일을 저장할 경로로 수정
        int size = 10*1024 * 1024;
        String encoding = "UTF-8"; // 인코딩 설정

        MultipartRequest multipartRequest = new MultipartRequest(request,
                uploadPath, size, encoding, new DefaultFileRenamePolicy());

        String name = multipartRequest.getParameter("name");
        String category = multipartRequest.getParameter("category");
        String pass = multipartRequest.getParameter("pass");
        String title = multipartRequest.getParameter("title");
        String content = multipartRequest.getParameter("content");


        Enumeration<String> fileNames = multipartRequest.getFileNames();
        if (fileNames.hasMoreElements()) {
            String fileName = fileNames.nextElement();
            String filePart=multipartRequest.getParameter("filename");
            if (filePart != null) {
                String originalFileName = getFileName(filePart);
                if (!originalFileName.isEmpty()) {
                    String filePath = uploadPath + File.separator + originalFileName;

                    try (InputStream inputStream = filePart.getInputStream();
                         OutputStream outputStream = new FileOutputStream(new File(filePath))) {
                        byte[] buffer = new byte[1024];
                        int bytesRead;
                        while ((bytesRead = inputStream.read(buffer)) != -1) {
                            outputStream.write(buffer, 0, bytesRead);
                        }
                    }
                }
            }
        }


        //string이 들어가야함
        BoardVO vo = new BoardVO(name,category,pass,title,content, multipartRequest.getOriginalFileName())

        return new ForWardController("", false);
    }
}
*/
