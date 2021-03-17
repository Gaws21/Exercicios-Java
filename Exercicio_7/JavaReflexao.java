import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;



public class JavaReflexao {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, ClassNotFoundException, InstantiationException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException {
		
		AlunoReflexao A = new AlunoReflexao();
		A.setCodigo(1);
		A.setNome("Gawan");
		A.setNumMatricula("SP302170X");
		A.setValor(100.00);
		A.addNota(10);
		A.addNota(5);
		A.imprimirDados();
		
		Reflexao.refletirObjeto(A, AlunoReflexao.class);
		
		System.out.println("====================================================================================================");
		System.out.println("==================================COM CLASS.FORANME=================================================\n");
		
		Class minhaClasse = Class.forName("AlunoReflexao");
		Object meuObjeto = minhaClasse.getConstructor().newInstance();
		
		Field F;
		
		F = meuObjeto.getClass().getDeclaredField("nome");
		F.setAccessible(true);
		F.set(meuObjeto,"SCC");
		
		F = meuObjeto.getClass().getDeclaredField("codigo");
		F.setAccessible(true);
		F.set(meuObjeto, 9);
		
		Class[] parametros = new Class[1];
		
		parametros[0] = double.class;
		
		Method M = meuObjeto.getClass().getDeclaredMethod("addNota", parametros);
		M.invoke(meuObjeto, 99.9);
		
		M = meuObjeto.getClass().getDeclaredMethod("imprimirDados");
		M.invoke(meuObjeto);
	}
}
	
