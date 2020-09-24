import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aluno.Banco;
import aluno.Aluno;


@WebServlet("/aluno/novo")
public class NovoAluno extends HttpServlet{

private static final long serialVersionUID = 1L;

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 RequestDispatcher rd = req.getRequestDispatcher("/aluno-novo.jsp");
	 
	 
	 /* Quando usamos o método forward, a solicitação é transferida para outro recurso dentro do mesmo servidor para processamento adicional. */
	 
	 rd.forward(req, resp);
	}

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
		 throws ServletException, IOException {
	 
	 System.out.println("Cadastrando novo aluno");
	 
	 
	 String id  = req.getParameter("id");
	 
	 if(id.isEmpty())
		 id="0";
	 
	 // seta as variáveis com java com os valores obtidos do front-end
	 String nome = req.getParameter("nome");
	 String matricula = req.getParameter("matricula");
	 String nota = req.getParameter("nota");
	 
	 //lista de string com as mensagens de campo obrigatoio
	 List<String> mensagens = new ArrayList<String>();
	
	 //verifica os campos obrigatorios. Caso algum esteja vazio a mensagem é exibida.
	 if (nome.isEmpty())
		 mensagens.add("Campo nome  é obrigatório");
	 if (matricula.isEmpty())
		 mensagens.add("Campo matricula é obrigatório");
	 if (nota.isEmpty())
		 mensagens.add("Campo nota é obrigatório");

	 
	 
	 //caso algum campo obrigatório não foi preenchido, então os dados já digitados são reenviados(setAttribute) para o front.
	 if(mensagens.size() > 0){
		 req.setAttribute("mensagens", mensagens);
		 req.setAttribute("id", id);
	 	 req.setAttribute("nome", nome);
	 	 req.setAttribute("matricula", matricula);
	 	 req.setAttribute("nota", nota);
	 }
	 //caso todos campos foram preenchidos, então um usuário é cadastrado.
	 else{
		 //um novo objeto livro é instanciado
		 Aluno aluno = new Aluno();
		 
		 //os valores do obtidos do front são setados nos atributos do objeto livro.
		 aluno.setNome(nome);
		 aluno.setId(Integer.valueOf(id));
		 aluno.setMatricula(matricula);
		 aluno.setNota(nota);

		 
		 //um novo objeto banco é instanciado
		 Banco banco = new Banco();
		 
		 //o id do livro é setado com o número da sua posição na lista do objeto banco.
		 //livro.setId(banco.getTamanhoListaLivro()+1);
		 
		 banco.SalvaAluno(aluno);

		 //o elemento livro é adicionado a lista do banco
		 //banco.adicionaLivro(livro);
		 
		 //mensagem impressa no console
		 System.out.println("Auno cadastrado com sucesso!");
		 
		 //seta o atributo sucess do front com a mensagem "Livro cadastrado com sucesso"
		 req.setAttribute("sucess", "Aluno cadastrado com sucesso!");

	 }
	 	
	 //retorna as informações para o front
	 	doGet(req, resp);
		 
   }
}