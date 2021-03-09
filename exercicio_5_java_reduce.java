import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class Exercicio_5 {

	public static void main(String[] args) {
		
		 //GERA UMA LISTA DE 100 NUMEROS ALEATORIOS DE 0 A 100
		 int[] lista_100_num = new Random().ints(0,100).limit(100).toArray();
		
		 //CONVERTE A LISTA EM UM ARRAY LIST PARA SE TRABALHAR COM O METODO STREAM
		 List<Integer> list = Arrays.stream(lista_100_num).boxed().collect(Collectors.toList());
		 
		 //SOMA TODOS OS VALORES DO ARRAY LIST
		 Optional<Integer> soma = list.stream().reduce((n1, n2) -> n1 + n2);
		 
		 //IMPRIME A SOMA
		 System.out.println(soma.get());
		 
		 //MULTIPLICA TODOS OS VALORES DO ARRAY LIST
		 Optional<Integer> multiplicacao = list.stream().reduce((n1, n2) -> n1 * n2);
		 
		 //IMPRIME A MULTIPLICACAO
		 System.out.println(multiplicacao.get());
		 
		 //CAPTURA O VALOR MINIMO DO ARRAY LIST
		 Optional<Integer> min = list.stream().reduce((n1, n2) -> Math.min(n1, n2));
		 
		 //IMPRIME O VALOR MINIMO
		 System.out.println(min.get());
		 
		 //CAPTURA O VALOR MAXIMO DO ARRAY LIST
		 Optional<Integer> max = list.stream().reduce((n1, n2) -> Math.max(n1, n2));
		 
		 //IMPRIME O MAXIMO VALOR
		 System.out.println(max.get());
		 
		 //LISTA DE NOMES
		 String[] ArrayNomes = { "Paulo", "Camila", "Ana Maria", "Patrik", "Ana Clara", "Pedro", "Alfredo" };
		
		 //CONVERTE PARA UM ARRAY LIST PQ STREAM TRABALHA COM ARRAYS LIST
		 List<String> ListaNomes = Arrays.asList(ArrayNomes);
		
		 //FILTRA OS NOMES COM P E CONVERTE EM UMA LISTA 
		 List<String> nomesP = ListaNomes.stream().filter(n1 -> n1.startsWith("P")).collect(Collectors.toList());
		
		 //FILTRA OS NOMES COM A E CONVERTE EM UMA LISTA 
		 List<String> nomesA = ListaNomes.stream().filter(n1 -> n1.startsWith("A")).collect(Collectors.toList());
		
		 //CONCATENA OS NOME FILTRADOS COM P 
		 Optional<String> nomes_concatenadosP = nomesP.stream().reduce((n1, n2) -> n1.concat(n2));
		 
		 //CONCATENA OS NOME FILTRADOS COM A
		 Optional<String> nomes_concatenadosA = nomesA.stream().reduce((n1, n2) -> n1.concat(n2));
		 
		 //CONCATENA TODOS OS NOMES
		 Optional<String> nomes_concatenados = ListaNomes.stream().reduce((n1, n2) -> n1.concat(n2));
			
		 //IMPRIME OS NOMES CONCATENADOS COM P 
		 nomes_concatenadosP.stream().forEach(n -> System.out.println(n));
		 
		 //IMPRIME OS NOMES CONCATENADOS COM A
		 nomes_concatenadosA.stream().forEach(n -> System.out.println(n));
		 
		 //IMPRIME TODOS OS NOMES CONCATENADOS
		 nomes_concatenados.stream().forEach(n -> System.out.println(n));

	}
	
}
