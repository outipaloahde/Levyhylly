package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LevyDAO;
import model.Levy;

@WebServlet("/LisaaLevy")
public class LisaaLevy extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LisaaLevy() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String levyArtisti = request.getParameter("levyArtisti");
		String levyNimi = request.getParameter("levyNimi");
		int julkaisuVuosi = Integer.parseInt(request.getParameter("julkaisuVuosi")); 
		String formaatti = request.getParameter("formaatti");
		String levyYhtio = request.getParameter("levyYhtio");
		String genre = request.getParameter("genre");
		Levy levy = new Levy(levyArtisti, levyNimi, julkaisuVuosi, formaatti, levyYhtio, genre);
		LevyDAO dao = new LevyDAO();
		if (dao.lisaaLevy(levy)){
			response.sendRedirect("lisaaLevy.jsp?ilmo=levy lisätty");
		} else {
			response.sendRedirect("lisaaLevy.jsp?ilmo=levyn lisääminen ei onnistunut");
		}
		
		
	}

}
