
package defaultandstaticininterface;

public class MyClass implements MyInterface  {
    
    @Override
    public void babbel() {
        System.out.println("Hoe gaat het?");
    }
    
    //klasse mag methodes uit de interface overschrijven
    @Override
    public void begroet(String nm) {
        System.out.println("MyClass: Hallo " + nm);
    }
    
    public static void neemAfscheid(String nm) {
        System.out.println("MyClass: Salut " + nm);
    }
}
