package lab.funciones;

import java.util.ArrayList;
import java.util.List;

public class Funciones {
	
	public static Integer producto (Integer n, Integer k) {
		if (k<1) {
			throw new IllegalArgumentException("k tiene que ser mayor que 0");
		}
		if (n<k) {
			throw new IllegalArgumentException("n debe ser mayor o igual que k");
		}
		
		Integer res=n;
		while(k-1>0) {
			res*=(n-1);
			n--;
			k--;
		}
		return res;
	}
	
	public static Integer combinatorio (Integer n, Integer k) {
		if (k<0) {
			throw new IllegalArgumentException("k debe ser mayor o igual que 0");
		}
		if (n<k) {
			throw new IllegalArgumentException("n debe ser mayor o igual que k");
		}
		
		if(k==0 || k==n) {
			return 1;
		}
		Integer m= Math.min(k,n-k);
		Integer res=1;
		while (m>0) {
			res*=n;
			res/=m;
			n--;
			m--;
		}
		return res;
	}
	
	public static Double SNK (Integer n, Integer k) {
		if (k<=0) {
			throw new IllegalArgumentException("k debe ser mayor que 0");
		}
		if (n<k) {
			throw new IllegalArgumentException("n debe ser mayor o igual que k");
		}
		Integer k_aux=k;
		Integer factorialk=1;
		if(k_aux!=0 && k_aux!=1) {
			while(k_aux>1) {
				factorialk *=(k_aux);
				k_aux--;
			}
		}
		Double res=0.;
		Integer i=0;
		while(i<=k) {
			res+=((Math.pow((-1),i))*combinatorio(k,i)*(Math.pow((k-i),n)));
			i++;
		}
		return res/factorialk;
	}
	
	
	public static Double f( Double x ) {
		return 2*Math.pow(x,2);
	}
	
	public static Double df( Double x ) {
		return 4*x;
	}
	public static Double encuentraNewton (Double a, Double e) {
		Double xn1=0.;
		Integer limite=0;
		while(Math.abs(f(a))>e) {
			xn1=a-f(a)/df(a);
			a=xn1;
			limite++;
			if (limite>1000) {
				throw new IllegalArgumentException("El método no converge");
			}
		}
		return a;	
	}
	
	
	
	public static String inversa(String texto) {
		String res = "";
		char c;
		for (Integer i=0; i<texto.length(); i++){
		   c= texto.charAt(i);
		   res = c+res;
		}
		return res;
	}

	public static List<String> palindromos(String texto, Integer n){

		List<String> res = new ArrayList<>();
		if( n <= 0 ) {
			return res;
		}
		String[] partes = texto.split(",");
		String s = "";
		String t="";
		for( String str: partes ) {
			s = str.trim();
			t = inversa(s);
			if( s.equals(t) ) {
				res.add(s);
				n--;
				if( n == 0 ) {
					return res;
				}
			}
		}
		return res;
	}

}
