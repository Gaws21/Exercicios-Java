//GAWAN FERREIRA - SP302170X - LP3A5 - ADS NOTURNO - PROJETO INTEGRADOR - 25-03-2021

package ProjetoIntegrador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class Receita {
	List<Receita> receitas = new ArrayList<>();


	String nome;
	double valor;
	String data;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	//ADD RECEITA
	public void addReceita(String nome, double n) {


		Receita receita = new Receita();


		if(n < 0) {
			receita.setNome(nome);
			receita.setValor(n*-1);
			receitas.add(receita);
		}
		else {
			receita.setNome(nome);
			receita.setValor(n);
			receitas.add(receita);
		}

	}

	//CALC RECEITA FINAL
	public double calcReceitaFinal() {
		double valorfinal = 0;
		for(int i=0; i < receitas.size(); i++) {
			valorfinal += receitas.get(i).getValor();
		}

		return valorfinal;
	}

	//CALC RECEITA FINAL REDUCE
	public double calcReceitaFinalReduce() {
		Optional<Double> valorfinalReduce = Optional.empty();
		//APLICACAO DE OPTIONA, STREAM, MAP E REDUCE
		try {
			valorfinalReduce = receitas.stream().map(r -> r.getValor()).reduce((r1, r2) -> r1 + r2);
			return valorfinalReduce.get();
		}

		catch(NoSuchElementException e) {
			System.out.println("Não existem receitas para ser listadas.");
		}

		return 0.0;

	}

	//LISTAR RECEITAS
	public void listarReceitas(){

		try {
			for(int i=0; i < receitas.size(); i++) {
				System.out.println("Receita " + i + ": "+ receitas.get(i).getNome() + " - Valor: " + receitas.get(i).getValor());
			}
		}

		catch(NoSuchElementException e) {
			System.out.println("Não existem receitas para ser listadas.");
		}
	}


	//------------------------------------ TRY - CATCHS -----------------------------------------------------

	//DELETAR RECEITAS
	public void deletarReceita(int idReceita) {
		try {
			receitas.remove(idReceita);


			System.out.println("Receita: "+idReceita+" deletada");
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("Não foi possível deletar a receita para o indice: "+idReceita+". Esse indice não existe.");
		}
	}

	//EDITAR
	public void editarReceita(int idReceita, Receita receitaEditada) {

		try {
			receitas.set(idReceita, receitaEditada);
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("Não foi possível editar a receita para o indice: "+idReceita+". Esse indice não existe.");
		}

	};

	//EDITAR NOME
	public void editarNomeReceita(int idReceita, String nome) {

		try {
			Receita receita = new Receita();
			receita.setNome(nome);
			receita.setValor(receitas.get(idReceita).getValor());
			editarReceita(idReceita, receita);
		}

		catch (IndexOutOfBoundsException e) {
			System.out.println("Não foi possível editar o nome para o indice: "+idReceita+". Esse indice não existe.");
		}
	};

	//EDITAR VALOR
	public void editarValorReceita(int idReceita, double valor) {
		try {
			Receita receita = new Receita();
			receita.setValor(valor);
			receita.setNome(receitas.get(idReceita).getNome());
			editarReceita(idReceita, receita);
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("Não foi possível editar o valor para o indice: "+idReceita+". Esse indice não existe.");
		}

	};



}
