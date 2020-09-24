package loja;

import java.util.ArrayList;
import java.util.List;


public class Banco {
	
	
	private static List<Aparelho> ListaAparelho = new ArrayList<>();

	private static Integer codigoAparelho = 1;
	
	//------------ metodos de aparelho-----------------------
	
	public void adicionaAparelho(Aparelho obj) {
		ListaAparelho.add(obj);
	}
	
	
	public void SalvaAparelho(Aparelho obj) {
		if(obj.getId()>0)
			atualizaAparelho(obj);
		else {
			obj.setId(getProximoCodigoAparelho());
			ListaAparelho.add(obj);
		}
	}
	
	private void atualizaAparelho(Aparelho obj) {
		
		for(int i=0; i < Banco.ListaAparelho.size(); i++) {
			if (Banco.ListaAparelho.get(i).getId() == obj.getId()) {
				Banco.ListaAparelho.set(i, obj);
			}
		}
	}
	
	public Integer getProximoCodigoAparelho( ) {
		return codigoAparelho++;
		
	}
	
	public List<Aparelho> getListaAparelho(){
		return Banco.ListaAparelho;
	}
	
	public Integer getTamanhoListaAparelho() {
		return Banco.ListaAparelho.size();
	}
	
	public Aparelho getAparelhobyId(Integer id) {
		Aparelho localizar = new Aparelho();

		for (Aparelho aparelho : Banco.ListaAparelho) {
			if (aparelho.getId() == id)
				localizar = aparelho;
		}

		return localizar;
	}

		
	//ctrl + 1: atalho para criar metodo
	
	//método que delata um aparelho
	public void deletaAparelho(Integer id) {
		for(int i=0; i < Banco.ListaAparelho.size(); i++) {
			if(Banco.ListaAparelho.get(i).getId() == id) {
				Banco.ListaAparelho.remove(i);
			}
		}
		
	}
}