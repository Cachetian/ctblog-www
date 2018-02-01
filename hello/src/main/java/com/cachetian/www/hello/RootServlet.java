package com.cachetian.www.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class RootServlet extends HttpServlet {
	private static final long serialVersionUID = 9181283319629364771L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		try (PrintWriter w = res.getWriter()) {
			w.write("Hello");
		}
	}
}