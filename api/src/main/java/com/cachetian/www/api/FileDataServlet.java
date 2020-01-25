package com.cachetian.www.api;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/file_data")
public class FileDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		FileDataConst.FILE_DATA_DIR = Paths.get(System.getProperty("catalina.base")).resolve("upload").toString();
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		try (PrintWriter w = res.getWriter()) {
			StringBuffer sb = new StringBuffer(4096);
			sb.append("{\"items\":[");
			File dir = new File(FileDataConst.FILE_DATA_DIR);
			if (!dir.exists()) {
				dir.mkdir();
			}
			String[] list = dir.list();
			if (list.length > 0) {
				for (int i = 0; i < list.length; i++) {
					if (i != 0) {
						sb.append(",");
					}
					String file = list[i];
					sb.append("{\"fileName\":\"").append(file).append("\",\"url\":\"/api/file_data('").append(file)
							.append("')/$value\"}");
				}
			}
			sb.append("]}");
			w.write(sb.toString());
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		String fileName = req.getHeader("slug");
		Files.copy(req.getInputStream(), Paths.get(FileDataConst.FILE_DATA_DIR).resolve(fileName));
		try (PrintWriter w = res.getWriter()) {
			w.write("{\"result\":\"success\"}");
		}
	}
}
