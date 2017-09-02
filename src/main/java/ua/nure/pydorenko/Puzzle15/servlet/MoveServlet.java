package ua.nure.pydorenko.Puzzle15.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.nure.pydorenko.Puzzle15.model.Puzzle;

@WebServlet("/move")
public class MoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Puzzle puzzle = (Puzzle) session.getAttribute("puzzle");

		String widString = request.getParameter("wid");
		System.out.print(widString + " ");
		int wid = Integer.parseInt(widString);

		String hidString = request.getParameter("hid");
		System.out.print(hidString + " ");
		int hid = Integer.parseInt(hidString);

		int shift = puzzle.move(wid, hid) ? 1 : 0;
		session.setAttribute("puzzle", puzzle);
		session.setAttribute("solved", puzzle.isSolved());
		session.setAttribute("num", Integer.valueOf(session.getAttribute("num").toString()) + shift);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
