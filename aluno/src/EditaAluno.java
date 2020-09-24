 import javax.servlet.RequestDispatcher;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import aluno.Banco;
import aluno.Aluno;


@WebServlet("/aluno/editar")
public class EditaAluno extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		
		Banco banco = new Banco();
		Aluno aluno = banco.getAlunobyId(Integer.valueOf(id));
		
		req.setAttribute("id", aluno.getId());
		req.setAttribute("nome", aluno.getNome());
		req.setAttribute("matricula", aluno.getMatricula());
		req.setAttribute("nota",aluno.getNota());
		
		RequestDispatcher rd =req.getRequestDispatcher("/aluno-novo.jsp");
	
		rd.forward(req, resp);
	}
}