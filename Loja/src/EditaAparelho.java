

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import loja.Aparelho;
import loja.Banco;

/**
 * Servlet implementation class EditaAparelho
 */
@WebServlet("/aparelho/editar")
public class EditaAparelho extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EditaAparelho() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		
		Banco banco = new Banco();
		Aparelho aparelho = banco.getAparelhobyId(Integer.valueOf(id));
		
		req.setAttribute("id", aparelho.getId());
		req.setAttribute("marca", aparelho.getMarca());
		req.setAttribute("tipo", aparelho.getTipo());
		req.setAttribute("ano",aparelho.getAno());
		req.setAttribute("preco",aparelho.getPreco());
		
		RequestDispatcher rd =req.getRequestDispatcher("/aparelho-novo.jsp");
	
		rd.forward(req, resp);
	}
}