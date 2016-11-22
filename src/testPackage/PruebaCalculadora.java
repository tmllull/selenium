package testPackage;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;

public class PruebaCalculadora {
	  @Rule
	   public SiFallaLaPrueba EjemploRegla = new SiFallaLaPrueba(); 
	    
	  @Test
	  public void evaluatesExpression() {
	    Calculadora calculadora = new Calculadora();
	    int sum = calculadora.evalua("1+2+3+5");
	    assertEquals(10, sum);
	 
	  }
	}