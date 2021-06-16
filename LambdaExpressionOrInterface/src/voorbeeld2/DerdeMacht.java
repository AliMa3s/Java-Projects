package voorbeeld2;
// DerdeMacht.java
// voorbeeld van gebruik van een interface
public class DerdeMacht implements IFunctie {
   @Override
   public double f(double x) {
      return x*x*x;
   }
}
