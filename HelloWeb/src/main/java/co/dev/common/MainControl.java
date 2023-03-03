package co.dev.common;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/main/main.jsp");
		try {
			rd.forward(req, resp);
		}catch(Exception e) {
			e.printStackTrace();
		}//페이지 재지정
	}

}
