package lab.test;
import lab.tipos.Complejo;

public class TestComplejo {

	public static void main(String[] args) {
		Complejo a = Complejo.of(1.,2.);
		System.out.println( a.toString());
		Complejo b = Complejo.of(2.,-1.);
		System.out.println( b.toString());
		System.out.println( b.equals(a));
		Complejo c = Complejo.parse("4+2i");
		System.out.println( c.toString());
		System.out.println("");
		
		System.out.println("#############################################");
		System.out.println("Test de la factoria:");
		Complejo c1 = Complejo.of(5.7,5.);
		System.out.println("El primer numero complejo definido es: c1 = "+c1.toString());
		System.out.println("");
		
		System.out.println("#############################################");
		System.out.println("Test del parseo:");
		Complejo c2 = Complejo.parse("-5+-7i");
		System.out.println("El segundo numero complejo definido es: c2 = "+c2.toString());
		System.out.println("");
		
		System.out.println("#############################################");
		System.out.println("Test de equals:");
		System.out.println("¿Son iguales c1 y c2? --> "+ c1.equals(c2));
		System.out.println("");
		
		System.out.println("#############################################");
		System.out.println("Test de algunas propiedades:");		
		System.out.println( String.format( "El argumento de c1 es: %.2f", c1.arg()));
		System.out.println( String.format( "El módulo de c2 es: %.2f", c2.abs()));
		System.out.println("");
		
		System.out.println("#############################################");
		System.out.println("Test de algunas funciones:");
		System.out.println( String.format( "La suma de c1 y c2 es: %s", (c1.add(c2)).toString()));
		System.out.println( String.format( "El producto de c1 y c2 es: %s", (c1.multiply(c2)).toString()));
		System.out.println( String.format( "La división entre c1 y c2 es: %s", (c1.divide(c2)).toString()));
		System.out.println( String.format( "c1 elevado a 2 es: %s", c1.pow(2.)));
	}
}

