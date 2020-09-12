package admin;
import java.util.ArrayList;
import java.util.List;


public class Banco {
	
	private static List<Cliente> listaCliente = new ArrayList<>();
	
	private static List<Livro> ListaLivro = new ArrayList<>();
	
	private static Integer codigo = 1;
	
	
	
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
	
	
	public void SalvaLivro(Livro obj) {
		if(obj.getId()>0)
			atualizaLivro(obj);
		else {
			obj.setId(getProximoCodigo());
			ListaLivro.add(obj);
		}
	}
	
	private void atualizaLivro(Livro obj) {
		
		for(int i=0; i < Banco.ListaLivro.size(); i++) {
			if (Banco.ListaLivro.get(i).getId() == obj.getId()) {
				Banco.ListaLivro.set(i, obj);
			}
		}
	}
	
	public Integer getProximoCodigo( ) {
		return codigo++;
		
	}
	
	public List<Livro> getListaLivro(){
		return Banco.ListaLivro;
	}
	
	public Integer getTamanhoListaLivro() {
		return Banco.ListaLivro.size();
	}
	
	public Livro getLivrobyId(Integer id) {
		Livro localizar = new Livro();

		for (Livro livro : Banco.ListaLivro) {
			if (livro.getId() == id)
				localizar = livro;
		}

		return localizar;
	}
}