package com.example.Java_8.file;
import org.apache.commons.io.IOUtils;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 文件名可在客户端进行读取
        String fileName = "1.jpg";
        // 获取图片在服务端中的路径
        String path = "/photos/"+fileName;
        // 通过servlet对象可以读取文件内容
        ServletContext servletContext = getServletContext();
        // 设置请求头信息
        resp.setContentType(servletContext.getMimeType(path));

        resp.setHeader("Content-Disposition", "attachment; filename=" + fileName);
//        当有中文时
//        String str = "attachment; fileName=" + URLEncoder.encode("指定的中文名字.jpg", "utf-8");
//        resp.setHeader("Content-Disposition", str);
        // 传送数据
        InputStream resourceAsStream = servletContext.getResourceAsStream(path);
        ServletOutputStream outputStream = resp.getOutputStream();
        IOUtils.copy(resourceAsStream, outputStream);
    }
}
