package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LevyDAO;

@WebServlet("/Kirjautuminen")
public class Kirjautuminen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Kirjautuminen() {
        super();
        System.out.println("Kirjautuminen.Kirjautuminen()");
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Kirjautuminen.doGet()");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Kirjautuminen.doPost()");
		String salasana = request.getParameter("salasana");
		String kayttaja = request.getParameter("kayttaja");
		LevyDAO dao = new LevyDAO();
		String nimi = dao.login(kayttaja, salasana);
		if (nimi != null){
			HttpSession session = request.getSession(true);
			session.setAttribute("kayttaja", nimi);
			response.sendRedirect("HaeLevyt");
		} else {
			response.sendRedirect("index.jsp?=login=0");
			
		}
	}

}
