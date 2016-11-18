package testPackage;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSuma {
	
	@Test
	   public void sumaPositivos() {
	      System.out.println("Sumando dos números positivos ...");
	       SumaClass S = new SumaClass(2, 3);
	       assertTrue(S.suma() == 5);
	   }

	   @Test
	   public void sumaNegativos() {
	       System.out.println("Sumando dos números negativos ...");
	       SumaClass S = new SumaClass(-2, -3);
	       assertTrue(S.suma() == -5);
	   }

	   @Test
	   public void sumaPositivoNegativo() {
	       System.out.println("Sumando un número positivo y un número negativo ...");
	       SumaClass S = new SumaClass(2, -3);
	       assertTrue(S.suma() == -1);
	   }

}
