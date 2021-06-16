package voorbeeld2;

public class TestSigma {
   public static void main (String[] args) {
      Sigma s = new Sigma();
      double somkw = s.som(3,new Kwadraat());
      double somdm = s.som(3,new DerdeMacht());
      System.out.println("Som kwadraten : "+somkw);
      System.out.println("Som derdemachten : "+somdm);
   }
}
