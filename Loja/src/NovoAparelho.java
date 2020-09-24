

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class NovoAparelho
 */
@WebServlet("/aparelho/novo")
public class NovoAparelho extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public NovoAparelho() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 RequestDispatcher rd = req.getRequestDispatcher("/aparelho-novo.jsp");
		/* Quando usamos o método forward, a solicitação é transferida para outro recurso dentro do mesmo servidor para processamento adicional. */
		 
		 rd.forward(req, resp);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Cadastrando novo aluno");
		 
		 
		 String id  = req.getParameter("id");
		 
		 if(id.isEmpty())
			 id="0";
		 
		 // seta as variáveis com java com os valores obtidos do front-end
		 String marca = req.getParameter("marca");
		 String tipo = req.getParameter("tipo");
		 String ano = req.getParameter("ano");
		 String preco = req.getParameter("preco");
		 
		 //lista de string com as mensagens de campo obrigatoio
		 List<String> mensagens = new ArrayList<String>();
		
		 //verifica os campos obrigatorios. Caso algum esteja vazio a mensagem é exibida.
		 if (marca.isEmpty())
			 mensagens.add("Campo marca  é obrigatório");
		 if (tipo.isEmpty())
			 mensagens.add("Campo tipo é obrigatório");
		 if (ano.isEmpty())
			 mensagens.add("Campo ano é obrigatório");
		 if (preco.isEmpty())
			 mensagens.add("Campo preço é obrigatório");

		 
		 
		 //caso algum campo obrigatório não foi preenchido, então os dados já digitados são reenviados(setAttribute) para o front.
		 if(mensagens.size() > 0){
			 req.setAttribute("mensagem", mensagens);
			 req.setAttribute("id", id);
			 req.setAttribute("marca", marca);
			 req.setAttribute("tipo", tipo);
		 	 req.setAttribute("ano", ano);
		 	 req.setAttribute("preco", preco);
		 	 
		 }
		 //caso todos campos foram preenchidos, então um usuário é cadastrado.
		 else{
			 //um novo objeto livro é instanciado
			 Aparelho aparelho = new Aparelho();
			 
			 //os valores do obtidos do front são setados nos atributos do objeto livro.
			 aparelho.setMarca(marca);
			 aparelho.setId(Integer.valueOf(id));
			 aparelho.setTipo(tipo);
			 aparelho.setPreco(preco);
			 aparelho.setAno(ano);

			 
			 //um novo objeto banco é instanciado
			 Banco banco = new Banco();
			 
			 //o id do livro é setado com o número da sua posição na lista do objeto banco.
			 //livro.setId(banco.getTamanhoListaLivro()+1);
			 
			 banco.SalvaAparelho(aparelho);

			 //o elemento livro é adicionado a lista do banco
			 //banco.adicionaLivro(livro);
			 
			 //mensagem impressa no console
			 System.out.println("Aparelho cadastrado com sucesso!");
			 
			 //seta o atributo sucess do front com a mensagem "Livro cadastrado com sucesso"
			 req.setAttribute("sucess", "Aparelho cadastrado com sucesso!");

		 }
		 	
		 //retorna as informações para o front
		 	doGet(req, resp);
			 
	   }
}