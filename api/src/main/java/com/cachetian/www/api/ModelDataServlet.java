package com.cachetian.www.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/model_data")
public class ModelDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int BUFF_SIZE = 4096;
	private static final int BUFF_SIZE_SWAP = 512;
	private static final StringBuffer stringBuffer = new StringBuffer(BUFF_SIZE + 13);

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		try (PrintWriter w = res.getWriter()) {
			w.write(stringBuffer.toString());
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		try (Reader r = req.getReader()) {
			stringBuffer.delete(0, stringBuffer.length());
			final char[] cbuf = new char[BUFF_SIZE_SWAP];
			while (true) {
				int read = r.read(cbuf, 0, cbuf.length);
				if (read < 0)
					break;
				stringBuffer.append(cbuf, 0, read);
			}
		}
		try (PrintWriter w = res.getWriter()) {
			w.write("{\"result\":\"success\"}");
		}
	}
}
