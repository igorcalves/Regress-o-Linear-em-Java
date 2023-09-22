package br.com.igor.app.Mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.igor.app.Objetos.valorLagrange;

public  class listLagrange {

    public static List<valorLagrange> lagranges = new ArrayList<>();


    public static void list() {
        for (valorLagrange valorLagrange : lagranges) {
                System.out.print(valorLagrange + " ");
        }
    }


    
    
}
