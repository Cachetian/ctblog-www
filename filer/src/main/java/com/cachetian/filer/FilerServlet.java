package com.cachetian.filer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminServlet
 */
//@WebServlet("/filer")
public class FilerServlet  extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setCharacterEncoding("UTF-8");
	    res.setContentType("application/json");
	    try (PrintWriter w = res.getWriter()) {
	    	StringBuffer sb = new StringBuffer();
//			Map<String, Object> map = new HashMap<>();
//			List<String> items = new ArrayList<String>();
//			map.put("items", items);
			
			// validate input
			String path = req.getParameter("path");
			if (null == path || "".equals(path)) {
				path = ".";
			}
			
			// file API logic
			File file = new File(path);
			String absolutePath = file.getAbsolutePath();
			res.getWriter().append("path: ").append(path).append("\n");
			sb.append("cur: ").append(absolutePath).append("\n sub:\n");
			for (int i = 0; i < file.list().length; i++) {
				String sub = file.list()[i];
				if (i != 0) {
					sb.append("\n");
				}
				sb.append("+[").append(i).append("]").append(sub);
//				items.add(sub);
			}
			
//			for (int i = 0; i < items.size(); i++) {
//				
//			}
			res.getWriter().append(sb.toString());
	    }
	}
	
}
