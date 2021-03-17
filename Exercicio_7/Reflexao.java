import java.awt.print.Printable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Reflexao {
	
	public static void refletirObjeto(Object objeto, Class classe) throws IllegalArgumentException, IllegalAccessException {
		
		System.out.println("Nome da classe: "+classe.getName());
		System.out.println("Nome da classe (simples): "+ classe.getSimpleName());
		System.out.println("Nome canonical: " + classe.getResource(classe.getName()));
		
		System.out.println("Tipo: " + classe.getTypeName());
		
		System.out.println("=========================================================================================");
		System.out.println("==============================ATRIBUTOS==================================================\n");
		
		Field[] atributos = classe.getDeclaredFields();
		
		for(Field F: atributos) {
			F.setAccessible(true);
			
			if (F.getType().isPrimitive())
				F.set(objeto, 0);
			else
				F.set(objeto, null);
			
			System.out.println(F.getName() + ":" + F.getType().getTypeName() + 
					"( primitivos: " + F.getType().isPrimitive() + ")" +
					"=> valor: " + F.get(objeto));
		}
		
		System.out.println("==========================================================================================");
		System.out.println("==================================METODOS=================================================\n");
		
		Method[] metodos = classe.getDeclaredMethods();
		
		for (Method M: metodos) {
			System.out.println(M.getName() + " -  paramtros: " + Arrays.toString(M.getParameterTypes())
			+ " - retorno: " + M.getReturnType().getSimpleName());
		}
	}
}
