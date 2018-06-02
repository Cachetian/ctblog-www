package com.cachetian.www.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cp")
public class CpServlet extends HttpServlet {
	private static final long serialVersionUID = 9181283319629364771L;
	private static final StringBuffer sb = new StringBuffer(819200);
	private static final int bufferSize = 1024;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		try (PrintWriter w = res.getWriter()) {
			w.write(sb.toString());
		}
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		try (InputStream in = req.getInputStream()) {
			sb.delete(0, sb.length());
			final char[] buffer = new char[bufferSize];
			Reader r = new InputStreamReader(in, "UTF-8");
			for (; ; ) {
			    int rsz = r.read(buffer, 0, buffer.length);
			    if (rsz < 0)
			        break;
			    sb.append(buffer, 0, rsz);
			}
		}
		try (PrintWriter w = res.getWriter()) {
			w.write("{\"result\":\"success\"}");
		}
	}
}
