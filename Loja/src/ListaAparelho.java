

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import loja.Aparelho;
import loja.Banco;

/**
 * Servlet implementation class ListaAparelho
 */
@WebServlet("/aparelho/lista")
public class ListaAparelho extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ListaAparelho() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
			Banco banco = new Banco();
			
			List<Aparelho> lista = banco.getListaAparelho();
			
			req.setAttribute("Aparelhos", lista);
			
			RequestDispatcher rd =
					req.getRequestDispatcher("/aparelho-lista.jsp");
			rd.forward(req, resp);
			}
		 }