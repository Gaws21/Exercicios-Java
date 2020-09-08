package admin;
import java.util.ArrayList;
import java.util.List;


public class Banco {
	
	private static List<Cliente> listaCliente = new ArrayList<>();
	
	private static List<Livro> ListaLivro = new ArrayList<>();
	
	
	
	public void adicionaCliente(Cliente obj) {
		listaCliente.add(obj);
	}
	
	public List<Cliente> getListaCliente(){
		return Banco.listaCliente;
	}
	
	public Integer getTamanhoListaCliente() {
		return Banco.listaCliente.size();
	}
	
	
	public void adicionaLivro(Livro obj) {
		ListaLivro.add(obj);
	}
	
	public List<Livro> getListaLivro(){
		return Banco.ListaLivro;
	}
	
	public Integer getTamanhoListaLivro() {
		return Banco.ListaLivro.size();
	}
}