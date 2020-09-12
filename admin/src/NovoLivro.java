

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
	 
	 System.out.println("Cadastrando novo livro");
	 
	 
	 String id  = req.getParameter("id");
	 
	 if(id.isEmpty())
		 id="0";
	 
	 // seta as variáveis com java com os valores obtidos do front-end
	 String titulo = req.getParameter("titulo");
	 String autor = req.getParameter("autor");
	 String isbn = req.getParameter("isbn");
	 String preco = req.getParameter("preco");
	 
	 //lista de string com as mensagens de campo obrigatoio
	 List<String> mensagens = new ArrayList<String>();
	
	 //verifica os campos obrigatorios. Caso algum esteja vazio a mensagem é exibida.
	 if (titulo.isEmpty())
		 mensagens.add("Campo título é obrigatório");
	 if (autor.isEmpty())
		 mensagens.add("Campo autor é obrigatório");
	 if (isbn.isEmpty())
		 mensagens.add("Campo ISBN é obrigatório");
	 if (preco.isEmpty())
		 mensagens.add("Campo preço é obrigatório");
	 
	 
	 //caso algum campo obrigatório não foi preenchido, então os dados já digitados são reenviados(setAttribute) para o front.
	 if(mensagens.size() > 0){
		 req.setAttribute("mensagens", mensagens);
		 req.setAttribute("id", id);
	 	 req.setAttribute("titulo", titulo);
	 	 req.setAttribute("autor", autor);
	 	 req.setAttribute("isbn", isbn);
	 	 req.setAttribute("preco", preco);
	 }
	 //caso todos campos foram preenchidos, então um usuário é cadastrado.
	 else{
		 //um novo objeto livro é instanciado
		 Livro livro = new Livro();
		 
		 //os valores do obtidos do front são setados nos atributos do objeto livro.
		 livro.setTitulo(titulo);
		 livro.setId(Integer.valueOf(id));
		 livro.setAutor(autor);
		 livro.setIsbn(isbn);
		 livro.setPreco(preco);
		 
		 //um novo objeto banco é instanciado
		 Banco banco = new Banco();
		 
		 //o id do livro é setado com o número da sua posição na lista do objeto banco.
		 //livro.setId(banco.getTamanhoListaLivro()+1);
		 
		 banco.SalvaLivro(livro);

		 //o elemento livro é adicionado a lista do banco
		 //banco.adicionaLivro(livro);
		 
		 //mensagem impressa no console
		 System.out.println("Livro cadastrado com sucesso!");
		 
		 //seta o atributo sucess do front com a mensagem "Livro cadastrado com sucesso"
		 req.setAttribute("sucess", "Livro cadastrado com sucesso!");

	 }
	 	
	 //retorna as informações para o front
	 	doGet(req, resp);
		 
   }
}