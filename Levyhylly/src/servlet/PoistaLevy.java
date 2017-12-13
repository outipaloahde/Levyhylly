package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LevyDAO;

@WebServlet("/PoistaLevy")
public class PoistaLevy extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public PoistaLevy() {
        super();
        System.out.println("PoistaLevy.PoistaLevy()");
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PoistaLevy.doGet()");
		String id = request.getParameter("poista_id");
		LevyDAO dao = new LevyDAO();
		if (dao.poistaLevy(id)){
			response.sendRedirect("HaeLevyt");
		} else {
			response.sendRedirect("haeLevyt.jsp=ilmo=2");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PoistaLevy.doPost()");
	
	}

}
