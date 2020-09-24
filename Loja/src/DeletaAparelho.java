
import loja.Banco;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeletaAparelho
 */
@WebServlet("/aparelho/deleta")
public class DeletaAparelho extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DeletaAparelho() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//passa o ai para exclusão
				String id = request.getParameter("id");
				
				//instancia o banco
				Banco banco = new Banco();
				
				//aplica o método deleta do banco
				
				banco.deletaAparelho(Integer.valueOf(id));
				
			}

		}