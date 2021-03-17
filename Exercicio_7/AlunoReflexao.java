import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;


public class AlunoReflexao {
	private int codigo;
	private String nome;
	private String numMatricula;
	private GregorianCalendar dataMatricula;
	private ArrayList<Double> notas;
	private double valor;

	public AlunoReflexao(int codigo, String nome, String numMatricula, GregorianCalendar dataMatricula, double valor) {
		notas = new ArrayList<>();
		dataMatricula = new GregorianCalendar();
		
		this.codigo = codigo;
		this.nome = nome;
		this.numMatricula = numMatricula;
		this.dataMatricula = dataMatricula;
		this.valor = valor;
		
	}
	
	 public AlunoReflexao() {
		 notas = new ArrayList<>();
		 dataMatricula = new GregorianCalendar();
	 }
	 
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumMatricula() {
		return numMatricula;
	}

	public void setNumMatricula(String numMatricula) {
		this.numMatricula = numMatricula;
	}

	public GregorianCalendar getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(GregorianCalendar dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public ArrayList<Double> getNotas() {
		return notas;
	}

	public void setNotas(ArrayList<Double> notas) {
		this.notas = notas;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public void addNota(double n) {
		notas.add(n);
	}
	
	public double calcNotaFinal() {
		double notafinal = 0;
		for(Double nota: notas) {
			notafinal += nota;
		}
		
		return notafinal;
	}
	
	public void imprimirDados() {
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Dados do objetos: ");
		System.out.println(
		"objeto aluno: " + "\n" +
		"codigo: " + codigo + "\n" +
		"nome: " + nome + "\n" +
		"numMatricula = " + numMatricula + "\n" +
		"dataMatricula = " + dataFormatada.format(dataMatricula.getTime()) + "\n" +
		"notas = " + notas + "\n" +
		"valor = " + valor + "\n");
		
		System.out.println("Nota final: " + calcNotaFinal());
	};
	
	
	 
	 
}