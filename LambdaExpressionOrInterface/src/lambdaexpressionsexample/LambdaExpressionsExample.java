package lambdaexpressionsexample;

public class LambdaExpressionsExample {

    public static void main(String[] args) {
        IFunctie1 kwadraat = x -> x * x ;
        System.out.println(kwadraat.f(6));

        IFunctie1 derdemacht = x -> {
            return x * x * x;
        };
        // { } mogen NIET weg!!!
        System.out.println(derdemacht.f(2));

        IFunctie2 printen = () -> System.out.println("Hallo!!!");
        // () mogen NIET weg!!!
        printen.p();

        IFunctie3 printen2 = (s1, s2) -> {
            System.out.println("Hallo " + s1);
            System.out.println("Hallo " + s2);
        };
        // () mogen NIET weg!!!
        // { } mogen NIET weg (tenzij 2 opdrachten samengevoegd worden tot 1 opdracht)
        printen2.p("An", "Jan");

        Ivb laatste = new Ivb() {
            public double f(double x) {
                return -x;
            }

            public void p() {
                System.out.println("Gedaan!!!");
            }
        };
        // geen lambda expressie mogelijk, want Ivb is géén functional interface
        System.out.println(laatste.f(5));
        laatste.p();
    }
}

