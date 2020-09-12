
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import admin.Banco;
import admin.Livro;


@WebServlet("/livro/editar")
public class EditaLivro extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		
		Banco banco = new Banco();
		Livro livro = banco.getLivrobyId(Integer.valueOf(id));
		
		req.setAttribute("id", livro.getId());
		req.setAttribute("titulo", livro.getTitulo());
		req.setAttribute("autor", livro.getAutor());
		req.setAttribute("isbn",livro.getIsbn());
		req.setAttribute("preco",livro.getPreco());
		
		RequestDispatcher rd =req.getRequestDispatcher("/livro-novo.jsp");
	
		rd.forward(req, resp);
	}
}
