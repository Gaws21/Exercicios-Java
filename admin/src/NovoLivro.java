

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.Banco;
import admin.Livro;


@WebServlet("/livro/novo")
public class NovoLivro extends HttpServlet{

private static final long serialVersionUID = 1L;

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 RequestDispatcher rd = req.getRequestDispatcher("/livro-novo.jsp");
	 
	 
	 /* Quando usamos o método forward, a solicitação é transferida para outro recurso dentro do mesmo servidor para processamento adicional. */
	 
	 rd.forward(req, resp);
	}

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
		 throws ServletException, IOException {
	 
	 System.out.println("Cadastrando novo cliente");
	 
	 String titulo = req.getParameter("titulo");
	 String autor = req.getParameter("autor");
	 String isbn = req.getParameter("isbn");
	 String preco = req.getParameter("preco");
	 
	 List<String> mensagens = new ArrayList<String>();
	
	 if (titulo.isEmpty())
		 mensagens.add("Campo título é obrigatório");
	 if (autor.isEmpty())
		 mensagens.add("Campo autor é obrigatório");
	 if (isbn.isEmpty())
		 mensagens.add("Campo ISBN é obrigatório");
	 if (preco.isEmpty())
		 mensagens.add("Campo preço é obrigatório");
	 if(mensagens.size() > 0){
		 req.setAttribute("mensagens", mensagens);
	 	 req.setAttribute("titulo", titulo);
	 	 req.setAttribute("autor", autor);
	 	 req.setAttribute("isbn", isbn);
	 	 req.setAttribute("preco", preco);
	 }
	 
	 else{
		 Livro livro = new Livro(); 
		 livro.setTitulo(titulo);
		 livro.setAutor(autor);
		 livro.setIsbn(isbn);
		 livro.setPreco(preco);

		 Banco banco = new Banco();

		 livro.setId(banco.getTamanhoListaLivro()+1);

		 banco.adicionaLivro(livro);

		 System.out.println("Livro cadastrado com sucesso!");
		 req.setAttribute("sucess", "Livro cadastrado com sucesso!");

	 }
	 
	 	doGet(req, resp);
		 
   }
}