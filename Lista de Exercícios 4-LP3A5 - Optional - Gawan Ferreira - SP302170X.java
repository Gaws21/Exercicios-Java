package lista_lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class lista_4 {

	public static void main(String[] args) {
		
		ex1_optional_vazio_a();
		ex1_optional_vazio_a_2();
		ex1_optional_com_valor_b();
		ex1_optional_com_valor_b_2();
		
		ex2_optional_sem_valor_a();
		
		//ex2_optional_sem_valor_b();
		
		ex3_optional_lista_noems();
		ex4_optional_lista_nomes();
		
	}
	
	public static Optional <String> converteEmString(String Str) {
		
		try {
			String strConvertida = null;
			
			if(Str != null && Str == "Valor Esperado") {
				 strConvertida = strConvertida = String.valueOf(Str);
			}
			
			return Optional.of(strConvertida);
		} catch (Exception e) {
			
			return Optional.empty();
		}
		
	}
	
	public static void ex1_optional_vazio_a() {
		String	s = null;
		String str = converteEmString(s).orElse("Sem valor");
		System.out.println(str);
	}
	
	public static void ex1_optional_vazio_a_2() {
		String	s = null;
		String string = converteEmString(s)
				.orElseGet(()-> {return "Sem valor";});
		
		System.out.println(string);
		
	}
	
	public static void ex1_optional_com_valor_b() {
		String	s = "Valor não esperado";
		String string = converteEmString(s)
				.orElseGet(()-> {return "Sem valor Esperado";});
		
		System.out.println(string);
		
	}
	
	public static void ex1_optional_com_valor_b_2() {
		String	s = "Valor não esperado";
		String string = converteEmString(s)
				.orElseGet(()-> {return "Sem valor Esperado";});
		
		System.out.println(string);
	}
	
	public static void ex2_optional_sem_valor_a() {
		String	s = null;
		String string = converteEmString(s)
				.orElseGet(()-> {return "Sem valor";});
		
		System.out.println(string);
	}
	
	public static void ex2_optional_sem_valor_b() {
		String	s = "Valor não esperado";
		String string = converteEmString(s)
				.orElseThrow(() -> new NullPointerException(s));
	}
	
	public static void ex3_optional_lista_noems() {
		
		String[] ArrayNomes = { "Paulo", "Camila", "Ana Maria", "Patrik", "Ana Clara", "Pedro", "Alfredo" };
		
		List<String> ListaNomes = Arrays.asList(ArrayNomes);
		
		Optional<String> nome = ListaNomes.stream()
									.findAny()
									.filter(n -> n.startsWith("W"));
		
		
		nome.ifPresent(n -> System.out.println("Existem nome com W"));
		
		String resultado = nome.orElse("Sem nomes com W");
		System.out.println(resultado);
		
	}
	
	public static void ex4_optional_lista_nomes() {
		
		String[] ArrayNomes = { "Paulo", "Camila", "Ana Maria", "Patrik", "Ana Clara", "Pedro", "Alfredo" };
		
		List<String> ListaNomes = Arrays.asList(ArrayNomes);
		
		Optional<String> nome = ListaNomes.stream()
									.findAny()
									.filter(n -> n.startsWith("W"));
		
		nome
		.orElseThrow(() -> new NullPointerException("Sem nomes com W"));
		
	}
	
	
}
