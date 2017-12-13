package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LevyDAO;
import model.Levy;


@WebServlet("/MuokkaaLevy")
public class MuokkaaLevy extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public MuokkaaLevy() {
        super();
        System.out.println("MuokkaaLevy.MuokkaaLevy()");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MuokkaaLevy.doGet()");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MuokkaaLevy.doPost()");
		
		String levyId = request.getParameter("id").toString();
		String levyArtisti = request.getParameter("artistiUusi");
		String levyNimi = request.getParameter("nimiUusi");
		String julkaisuVuosi = request.getParameter("vuosiUusi").toString();
		String formaatti = request.getParameter("formaattiUusi");
		String levyYhtio = request.getParameter("yhtioUusi");
		String genre = request.getParameter("genreUusi");
		Levy levy = new Levy(levyArtisti, levyNimi, julkaisuVuosi, formaatti, levyYhtio, genre);
		LevyDAO dao = new LevyDAO();
		dao.muutaLevy(levy, levyId);
		response.sendRedirect("HaeLevyt");	
		
	}

}
