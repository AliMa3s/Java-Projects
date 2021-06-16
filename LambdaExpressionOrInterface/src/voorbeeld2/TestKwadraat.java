/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voorbeeld2;

/**
 *
 * @author svre257
 */
public class TestKwadraat {

    public static void main(String[] args) {
        IFunctie func = (x) -> {return x * x;};

        double res = func.f(3.5);
        System.out.println(res);

    }
}
