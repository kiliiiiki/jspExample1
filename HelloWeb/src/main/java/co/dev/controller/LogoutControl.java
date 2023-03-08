package co.dev.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.dev.common.Control;

public class LogoutControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession(); //요청정보에 있는 session객체
		session.invalidate();//세션 객체 지우기
		
		try {
			resp.sendRedirect("noticeList.do");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
