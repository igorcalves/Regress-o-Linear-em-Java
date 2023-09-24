package br.com.igor.app;

import java.util.ArrayList;
import java.util.List;

import br.com.igor.app.Lagrange.Resolving;
import br.com.igor.app.Objetos.valorLagrange;
import br.com.igor.app.RegressaoLinear.resolving;

public class zonadeTestes {
    public static void main(String[] args) {

        Resolving rs = new Resolving();
        List<valorLagrange> vl = new ArrayList<>();

        vl.add(new valorLagrange(1, 2));
        vl.add(new valorLagrange(1, 2));
        vl.add(new valorLagrange(1, 3));
        vl.add(new valorLagrange(1, 3));
        vl.add(new valorLagrange(1, 4));
        vl.add(new valorLagrange(1, 4));
        vl.add(new valorLagrange(53, 0));
        rs.sameXType(vl);

    }
}
