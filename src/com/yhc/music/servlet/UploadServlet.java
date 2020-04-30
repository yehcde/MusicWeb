package com.yhc.music.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @author yehaocheng
 */
public class UploadServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        this.doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pathName = request.getServletPath();
        if (Objects.equals("/upload.do", pathName)) {
            request.getRequestDispatcher("/WEB-INF/views/biz/upload.jsp").forward(request, response);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            DiskFileItemFactory sf = new DiskFileItemFactory();

            sf.setRepository(new File(pathName));
            sf.setSizeThreshold(1024 * 1024);
            String rename = "";
            String fileName = "";
            String name = "";
            ServletFileUpload sfu = new ServletFileUpload(sf);

            try {
                List<FileItem> lst = sfu.parseRequest(request);
                //得到request中所有的元素
                for (FileItem fileItem : lst) {
                    if (fileItem.isFormField()) {
                        if ("name".equals(fileItem.getFieldName())) {
                            name = fileItem.getString("UTF-8");
                        }
                    } else {
                        //获得文件名称
                        fileName = fileItem.getName();
                        fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
                        String houzhui = fileName.substring(fileName.lastIndexOf("."));
                        rename = UUID.randomUUID() + houzhui;
                        fileItem.write(new File(pathName, rename));
                    }
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.sendRedirect("/WEB-INF/views/biz/successful.jsp");
            out.flush();
            out.close();
        }
    }
}

