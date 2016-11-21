package testPackage;

public class Calculadora {
	  public int evalua(String expression) {
	    int suma = 0;
	    for (String sumando: expression.split("\\+"))
	      suma += Integer.valueOf(sumando);
	    return suma;
	  }
	}