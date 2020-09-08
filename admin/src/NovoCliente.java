

import java.io.IOException;
import admin.Banco;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import admin.Cliente;


 @WebServlet("/cliente/novo")
 public class NovoCliente extends HttpServlet{

 private static final long serialVersionUID = 1L;
 
 @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 RequestDispatcher rd = req.getRequestDispatcher("/cliente-novo.jsp");
	 
	 
	 /* Quando usamos o método forward, a solicitação é transferida para outro recurso dentro do mesmo servidor para processamento adicional. */
	 
	 rd.forward(req, resp);
	}

 @Override
 protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
		 throws ServletException, IOException {
	 
	 
	 System.out.println("Cadastrando novo cliente");
	 
	 String nome = req.getParameter("nome");
	 String tipo = req.getParameter("tipo");
	 String email = req.getParameter("email");
	 String cpf_cnpj = req.getParameter("cpf_cnpj");
	 String telefone = req.getParameter("telefone");
 
	 Cliente cliente = new Cliente();
 
 
	 cliente.setNome(nome);
	 cliente.setEmail(email);
	 cliente.setCpf_cnpj(cpf_cnpj);
	 cliente.setTelefone(telefone);
	 cliente.setTipo(tipo);
 
	 Banco banco = new Banco();
 
	 cliente.setId(banco.getTamanhoListaCliente()+1);
 
	 banco.adicionaCliente(cliente);
	 
	 doGet(req, resp);
 
 System.out.println("Cliente cadastrado com sucesso!");
 }
}



