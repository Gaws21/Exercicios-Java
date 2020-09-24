

import java.io.IOException;
import java.util.List;

import aluno.Banco;
import aluno.Aluno;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListaCliente
 */
@WebServlet("/aluno/lista")
public class ListaAluno extends HttpServlet{
private static final long serialVersionUID = 1L;

@Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	Banco banco = new Banco();
	
	List<Aluno> lista = banco.getListaAluno();
	
	req.setAttribute("Alunos", lista);
	
	RequestDispatcher rd =
			req.getRequestDispatcher("/aluno-lista.jsp");
	rd.forward(req, resp);
	}
 }