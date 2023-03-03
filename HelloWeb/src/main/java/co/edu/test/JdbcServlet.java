package co.edu.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
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
		
		String eid = req.getParameter("empId");
		if(req.getMethod().equals("GET")) {
			//조회용
			Map<String, Object> result = dao.getEmpInfo(Integer.parseInt(eid));
			Set<String> set = result.keySet();//키부분만 set 컬렉선
			for(String key : set) {
				System.out.println("key : "+key+", val : " +result.get(key));
			}
		}else if(req.getMethod().equals("POST")) {
			//등록 POST방식 처리
			String first = req.getParameter("first");
			String last = req.getParameter("last");
			String hire = req.getParameter("hire");
			String job = req.getParameter("job");
			String email = req.getParameter("email");
			
			//영속계층의 기능. EmpDAO에.
			Map<String, Object> map = new HashMap<>();
			map.put("eid", eid);
			map.put("first", first);
			map.put("last", last);
			map.put("hire", hire);
			map.put("job", job);
			map.put("email", email);
			
			int result = dao.insertEmp(map);
			System.out.println(result);
		}
		
		
		req.setCharacterEncoding("utf-8");//요청정보의 인코딩 방식 지정		
		resp.setCharacterEncoding("utf-8");//응답정보의 인코딩 방식 지정
		resp.setContentType("text/html;charset=utf-8");
		
		//페이지 출력. 사번/이름(이름+성씨)/급여/부서
		PrintWriter out = resp.getWriter();
		
		//페이지 작성
		Map<String, Object> result = dao.getEmpInfo(Integer.parseInt(eid));
		String html = "<html><head><title>정보</title></head>";
		html+= "<body>";
		html+= "사번 : " + result.get("id") +"<br>";
		html+= "이름 : " + result.get("firstName") + result.get("lastName")+"<br>";
		html+= "급여 : " + result.get("salary")+"<br>";
		html+= "부서 : " + result.get("departmentId")+"<br>";
		
		html += "</body></html>";
		
		
		
		out.print(html);
		out.print("<a href='temp.html'>조회 - 등록으로 이동</a>");
		out.close();
	}
}
