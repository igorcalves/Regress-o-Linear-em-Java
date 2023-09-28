package br.com.igor.app.Lagrange;

import java.util.ArrayList;
import java.util.List;

import br.com.igor.app.Mocks.listLagrange;
import br.com.igor.app.Objetos.ValorLagrange;

public class Resolving {

    private ValorLagrange vl;

    private List<ValorLagrange> lagranges = new ArrayList<>();
    private List<ValorLagrange> listaFinal;
    private List<ValorLagrange> auxList = new ArrayList<>();

    public void run(List<ValorLagrange> lagrangeList) {
        multplyXWithTwo(lagrangeList.get(0), lagrangeList.get(1));
        sameXType(listLagrange.lagranges);
        lagrangeList.remove(0);
        lagrangeList.remove(0);
        lagranges.addAll(lagrangeList);

        if (!lagranges.isEmpty()) {
            while (true) {
                if (lagranges.isEmpty())
                    break;
                auxList.add(0, lagranges.get(0));
                lagranges.remove(0);
                multiplyAll(listaFinal, auxList);
                auxList.remove(0);
            }
        }

        System.out.println(listaFinal);
    }

    public void multiplyAll(List<ValorLagrange> listFinalValues, List<ValorLagrange> newValues) {
        // System.out.println(listFinalValues);

        List<ValorLagrange> results = new ArrayList<>();
        int mult = 1;
        int index = 0;

        for (ValorLagrange finalValue : listFinalValues) {

            if (newValues.isEmpty())
                break;
            for (ValorLagrange newValue : newValues) {
                // (x) * (x)
                if (finalValue.hasX() && newValue.hasX()) {
                    int newValueValor = finalValue.getValor() * newValue.getX();
                    int newValueX = finalValue.getX() + newValue.getX();
                    results.add(new ValorLagrange(newValueValor, newValueX));
                }
                // (x) * (n)
                if (finalValue.hasX() && newValue.getX() == 1) {
                    if (mult == 1) {
                        int newValueValor = newValue.getValor();
                        int newValueX = finalValue.getX();
                        results.add(new ValorLagrange(newValueValor, newValueX));
                        mult++;
                    } else {
                        int newValueValor = finalValue.getValor() * newValue.getValor();
                        int newValueX = finalValue.getX();
                        results.add(new ValorLagrange(newValueValor, newValueX));
                    }

                }

                else if (!finalValue.hasX()) {
                    results.add(new ValorLagrange(finalValue.getValor(), newValue.getX()));
                }

                else if (!finalValue.hasX() && newValue.hasX()) {
                    int newValueValor = finalValue.getValor() * newValue.getX();
                    int newValueX = finalValue.getX() + newValue.getX();
                    results.add(new ValorLagrange(newValueValor, newValueX));
                }
                index++;
            }

        }

        results.add(new ValorLagrange(listFinalValues.get((listFinalValues.size() - 1)).getValor()
                * newValues.get((newValues.size() - 1)).getValor(), 0));
        sameXType(results);
        listaFinal.clear();
        listaFinal.addAll(results);
    }

    public void multplyXWithTwo(ValorLagrange v1, ValorLagrange v2) {
        listaFinal = new ArrayList<>();
        // primeira distributiva (x) * (x)
        vl = new ValorLagrange(1, v1.getX() + v2.getX());
        listLagrange.lagranges.add(vl);
        // segunda distributiva (x) * (n)
        vl = new ValorLagrange(v1.getX() * v2.getValor(), v1.getX());
        listLagrange.lagranges.add(vl);
        // terceira distributiva (n) * (x)
        vl = new ValorLagrange(v1.getValor(), v1.getX());
        listLagrange.lagranges.add(vl);
        // quarta distributiva (n) * (n)
        vl = new ValorLagrange(v1.getValor() * v2.getValor(), 0);
        listLagrange.lagranges.add(vl);
        sameXType(listLagrange.lagranges);
    }

    public void sameXType(List<ValorLagrange> listP) {
        // System.out.println("O que entrou = " + listP);
        int size = listP.size();

        for (int i = 0; i < size; i++) {
            ValorLagrange termoI = listP.get(i);

            if (termoI.getX() != null && termoI.getX() != 0) {
                for (int j = i + 1; j < size; j++) {
                    ValorLagrange termoJ = listP.get(j);

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

        // System.out.println("O que saiu = " + listP);
        listaFinal = new ArrayList<>(listP);
    }

    public int sumORSub(int v1, int v2) {
        if (v2 < 0) {
            return (v1) - (v2);
        } else
            return v1 + v2;

    }
}