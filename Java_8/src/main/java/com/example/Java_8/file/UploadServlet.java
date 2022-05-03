package com.example.Java_8.file;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (ServletFileUpload.isMultipartContent(req)) {
            // 创建文件工厂
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            // 创建servlet文件上传对象
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
                // 在请求体中获取一段一段的数据
                List<FileItem> list = servletFileUpload.parseRequest(req);
                for (FileItem item : list) {
                    if (item.isFormField()) {
                        System.out.println("name属性值" + item.getFieldName());
                        System.out.println("value属性值" + item.getString("utf-8"));
                    } else {
                        System.out.println("name属性值" + item.getFieldName());
                        System.out.println("文件名" + item.getName());
                        // 写入文件
                        item.write(new File("D:/@java/Test/Java_8/src/main/webapp/photos/" + item.getName()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
