package defaultandstaticininterface;


public class DefaultAndStaticInInterface {

    public static void main(String[] args) {
        MyClass vb = new MyClass();
        
        vb.begroet("iedereen");
        vb.babbel();
        vb.neemAfscheid("iedereen");
        
        MyInterface.neemAfscheid("iedereen");
        //opmerking: static methode uit een interface kan enkel op
        //de interface zelf opgeroepen worden, NIET op MyClass of vb

    }
    
}
