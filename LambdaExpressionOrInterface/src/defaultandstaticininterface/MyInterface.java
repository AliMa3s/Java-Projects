package defaultandstaticininterface;

public interface MyInterface {
    
    default void begroet(String nm) {
        System.out.println("MyInterface: Hallo " + nm);
    }
    
    static void neemAfscheid(String nm) {
        System.out.println("MyInterface: Salut " + nm);
    }
    
    void babbel();
}
