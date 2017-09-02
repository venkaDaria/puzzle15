package ua.nure.pydorenko.Puzzle15.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.nure.pydorenko.Puzzle15.model.Puzzle;

@WebServlet({"/puzzle", ""})
public class StartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Puzzle puzzle = (Puzzle) session.getAttribute("puzzle");
		if (puzzle == null) {
			puzzle = new Puzzle();
			System.out.println(Arrays.deepToString(puzzle.getBlocks()));
			session.setAttribute("puzzle", puzzle);
			session.setAttribute("solved", false);
			session.setAttribute("num", 0);
		}

		getServletContext().getRequestDispatcher("/WEB-INF/puzzle.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}