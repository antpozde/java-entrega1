package lab.tipos;

import java.util.Objects;

public record Complejo(Double re, Double im) {
	
/*********************Constructores y factorias*****************/
	public static Complejo of(Double re, Double im) {
		return new Complejo(re, im);
	}
	
	public static Complejo of(Double re ) {
		return new Complejo(re,0.);
	}
	
	public static Complejo parse(String text) {
		String[]partes = text.split("\\+");						
		String[]parteIm = partes[1].split("i");
		return Complejo.of(Double.parseDouble(partes[0]),Double.parseDouble(parteIm[0]));
	}
	
/**************************Propiedades derivadas*****************/
	public Double abs() {
		return Math.sqrt(Math.pow(this.re(),2)+Math.pow(this.im(),2));
	}
	
	public Double arg() {
		return Math.atan2(this.im(), this.re());
	}
	
	public Complejo conjugado() {
		return new Complejo(this.re(), (-1)*this.im());
	}

/************Metodos de object(toString,equals,hashCode********/
	@Override
	public String toString() {
		if( this.re() == 0 ) {
			return String.format( "%+.2fi",this.im());
		} 
		else if ( this.im() == 0 ) {
			return String.format("%+.2f",this.re());
		} 
		else {			
			return String.format( "%.2f %+.2fi",this.re(),this.im());
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(im, re);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Complejo other = (Complejo) obj;
		return Objects.equals(im, other.im) && Objects.equals(re, other.re);
	}
	
/*********************Otros metodos************************/
	public Complejo add( Complejo otro) {
		return Complejo.of(this.re()+otro.re(), this.im()+otro.im());
	}
	
	public Complejo minus( Complejo otro) {
		return Complejo.of(this.re()-otro.re(), this.im()-otro.im());
	}
	
	public Complejo multiply(Complejo otro) {
		return Complejo.of(this.re()*otro.re()-this.im()*otro.im(), this.re()*otro.im()+this.im()*otro.re());
	}
	
	public Complejo divide(Complejo otro) {
		if(otro.abs() == 0) {
			throw new IllegalArgumentException( "No se puede dividir por 0");
		}
		return Complejo.of((this.re()*otro.re()+this.im()*otro.im())/(Math.pow(otro.re(), 2)+Math.pow(otro.im(), 2)), (this.im()*otro.re()-this.re()*otro.im())/(Math.pow(otro.re(),2)+Math.pow(otro.im(),2)));
	}
	
	public Complejo pow(Double n) {		
		return Complejo.of((Math.pow(this.abs(), n)*Math.cos(n*this.arg())),(Math.pow(this.abs(),n)*Math.sin(n*this.arg())));  						
	}

}
