//GAWAN FERREIRA - SP302170X - LP3A5 - ADS NOTURNO - PROJETO INTEGRADOR - 25-03-2021

package ProjetoIntegrador;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle error
import java.io.IOException;
import java.io.FileWriter;

public class Transacao extends Thread{

	
	public String caminho; //caminho do arquivo que irá salvar as transações
	public String tipo; //se a thread será do tipo leitura ou escrita
	static List<String> transacoes = new ArrayList<>(); //objeto transacoes que armazena as transações
	
	//------------------------------------------------- CONVERTER DATAS ----------------------------------------------------
	public static String fromStringToDate () {

		SimpleDateFormat formatoSaida=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date();
		try {
			String dataSaida = formatoSaida.format(date);
			return dataSaida;
		}
		catch(Exception e) {
			System.out.println("Sua data deve ser no formato DiaMesAno. Sendo ano com 4 digitos.");
			return "";
		}
	}
	
	//MENU
	public static int menu() {
		int opcao = 0;
		try {
			if(opcao !=11) {
				Scanner scannerIinput = new Scanner(System.in);  // Create a Scanner object
				System.out.println("+----------Transações----------+\n"
						+ "| 1  - Adicionar Receita       |\n"
						+ "| 2  - Editar Receita          |\n"
						+ "| 3  - Listar Receitas         |\n"
						+ "| 4  - Deletar Receita         |\n"
						+ "| 5  - Adicionar Despesa       |\n"
						+ "| 6  - Editar Despesa          |\n"
						+ "| 7  - Listar Despesas         |\n"
						+ "| 8  - Deletar Despesas        |\n"
						+ "| 9  - Histórico de Transações |\n"
						+ "| 10 - Exportar extrato        |\n"
						+ "| 11 - Finalizar               |\n"
						+ "+------------------------------+");
				String opcaoMenu = scannerIinput.nextLine(); 
				opcao = Integer.parseInt(opcaoMenu);
			}
		}
		catch (Exception e) {
			System.out.println("Escolha uma opção entre 1 e 11.");
		}
		return opcao;
	}

	//------------------------------------------------------- INSERCAO RECEITA -----------------------------------------------
	public static void inserirReceita(Receita receita) {

		Scanner scannerIinput = new Scanner(System.in); 
		String nomeReceita="";
		String valorReceitaString="";
		System.out.println("Pressione \"n\" para sair a qualquer momento");
		
		/*
		O laço do abaixo tem a função de verificar se a opção de não adicionar mais receitas ("n") foi escolhida.
		*/
		do{

			if(nomeReceita.equalsIgnoreCase("n") != true && valorReceitaString.equalsIgnoreCase("n") != true) {
				System.out.println("Nome da receita: ");
				nomeReceita = scannerIinput.nextLine();
			}
			else if (nomeReceita.equalsIgnoreCase("n") == true) {break;}

			if(nomeReceita.equalsIgnoreCase("n") != true && valorReceitaString.equalsIgnoreCase("n") != true) {
				System.out.println("Valor da receita: ");
				valorReceitaString = scannerIinput.nextLine();
			}
			else if(valorReceitaString.equalsIgnoreCase("n") == true) {break;}

			if(nomeReceita.equalsIgnoreCase("n") != true && valorReceitaString.equalsIgnoreCase("n") != true){
				try {
					double valorReceitaDouble = Double.parseDouble(valorReceitaString);
					receita.addReceita(nomeReceita, valorReceitaDouble);

					registrarTransacao(fromStringToDate()+" - Receita adicionada: "+nomeReceita+" - Valor: "+valorReceitaDouble);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			else {break;}
		}while (nomeReceita.equalsIgnoreCase("n") != true && valorReceitaString.equalsIgnoreCase("n") != true);
	}

	//LISTAR RECEITAS
	public static void listarReceitas(Receita receita) {
		receita.listarReceitas();
		System.out.println("Total Receitas: " + receita.calcReceitaFinalReduce());
	}

	// ------------------------------------------- REMOCAO -------------------------------------------------------
	//DELETAR
	public static void removerReceita(Receita receita) {
		String idReceitaString="";
		int idReceitaInt=0;

		System.out.println("Informe o id da receita da receita");

		Scanner scannerIinput = new Scanner(System.in);
		idReceitaString = scannerIinput.nextLine();

		try {
			idReceitaInt = Integer.parseInt(idReceitaString);
			receita.deletarReceita(idReceitaInt);

			registrarTransacao(fromStringToDate()+" - Receita Deletada: "+receita.receitas.get(idReceitaInt).getNome()+" - Valor: "+receita.receitas.get(idReceitaInt).getValor());
		}
		catch(NumberFormatException | IndexOutOfBoundsException e) {
			System.out.println("O indice deve ser um valor numérico");
		}
	}

	//DELETAR TUDO
	public static void limparReceita(Receita receita) {
		String idReceitaString="";
		int idReceitaInt=0;

		System.out.println("Deseja apagar todas as receitas ? Aperte \"s\" para sim ou qualquer outra tecla para sair.");

		Scanner scannerIinput = new Scanner(System.in);
		idReceitaString = scannerIinput.nextLine();

		try {
			if(idReceitaString.equalsIgnoreCase("s")) {
				receita.receitas.clear();
				registrarTransacao(fromStringToDate()+" - Todas receitas foram deletadas");
			}
		}
		catch(NumberFormatException e) {
			System.out.println("A lista de receitas já está vazia.");
		}
	}

	public static void deletarReceita(Receita receita) {

		String idReceitaString="";
		String idEscolhaEditarString="";
		int idEscolhaEditarInt=0;

		Scanner scannerIinput = new Scanner(System.in); 

		System.out.println("1 - Remover Receita\n"
				+"2 - Limpar Receitas\n");

		idEscolhaEditarString = scannerIinput.nextLine();

		try {
			idEscolhaEditarInt = Integer.parseInt(idEscolhaEditarString);
			switch(idEscolhaEditarInt){
			case 1:
				removerReceita(receita);
				break;
			case 2:
				limparReceita(receita);
				break;
			}
		}
		catch(NumberFormatException e) {
			System.out.println("A opção de edição deve ser um valor numérico.");
		}
	}

	// --------------------------------------------- EDICAO -----------------------------------------------------------
	//EDITAR INICIO
	public static void editarReceita(Receita receita) {

		String idReceitaString="";
		String idEscolhaEditarString="";
		int idEscolhaEditarInt=0;

		System.out.println("Informe o id da receita");

		Scanner scannerIinput = new Scanner(System.in);
		idReceitaString = scannerIinput.nextLine();

		int idReceitaInt = Integer.parseInt(idReceitaString);

		System.out.println("1 - Editar Nome\n"
				+"2 - Editar Valor\n"
				+"3 - Editar Nome e Valor");

		idEscolhaEditarString = scannerIinput.nextLine();

		try {
			String NomeReceitaEditado = receita.receitas.get(idReceitaInt).getNome();
			double valorReceitaEditado = receita.receitas.get(idReceitaInt).getValor();
			idEscolhaEditarInt = Integer.parseInt(idEscolhaEditarString);
			switch(idEscolhaEditarInt){
			case 1:
				EditarNome(receita, idReceitaString);
				registrarTransacao(fromStringToDate()+" - Receita Editada - Nome: \""+NomeReceitaEditado+"\" Para: \""+receita.receitas.get(idReceitaInt).getNome()+"\"");
				break;
			case 2:

				EditarValor(receita, idReceitaString);
				registrarTransacao(fromStringToDate()+" - Receita Editada - Valor: \""+valorReceitaEditado+"\" Para: \""+receita.receitas.get(idReceitaInt).getValor()+"\"");
				break;
			case 3:
				EditarNome(receita, idReceitaString);
				registrarTransacao(fromStringToDate()+" - Receita Editada - Nome: \""+NomeReceitaEditado+"\" Para: \""+receita.receitas.get(idReceitaInt).getNome()+"\"");
				EditarValor(receita, idReceitaString);
				registrarTransacao(fromStringToDate()+" - Receita Editada - Valor: \""+valorReceitaEditado+"\" Para: \""+receita.receitas.get(idReceitaInt).getValor()+"\"");
				break;
			}
		}
		catch(NumberFormatException | IndexOutOfBoundsException e) {

			if(e.getClass().equals(java.lang.IndexOutOfBoundsException.class)) {
				System.out.println("O index não existe.");
			} 
			else if(e.getClass().equals(java.lang.NumberFormatException.class)) {
					System.out.println("A opção de edição deve ser um valor numérico.");
			}
		}
	}
	//EDITAR FIM

	//EDITAR NOME INICIO
	public static void EditarNome(Receita receita, String idReceitaString) {
		int idReceitaInt = 0;
		int idEscolhaEditarInt = 0;
		String nomeReceita="";
		Scanner scannerIinput = new Scanner(System.in);

		try {
			idReceitaInt = Integer.parseInt(idReceitaString);

			System.out.println("Informe o nome da receita");
			nomeReceita = scannerIinput.nextLine();

			//editar receita
			receita.editarNomeReceita(idReceitaInt, nomeReceita);
		}
		catch(NumberFormatException e) {
			System.out.println("O indice deve ser um valor numérico.");
		}
	}
	//EDITAR NOME FIM

	//EDITAR VALOR INICIO
	public static void EditarValor(Receita receita, String idReceitaString) {
		int idReceitaInt = Integer.parseInt(idReceitaString);

		String valorReceita="";
		double valorReceitaDouble=0;

		Scanner scannerIinput = new Scanner(System.in);

		System.out.println("Informe o valor da receita");
		valorReceita = scannerIinput.nextLine();

		try {
			valorReceitaDouble = Double.parseDouble(valorReceita);

			//editar valor
			receita.editarValorReceita(idReceitaInt, valorReceitaDouble);
		}
		catch(NumberFormatException e) {
			System.out.println("O valor deve ser um um valor numérico.");
		}
	}
	//EDITAR VALOR FIM

	//--------------------------------------------------------- DESPESAS ---------------------------------------------------------
	//------------------------------------------------------- INSERCAO DESPESAS ---------------------------------------------------
	public static void inserirDespesa(Despesa despesa) {

		Scanner scannerIinput = new Scanner(System.in);
		String nomeDespesa="";
		String valorDespesaString="";
		System.out.println("Pressione \"n\" para sair a qualquer momento");

		do{
			if(nomeDespesa.equalsIgnoreCase("n") != true && valorDespesaString.equalsIgnoreCase("n") != true) {
				System.out.println("Nome da despesa: ");
				nomeDespesa = scannerIinput.nextLine();
			}
			else if (nomeDespesa.equalsIgnoreCase("n") == true) {break;}
			
			if(nomeDespesa.equalsIgnoreCase("n") != true && valorDespesaString.equalsIgnoreCase("n") != true) {
				System.out.println("Valor da despesa: ");
				valorDespesaString = scannerIinput.nextLine();
			}
			else if(valorDespesaString.equalsIgnoreCase("n") == true) {break;}

			if(nomeDespesa.equalsIgnoreCase("n") != true && valorDespesaString.equalsIgnoreCase("n") != true){
				try {
					double valorDespesaDouble = Double.parseDouble(valorDespesaString);
					despesa.addDespesa(nomeDespesa, valorDespesaDouble);

					registrarTransacao(fromStringToDate()+" - Despesa adicionada: "+nomeDespesa+" - Valor: "+valorDespesaDouble);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			else {break;}
		}
		while (nomeDespesa.equalsIgnoreCase("n") != true && valorDespesaString.equalsIgnoreCase("n") != true);
	}

	//LISTAR
	public static void listarDespesas(Despesa despesa) {
		despesa.listarDespesas();
		System.out.println("Total Despesas: " + despesa.calcDespesaFinalReduce());
	}

	// ------------------------------------------- REMOCAO -------------------------------------------------------
	//DELETAR
	public static void removerDespesa(Despesa despesa) {
		String idDespesaString="";
		int idDespesaInt=0;

		System.out.println("Informe o id da despesa");

		Scanner scannerIinput = new Scanner(System.in);
		idDespesaString = scannerIinput.nextLine();

		try {
			idDespesaInt = Integer.parseInt(idDespesaString);
			despesa.deletarDespesa(idDespesaInt);

			registrarTransacao(fromStringToDate()+" - Despesa Deletada: "+despesa.despesas.get(idDespesaInt).getNome()+" - Valor: "+despesa.despesas.get(idDespesaInt).getValor());

		}
		catch(NumberFormatException | IndexOutOfBoundsException e) {
			System.out.println("O indice deve ser um valor numérico");
		}

	}

	//DELETAR TUDO
	public static void limparDespesa(Despesa despesa) {
		String idDespesaString="";
		int idDespesaInt=0;

		System.out.println("Deseja apagar todas as despesas ? Aperte \"s\" para sim ou qualquer outra tecla para sair.");

		Scanner scannerIinput = new Scanner(System.in);
		idDespesaString = scannerIinput.nextLine();

		try {
			if(idDespesaString.equalsIgnoreCase("s")) {
				despesa.despesas.clear();

				registrarTransacao(fromStringToDate()+" - Todas despesas foram deletadas");
			}

		}
		catch(NumberFormatException e) {
			System.out.println("A lista de despesas já está vazia.");
		}

	}

	public static void deletarDespesa(Despesa despesa) {

		String idDespesaString="";
		String idEscolhaEditarString="";
		int idEscolhaEditarInt=0;

		Scanner scannerIinput = new Scanner(System.in);


		System.out.println("1 - Remover Despesa\n"
				+"2 - Limpar Despesas\n");

		idEscolhaEditarString = scannerIinput.nextLine();

		try {
			idEscolhaEditarInt = Integer.parseInt(idEscolhaEditarString);
			switch(idEscolhaEditarInt){
			case 1:
				removerDespesa(despesa);
				break;
			case 2:
				limparDespesa(despesa);
				break;
			}
		}
		catch(NumberFormatException e) {
			System.out.println("A opção de edição deve ser um valor numérico.");
		}
	}

	// --------------------------------------------- EDICAO -----------------------------------------------------------
	//EDITAR INICIO
	public static void editarDespesa(Despesa despesa) {

		String idDespesaString="";
		String idEscolhaEditarString="";
		int idEscolhaEditarInt=0;

		Scanner scannerIinput = new Scanner(System.in);

		System.out.println("Informe o id da despesa");
		idDespesaString = scannerIinput.nextLine();

		System.out.println("1 - Editar Nome\n"
				+"2 - Editar Valor\n"
				+"3 - Editar Nome e Valor");

		idEscolhaEditarString = scannerIinput.nextLine();
		
		try {
			int idDespesaInt = Integer.parseInt(idDespesaString);
			String NomeDespesaEditado = despesa.despesas.get(idDespesaInt).getNome();
			double valorDespesaEditado = despesa.despesas.get(idDespesaInt).getValor();
			idEscolhaEditarInt = Integer.parseInt(idEscolhaEditarString);
			switch(idEscolhaEditarInt){
			case 1:
				EditarNome(despesa, idDespesaString);
				registrarTransacao(fromStringToDate()+" - Despesa Editada - Nome: \""+NomeDespesaEditado+"\" Para: \""+despesa.despesas.get(idDespesaInt).getNome()+"\"");
				break;
			case 2:

				EditarValor(despesa, idDespesaString);
				registrarTransacao(fromStringToDate()+" - Despesa Editada - Valor: \""+valorDespesaEditado+"\" Para: \""+despesa.despesas.get(idDespesaInt).getValor()+"\"");
				break;
			case 3:
				EditarNome(despesa, idDespesaString);
				registrarTransacao(fromStringToDate()+" - Despesa Editada - Nome: \""+NomeDespesaEditado+"\" Para: \""+despesa.despesas.get(idDespesaInt).getNome()+"\"");
				EditarValor(despesa, idDespesaString);
				registrarTransacao(fromStringToDate()+" - Despesa Editada - Valor: \""+valorDespesaEditado+"\" Para: \""+despesa.despesas.get(idDespesaInt).getValor()+"\"");
				break;
			}
		}
		catch(NumberFormatException | IndexOutOfBoundsException e) {

			if(e.getClass().equals(java.lang.IndexOutOfBoundsException.class)) {
				System.out.println("O index não existe.");
			} else

				if(e.getClass().equals(java.lang.NumberFormatException.class)) {
					System.out.println("A opção de edição deve ser um valor numérico.");
				}
		}

	}
	//EDITAR FIM

	//EDITAR NOME INICIO
	public static void EditarNome(Despesa despesa, String idDespesaString) {
		int idDespesaInt = 0;
		int idEscolhaEditarInt = 0;
		String nomeDespesa="";
		Scanner scannerIinput = new Scanner(System.in);

		try {
			idDespesaInt = Integer.parseInt(idDespesaString);
			
			System.out.println("Informe o nome da despesa");
			nomeDespesa = scannerIinput.nextLine();

			//editar despesa
			despesa.editarNomeDespesa(idDespesaInt, nomeDespesa);
		}
		catch(NumberFormatException e) {
			System.out.println("O indice deve ser um valor numérico.");
		}
	}
	//EDITAR NOME FIM

	//EDITAR VALOR INICIO
	public static void EditarValor(Despesa despesa, String idDespesaString) {
		int idDespesaInt = Integer.parseInt(idDespesaString);

		String valorDespesa="";
		double valorDespesaDouble=0;

		Scanner scannerIinput = new Scanner(System.in);

		System.out.println("Informe o valor da despesa");
		valorDespesa = scannerIinput.nextLine();

		try {
			valorDespesaDouble = Double.parseDouble(valorDespesa);

			//editar valor
			despesa.editarValorDespesa(idDespesaInt, valorDespesaDouble);
		}
		catch(NumberFormatException e) {
			System.out.println("O valor deve ser um um valor numérico.");
		}
	}
	//EDITAR VALOR FIM

	// ------------------------------ TRANSACOES -----------------------------------
	public static void registrarTransacao(String registroTransacao) {
		transacoes.add(registroTransacao);
	}

	//LISTAR TRANSACOES
	public static void listarTransacao() {
		try {
			if( transacoes.size() != 0) {
				for(int i=0; i < transacoes.size(); i++) {
					System.out.println("Transação " + i + ": "+ transacoes.get(i));
				}
			}
			else {
				System.out.println("Não existem transações.");
			}
		}
		catch(NoSuchElementException e) {
			//System.out.println(e.getMessage());
			System.out.println("Não existem transações.");
		}
	};

	public static List<String> GravarTransacao() {
		List<String> listaTransacoes = new ArrayList<>();
		try {
			if( transacoes.size() != 0) {
				for(int i=0; i < transacoes.size(); i++) {
					listaTransacoes.add(transacoes.get(i));
				}
			}
			else {
				System.out.println("Não existem transações.");
			}
			return listaTransacoes;
		}
		catch(NoSuchElementException e) {
			//System.out.println(e.getMessage());
			System.out.println("Não existem transações.");
			return listaTransacoes;
		}
	};

	//----------------------------------- THREADS ----------------------------------------------------------

	public  void MinhaThreadIO(String caminho, String tipo) {
		this.caminho= caminho;
		this.tipo = tipo;
		start();
	}

	public void run() {
		if(tipo.equalsIgnoreCase("read")) {
			try {
				File scannerIinput = new File(caminho);
				Scanner myReader = new Scanner(scannerIinput);

				while (myReader.hasNextLine()) {
					String data = myReader.nextLine();
					System.out.println(data);

				}
				myReader.close();
			}
			catch (IOException e) {
				System.out.println("Erro ao ler. Tente novamente.");
				e.printStackTrace();
			}
		}

		else if (tipo.equalsIgnoreCase("write")) {
			try {
				List<String> listaTransacoes = Transacao.GravarTransacao();

				File scannerIinput = new File(caminho);
				Scanner myReader = new Scanner(scannerIinput);

				String data="";
				
				while (myReader.hasNextLine()) {
					data = myReader.nextLine();
				}

			FileWriter myWriter = new FileWriter(caminho, true);

				if (data.length() != 0) {
					myWriter.write(data+"\n");
				}

				for(int i=0; i < listaTransacoes.size(); i++) {
					myWriter.write(listaTransacoes.get(i)+"\n");
				}

				System.out.println("Exportação concluída com sucesso.");
				myWriter.close();
		}

			catch (IOException e) {
				System.out.println("Erro ao exportar. Tente Novamente.");
				e.printStackTrace();
			}
		}
	}
}
