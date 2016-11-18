package testPackage;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSuma {
	
	@Test
	   public void sumaPositivos() {
	      System.out.println("Sumando dos n�meros positivos ...");
	       SumaClass S = new SumaClass(2, 3);
	       assertTrue(S.suma() == 5);
	   }

	   @Test
	   public void sumaNegativos() {
	       System.out.println("Sumando dos n�meros negativos ...");
	       SumaClass S = new SumaClass(-2, -3);
	       assertTrue(S.suma() == -5);
	   }

	   @Test
	   public void sumaPositivoNegativo() {
	       System.out.println("Sumando un n�mero positivo y un n�mero negativo ...");
	       SumaClass S = new SumaClass(2, -3);
	       assertTrue(S.suma() == -1);
	   }

}
