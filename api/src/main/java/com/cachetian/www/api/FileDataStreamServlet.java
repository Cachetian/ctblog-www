package com.cachetian.www.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/*")
public class FileDataStreamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String FILE_ROOT = "./temp_upload";

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		try (ServletOutputStream w = res.getOutputStream()) {
			String pathInfo = req.getPathInfo();
			if (pathInfo.startsWith("/file_data") && pathInfo.endsWith("/$value")) {
				// '/file_data('*')/$value'
				String fileName = pathInfo.substring(12, pathInfo.length() - 9);
				 // obtains ServletContext
		        ServletContext context = getServletContext();
		         
		        // gets MIME type of the file
		        String mimeType = context.getMimeType(fileName);
		        if (mimeType == null) {        
		            // set to binary type if MIME mapping not found
		            mimeType = "application/octet-stream";
		        }
				res.setContentType(mimeType);
				res.setHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode(fileName, StandardCharsets.UTF_8.toString()) + "\"");
				w.write(Files.readAllBytes(Paths.get(FILE_ROOT).resolve(fileName)));
			}
		}
	}
	
	public void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		try (PrintWriter w = res.getWriter()) {
			String pathInfo = req.getPathInfo();
			if (pathInfo.startsWith("/file_data(") && pathInfo.endsWith(")")) {
				// '/file_data('*')/$value'
				String fileName = pathInfo.substring(12, pathInfo.length() - 2);
				Files.delete(Paths.get(FILE_ROOT).resolve(fileName));
				w.write("{\"result\":\"success\"}");
			}
		}
	}
}
