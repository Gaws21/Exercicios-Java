package aluno;
import java.util.ArrayList;
import java.util.List;


public class Banco {
	
	
	private static List<Aluno> ListaAluno = new ArrayList<>();

	private static Integer codigoAluno = 1;
	
	//------------ metodos de aluno-----------------------
	
	public void adicionaAluno(Aluno obj) {
		ListaAluno.add(obj);
	}
	
	
	public void SalvaAluno(Aluno obj) {
		if(obj.getId()>0)
			atualizaAluno(obj);
		else {
			obj.setId(getProximoCodigoAluno());
			ListaAluno.add(obj);
		}
	}
	
	private void atualizaAluno(Aluno obj) {
		
		for(int i=0; i < Banco.ListaAluno.size(); i++) {
			if (Banco.ListaAluno.get(i).getId() == obj.getId()) {
				Banco.ListaAluno.set(i, obj);
			}
		}
	}
	
	public Integer getProximoCodigoAluno( ) {
		return codigoAluno++;
		
	}
	
	public List<Aluno> getListaAluno(){
		return Banco.ListaAluno;
	}
	
	public Integer getTamanhoListaAluno() {
		return Banco.ListaAluno.size();
	}
	
	public Aluno getAlunobyId(Integer id) {
		Aluno localizar = new Aluno();

		for (Aluno aluno : Banco.ListaAluno) {
			if (aluno.getId() == id)
				localizar = aluno;
		}

		return localizar;
	}

		
	//ctrl + 1: atalho para criar metodo
	
	//método que delata um aluno
	public void deletaAluno(Integer id) {
		for(int i=0; i < Banco.ListaAluno.size(); i++) {
			if(Banco.ListaAluno.get(i).getId() == id) {
				Banco.ListaAluno.remove(i);
			}
		}
		
	}
}