

import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet("/aluno/aprovado")
public class ListaAlunoAprovado extends HttpServlet{
private static final long serialVersionUID = 1L;

public static boolean isNumeric(String str) { 
	  try {  
	    Integer.parseInt(str);  
	    return true;
	  } catch(NumberFormatException e){  
	    return false;  
	  }  
}


@Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	Banco banco = new Banco();
	
	List<Aluno> lista = banco.getListaAluno();
	
	List<Aluno> listaAprovado = new ArrayList<>();
	
	int notaInt;
	String notaStr;
	
	for(int i=0; i < lista.size(); i++) {
		
		notaStr = lista.get(i).getNota();
		
		if(isNumeric(notaStr))
			notaInt= Integer.valueOf(lista.get(i).getNota());
		else
			notaInt=0;
		
		if (notaInt >= 6) {
			listaAprovado.add(lista.get(i));
		}
	}
	
	req.setAttribute("Alunos", listaAprovado);
	
	RequestDispatcher rd =
			req.getRequestDispatcher("/aluno-lista.jsp");
	rd.forward(req, resp);
	}

	
 }

