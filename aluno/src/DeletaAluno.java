

import java.io.IOException;
import aluno.Banco;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeletaAluno
 */
@WebServlet("/aluno/deleta")
public class DeletaAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//passa o ai para exclusão
		String id = request.getParameter("id");
		
		//instancia o banco
		Banco banco = new Banco();
		
		//aplica o método deleta do banco
		
		banco.deletaAluno(Integer.valueOf(id));
		
	}

}
