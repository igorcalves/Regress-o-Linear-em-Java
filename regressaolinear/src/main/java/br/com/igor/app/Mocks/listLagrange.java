package br.com.igor.app.Mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.igor.app.Objetos.ValorLagrange;

public class listLagrange {

    public static List<ValorLagrange> lagranges = new ArrayList<>();

    public static void list() {
        for (ValorLagrange valorLagrange : lagranges) {
            System.out.print(valorLagrange + " ");
        }
    }

}
