package voorbeeld2;
// IFunctie.java
// voorbeeld van een interface

// Annotatie is optioneel: beveiliging zodat er géén extra methode aan de interface kan toegevoegd worden
@FunctionalInterface
public interface IFunctie {
   double f(double x);
}
