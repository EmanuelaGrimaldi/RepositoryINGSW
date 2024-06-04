package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RicercaByParolaChiaveServlet")
public class RicercaByParolaChiaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RicercaByParolaChiaveServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parolaChiave = request.getParameter("inputParolaChiave");
		String StringIDUtente = request.getParameter("idUtente");
		
		if(StringIDUtente != null) {
			request.getRequestDispatcher("homeByParolaChiaveLoggato.jsp?parolaChiave="+parolaChiave+"&&idUtente="+StringIDUtente).forward(request, response);
		}else {
			request.getRequestDispatcher("homeByParolaChiave.jsp?parolaChiave="+parolaChiave).forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
