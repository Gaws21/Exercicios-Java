package ProjetoIntegrador;
import java.util.Scanner;

public class MainProjetoIntegrador {

	public static void main(String[] args) {


		int retornoMenu=0;
		Receita receita = new Receita();
		Despesa despesa = new Despesa();

		do{
			retornoMenu = switchCase(Transacao.menu(), receita, despesa);
		}while(retornoMenu != 11);
	}

	public static int switchCase(int retornoMenu, Receita receita, Despesa despesa) {
		Scanner scannerIinput = new Scanner(System.in);

		Transacao leitura = new Transacao();
		Transacao escrita = new Transacao();

		switch(retornoMenu) {

		case 1:
			Transacao.inserirReceita(receita);		
			Transacao.listarReceitas(receita);
			break;
		case 2:
			Transacao.editarReceita(receita);
			Transacao.listarReceitas(receita);
			System.out.println("Aperte qualquer tecla para voltar ao menu.");
			break;
		case 3:
			Transacao.listarReceitas(receita);
			System.out.println("Aperte qualquer tecla para voltar ao menu.");
			scannerIinput.nextLine();
			break;
		case 4:
			Transacao.deletarReceita(receita);
			System.out.println("Aperte qualquer tecla para voltar ao menu.");
			scannerIinput.nextLine();
			break;
		case 5:
			Transacao.inserirDespesa(despesa);		
			Transacao.listarDespesas(despesa);
			break;
		case 6:
			Transacao.editarDespesa(despesa);
			Transacao.listarDespesas(despesa);
			System.out.println("Aperte qualquer tecla para voltar ao menu.");
			break;
		case 7:
			Transacao.listarDespesas(despesa);
			System.out.println("Aperte qualquer tecla para voltar ao menu.");
			scannerIinput.nextLine();
			break;
		case 8:
			Transacao.deletarDespesa(despesa);
			System.out.println("Aperte qualquer tecla para voltar ao menu.");
			scannerIinput.nextLine();
			break;
		case 9:
			Transacao.listarTransacao();
			System.out.println("Transações realizadas: ");
			synchronized(leitura) {
				try {
					leitura.MinhaThreadIO("C:\\Users\\gawan\\Documents\\ADS\\Java\\Projeto_integrador_LP3A5\\ProjetoIntegrador\\read_file.txt","read");
					leitura.wait();
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
			}

			System.out.println("Aperte qualquer tecla para voltar ao menu.");
			scannerIinput.nextLine();
			break;
		case 10:
			synchronized(escrita) {
				try {
					escrita.MinhaThreadIO("C:\\Users\\gawan\\Documents\\ADS\\Java\\Projeto_integrador_LP3A5\\ProjetoIntegrador\\read_file.txt","write");
					escrita.wait();
				}

				catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			Transacao.transacoes.clear();
			break;
		case 11:
			break;
		}
		return retornoMenu;
	}
}
