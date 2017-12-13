package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LevyDAO;
import model.Levy;

@WebServlet("/HaeLevyt")
public class HaeLevyt extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public HaeLevyt() {
        super();
        System.out.println("HaeLevyt.HaeLevyt()");
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HaeLevyt.doGet()");
		LevyDAO dao = new LevyDAO();
		ArrayList<Levy> levyt = dao.listaaKaikki();
		request.setAttribute("levyt", levyt);
		String jsp = "/haeLevyt.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HaeLevyt.doPost()");
		String hakusana = request.getParameter("hakusana");
		if (hakusana.isEmpty()){
			response.sendRedirect("haeLevyt.jsp?ilmo=Anna hakusana");
			return;
		}
		
		System.out.println(hakusana);
		LevyDAO dao = new LevyDAO();
		ArrayList<Levy> levyt = dao.listaaKaikki(hakusana);
		request.setAttribute("levyt", levyt);
		String jsp = "/haeLevyt.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
		
	}

}
