package voorbeeld2;

public class Sigma {
   public double som (int n, IFunctie fctie){
      double totaal=0;
      for (int x=1; x<=n; x++)
         totaal += fctie.f(x);
      return totaal;
   }
}
