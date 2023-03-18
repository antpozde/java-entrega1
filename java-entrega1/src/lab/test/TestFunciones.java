package lab.test;

import java.util.List;

import lab.funciones.Funciones;

public class TestFunciones {

	public static void main(String[] args) {
		Integer n = 4;
		Integer k = 2;
		
		System.out.println("#############################################");
		System.out.println("Test del metodo 'producto'");
		System.out.println("El producto de "+n+" y "+k+" es:"+Funciones.producto(n,k));
		System.out.println("");
		
		System.out.println("#############################################");
		System.out.println("Test del metodo 'combinatorio'");
		System.out.println("El numero combinatorio de "+n+" y "+k+" es:"+Funciones.combinatorio(n,k));
		System.out.println("");

		System.out.println("#############################################");
		System.out.println("Test del metodo 'SNK'");
		System.out.println("El numero S(n,k) siendo n="+n+" y k="+k+" es:"+Funciones.SNK(n,k));
		System.out.println("");

		System.out.println("#############################################");
		System.out.println("Test del metodo 'encuentraNewton'");
		Double a=3.;
		Double e = 0.001;
		System.out.println("Resultado del metodo encuentraNewton con a="+a+", e="+e+", f(x) = 2x^2 y f'(x)=4x: "+Funciones.encuentraNewton(a,e));
		System.out.println("");
		
		System.out.println("#############################################");
		System.out.println("Test del metodo 'palindromos'");
		String texto = "hola, somos, o, no, somos, sobornos, porque, sevilla, vienen, anna, y, otto";
		n = 4;
		System.out.println("La frase de entrada es -->"+texto );
		System.out.println("Los primeros "+n+" palindromos son: ");
		List<String> res = Funciones.palindromos(texto, n);
		System.out.println(res);
	}
}
