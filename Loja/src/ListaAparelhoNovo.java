

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
 * Servlet implementation class ListaAparelhoNovo
 */
@WebServlet("/aparelho/lista/novo")
public class ListaAparelhoNovo extends HttpServlet {
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
		
		List<Aparelho> lista = banco.getListaAparelho();
		
		List<Aparelho> listaNovo = new ArrayList<>();
		
		
		String tipoNovo;
		
		for(int i=0; i < lista.size(); i++) {
			
			tipoNovo = lista.get(i).getTipo();
			
			if(tipoNovo.equals("novo")) {
				listaNovo.add(lista.get(i));
			}
		}
		
		req.setAttribute("Aparelhos", listaNovo);
		
		RequestDispatcher rd =
				req.getRequestDispatcher("/aparelho-lista.jsp");
		rd.forward(req, resp);
		}

		
}