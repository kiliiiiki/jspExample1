package co.edu.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.jdbc.EmpDAO;

@WebServlet("/getUserInfo")
public class JdbcServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EmpDAO dao = new EmpDAO();
		Map<String, Object> result = dao.getEmpInfo(req.getParameter("id"));
		Set<String> set = result.keySet();//키부분만 set
		for(String key : set) {
			System.out.println("key : "+key+", val : " +result.get(key));
		}
		
		req.setCharacterEncoding("utf-8");//요청정보의 인코딩 방식 지정		
		resp.setCharacterEncoding("utf-8");//응답정보의 인코딩 방식 지정
		resp.setContentType("text/html;charset=utf-8");
		
		//페이지 출력. 사번/이름(이름+성씨)/급여/부서
		PrintWriter out = resp.getWriter();
		
		//페이지 작성
		String html = "<html><head><title>정보</title></head>";
		html+= "<body>";
		html+= "사번 : " + result.get("id") +"<br>";
		html+= "이름 : " + result.get("firstName") + result.get("lastName")+"<br>";
		html+= "급여 : " + result.get("salary")+"<br>";
		html+= "부서 : " + result.get("departmentId");
		
		html += "</body></html>";
		
		out.print("<a href='temp.html'>조회 - 등록으로 이동</a>");
		
		out.print(html);
		out.close();
	}
}
