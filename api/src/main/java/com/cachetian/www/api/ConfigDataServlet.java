package com.cachetian.www.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/config_data")
public class ConfigDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setCharacterEncoding("UTF-8");
	    res.setContentType("application/json");
		try (PrintWriter w = res.getWriter()) {
			StringBuffer sb = new StringBuffer(4096);
			sb.append(
					"{\"APP_TITLE\": \"云贴CloudCP\",\"VISIBLE_BUTTONS\": [\"Refresh\", \"SaveText\", \"SelectAllText\"]}");
			w.write(sb.toString());
		}
	}
}
