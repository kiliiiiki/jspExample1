package co.yedam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.service.BookService;
import co.yedam.service.BookServiceMybatis;
import co.yedam.vo.BookVO;

public class BoodAddControl implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String code = request.getParameter("bookCode");
		String title = request.getParameter("bookTitle");
		String author = request.getParameter("bookAuthor");
		String press = request.getParameter("bookPress");
		String desc = request.getParameter("bookDesc");
		int price = Integer.parseInt(request.getParameter("bookPrice"));
		
		BookVO vo = new BookVO();
		vo.setBookCode(code);
		vo.setBookTitle(title);
		vo.setBookAuthor(author);
		vo.setBookPress(press);
		vo.setBookDesc(desc);
		vo.setBookPrice(price);
		
		System.out.println(vo);
		
		BookService service = new BookServiceMybatis();
		if (service.addBook(vo)) {
			response.sendRedirect("bookList.do");
		}else {
			request.getRequestDispatcher("WEB-INF/book/bookAddForm.jsp").forward(request, response);
		}

			
		
		
		
		
		
		
	}

}
