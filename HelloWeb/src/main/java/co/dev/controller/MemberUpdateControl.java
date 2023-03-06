package co.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.common.Control;
import co.dev.service.MemberService;
import co.dev.service.MemberServiceImpl;
import co.dev.vo.MemberVO;

public class MemberUpdateControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// parameter : id, pass, name, mail
		String id = req.getParameter("id");
		String pw = req.getParameter("pass");
		String nm = req.getParameter("name");
		String ml = req.getParameter("mail");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPasswd(pw);
		vo.setName(nm);
		vo.setMail(ml);
		
		//수정메소드 호출
		MemberService service = new MemberServiceImpl();
		if(service.modifyMember(vo)) {
			req.setAttribute("message", "정상처리완료");
		}else {
			req.setAttribute("message", "예외 발생");
		}
		
		//페이지 재지정
		try {
			req.getRequestDispatcher("WEB-INF/member/memberUpdateOutput.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
