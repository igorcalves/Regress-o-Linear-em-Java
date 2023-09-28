package br.com.igor.app;

import java.util.ArrayList;
import java.util.List;

import br.com.igor.app.Lagrange.Resolving;
import br.com.igor.app.Mocks.listLagrange;
import br.com.igor.app.Objetos.ValorLagrange;

public class Main {
    public static void main(String[] args) {

        List<ValorLagrange> vl = new ArrayList<>();
        ValorLagrange v1 = new ValorLagrange(-10, 1);
        ValorLagrange v2 = new ValorLagrange(13, 1);
        ValorLagrange v3 = new ValorLagrange(4, 1);

        vl.add(v1);
        vl.add(v2);
        vl.add(v3);

        Resolving rs = new Resolving();
        rs.run(vl);

        /*
        
         */
    }
}