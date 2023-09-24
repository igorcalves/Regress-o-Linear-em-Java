package br.com.igor.app.Lagrange;

import java.util.ArrayList;
import java.util.List;

import br.com.igor.app.Mocks.listLagrange;
import br.com.igor.app.Objetos.valorLagrange;

public class Resolving {

    private valorLagrange vl;

    private List<valorLagrange> lagranges = listLagrange.lagranges;
    private List<valorLagrange> ln = new ArrayList<>();
    private List<valorLagrange> listaFinal = new ArrayList<>();

    private List<valorLagrange> valorFinal = new ArrayList<>();

    public void run(valorLagrange v1, valorLagrange v2, valorLagrange v3) {
        multplyXWithTwo(v1, v2);
        listaFinal.add(v1);
        listaFinal.add(v2);

        System.out.println(listLagrange.lagranges);
        sameXType(listLagrange.lagranges);
        listLagrange.list();
    }

    public void multplyAll(List<valorLagrange> listOfValue) {

    }

    public void multplyXWithTwo(valorLagrange v1, valorLagrange v2) {
        // primeira distributiva (x) * (x)
        vl = new valorLagrange(1, v1.getX() + v2.getX());
        listLagrange.lagranges.add(vl);
        // segunda distributiva (x) * (n)
        vl = new valorLagrange(v1.getX() * v2.getValor(), v1.getX());
        listLagrange.lagranges.add(vl);
        // terceira distributiva (n) * (x)
        vl = new valorLagrange(v1.getValor(), v1.getX());
        listLagrange.lagranges.add(vl);
        // quarta distributiva (n) * (n)
        vl = new valorLagrange(v1.getValor() * v2.getValor(), 0);
        listLagrange.lagranges.add(vl);
    }

    public void sameXType() {
        List<Integer> indexForRemove = new ArrayList<>();
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
    }

    public void sameXType(List<valorLagrange> listP) {
        System.out.println("O que entrou = " + listP);
        int size = listP.size();

        for (int i = 0; i < size; i++) {
            valorLagrange termoI = listP.get(i);

            if (termoI.getX() != null && termoI.getX() != 0) {
                for (int j = i + 1; j < size; j++) {
                    valorLagrange termoJ = listP.get(j);

                    if (termoJ.getX() != null && termoJ.getX() != 0 && termoJ.getX().equals(termoI.getX())) {
                        int novoValor = termoI.getValor() + termoJ.getValor();
                        termoI.setValor(novoValor);

                        listP.remove(j);
                        size--;
                        j--;
                    }
                }
            }
        }

        System.out.println("O que saiu = " + listP);
    }

    public int sumORSub(int v1, int v2) {
        if (v2 < 0) {
            return (v1) - (v2);
        } else
            return v1 + v2;

    }
}