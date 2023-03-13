package co.yedam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.service.BookService;
import co.yedam.service.BookServiceMybatis;

public class BoodInfoControl implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService service = new BookServiceMybatis();

		String code = request.getParameter("code");		
		
		request.setAttribute("info", service.getBookInfo(code));
		
		request.getRequestDispatcher("WEB-INF/book/bookInfo.jsp").forward(request, response);

	}

}
