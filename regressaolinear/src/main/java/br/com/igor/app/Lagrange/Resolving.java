package br.com.igor.app.Lagrange;

import java.util.ArrayList;
import java.util.List;

import br.com.igor.app.Mocks.listLagrange;
import br.com.igor.app.Objetos.valorLagrange;

public class Resolving {
    private List<Integer> indexForRemove = new ArrayList<>();
    private valorLagrange vl;

    private List<valorLagrange> lagranges = listLagrange.lagranges;

    public void multplyXWithTwo(valorLagrange v1, valorLagrange v2) {
        // primeira distributiva (x) * (x)
        vl = new valorLagrange(1, v1.getX() + v2.getX());
        listLagrange.lagranges.add(vl);
        // segunda distributiva (x) * (n)
        vl = new valorLagrange(v2.getValor(), v1.getX());
        listLagrange.lagranges.add(vl);
        // terceira distributiva (n) * (x)
        vl = new valorLagrange(v1.getValor(), v1.getX());
        listLagrange.lagranges.add(vl);
        // quarta distributiva (n) * (n)
        vl = new valorLagrange(v1.getValor() * v2.getValor(), 0);
        listLagrange.lagranges.add(vl);
    }

    public void sameXType() {
        List<valorLagrange> auxLagranges = new ArrayList<>();
        int i = 0;
        int indice = 0;
        for (valorLagrange vl : lagranges) {
            if (i == lagranges.size())
                break;
            if (vl.getX() == listLagrange.lagranges.get(i + 1).getX()) {
                if (vl.getX() == 0)
                    ;
                else {
                    auxLagranges.add(vl);
                    indexForRemove.add(indice);
                }
                i++;
            }
            indice++;
        }

        int valor = sumORSub(auxLagranges.get(0).getValor(), auxLagranges.get(1).getValor());
        listLagrange.lagranges.add(i, new valorLagrange(valor, lagranges.get(i - 1).getX()));
        listLagrange.lagranges.remove(1);
        listLagrange.lagranges.remove(1);

    }

    public int sumORSub(int v1, int v2) {
        if (v2 < 0) {
            return (v1) + (v2);
        } else
            return v1 - v2;

    }
}