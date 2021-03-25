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

public class Despesa {
	List<Despesa> despesas = new ArrayList<>();


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
	public void addDespesa(String nome, double n) {


		Despesa despesa = new Despesa();


		if(n < 0) {
			despesa.setNome(nome);
			despesa.setValor(n*-1);
			despesas.add(despesa);
		}
		else {
			despesa.setNome(nome);
			despesa.setValor(n);
			despesas.add(despesa);
		}

	}

	//CALC RECEITA FINAL
	public double calcDespesaFinal() {
		double valorfinal = 0;
		for(int i=0; i < despesas.size(); i++) {
			valorfinal += despesas.get(i).getValor();
		}

		return valorfinal;
	}

	//CALC RECEITA FINAL REDUCE
	public double calcDespesaFinalReduce() {
		Optional<Double> valorfinalReduce = Optional.empty();
		//APLICACAO DE OPTIONA, STREAM, MAP E REDUCE
		try {
			valorfinalReduce = despesas.stream().map(r -> r.getValor()).reduce((r1, r2) -> r1 + r2);
			return valorfinalReduce.get();
		}

		catch(NoSuchElementException e) {
			System.out.println("Não existem receitas para ser listadas.");
		}

		return 0.0;

	}

	//LISTAR DESPESAS
	public void listarDespesas(){

		try {
			for(int i=0; i < despesas.size(); i++) {
				System.out.println("Despesa " + i + ": "+ despesas.get(i).getNome() + " - Valor: " + despesas.get(i).getValor());
			}
		}

		catch(NoSuchElementException e) {
			System.out.println("Não existem despesas para ser listadas.");
		}
	}


	//------------------------------------ TRY - CATCHS -----------------------------------------------------

	//DELETAR RECEITAS
	public void deletarDespesa(int idDespesa) {
		try {
			despesas.remove(idDespesa);


			System.out.println("Receita: "+idDespesa+" deletada");
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("Não foi possível deletar a despesa para o indice: "+idDespesa+". Esse indice não existe.");
		}
	}

	//EDITAR
	public void editarDespesa(int idDespesa, Despesa despesaEditada) {

		try {
			despesas.set(idDespesa, despesaEditada);
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("Não foi possível editar a receita para o indice: "+idDespesa+". Esse indice não existe.");
		}

	};

	//EDITAR NOME
	public void editarNomeDespesa(int idDespesa, String nome) {

		try {
			Despesa despesa = new Despesa();
			despesa.setNome(nome);
			despesa.setValor(despesas.get(idDespesa).getValor());
			editarDespesa(idDespesa, despesa);
		}

		catch (IndexOutOfBoundsException e) {
			System.out.println("Não foi possível editar o nome para o indice: "+idDespesa+". Esse indice não existe.");
		}
	};

	//EDITAR VALOR
	public void editarValorDespesa(int idDespesa, double valor) {
		try {
			Despesa despesa = new Despesa();
			despesa.setValor(valor);
			despesa.setNome(despesas.get(idDespesa).getNome());
			editarDespesa(idDespesa, despesa);
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("Não foi possível editar o valor para o indice: "+idDespesa+". Esse indice não existe.");
		}

	};

	//------------------------------------------------- CONVERTER DATAS ----------------------------------------------------

	public void fromStringToDate (String dataEntrada) {

		SimpleDateFormat formatoEntrada=new SimpleDateFormat("ddMMyyyy");
		SimpleDateFormat formatoSaida=new SimpleDateFormat("dd/MM/yyyy");

		try {
			//ParseException
			Date objetoDate= formatoEntrada.parse(dataEntrada);
			String dataSaida = formatoSaida.format(objetoDate);
			System.out.println(dataSaida);
		}

		catch(Exception e) {
			System.out.println("Sua data deve ser no formato DiaMesAno. Sendo ano com 4 digitos.");
		}

	}

}
