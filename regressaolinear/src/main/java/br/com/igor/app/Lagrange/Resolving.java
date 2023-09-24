package br.com.igor.app.Lagrange;

import java.util.ArrayList;
import java.util.List;

import br.com.igor.app.Mocks.listLagrange;
import br.com.igor.app.Objetos.valorLagrange;

public class Resolving {

    private valorLagrange vl;

    private List<valorLagrange> lagranges = new ArrayList<>();
    private List<valorLagrange> listaFinal;
    private List<valorLagrange> auxList = new ArrayList<>();
    valorLagrange v = new valorLagrange(-5, 1);

    public void run(valorLagrange v1, valorLagrange v2, valorLagrange v3) {
        multplyXWithTwo(v1, v2);
        System.out.println(listLagrange.lagranges);
        sameXType(listLagrange.lagranges);
        System.out.println(listaFinal);
        auxList.add(v);
        multiplyAll(listaFinal, auxList);
    }

    public void multiplyAll(List<valorLagrange> listFinalValues, List<valorLagrange> newValues) {
        // Crie uma lista para armazenar os resultados
        List<valorLagrange> results = new ArrayList<>();
        int mult = 1;
        int index = newValues.size();

        for (valorLagrange finalValue : listFinalValues) {
            if (newValues.isEmpty())
                break;
            for (valorLagrange newValue : newValues) {
                System.out.println("valor final = " + finalValue + " new value = " + newValue);

                // (x) * (x)
                if (finalValue.hasX() && newValue.hasX()) {
                    int newValueValor = finalValue.getValor() * newValue.getX();
                    int newValueX = finalValue.getX() + newValue.getX();
                    results.add(new valorLagrange(newValueValor, newValueX));
                }
                // (x) * (n)
                if (finalValue.hasX() && newValue.getX() == 1) {
                    if (mult == 1) {
                        int newValueValor = newValue.getValor();
                        int newValueX = finalValue.getX();
                        results.add(new valorLagrange(newValueValor, newValueX));
                        mult++;
                    } else {
                        int newValueValor = finalValue.getValor() * newValue.getValor();
                        int newValueX = finalValue.getX();
                        results.add(new valorLagrange(newValueValor, newValueX));
                        mult = 1;
                    }

                }

                else if (!finalValue.hasX()) {
                    // Se finalValue não tem X, adicione-o diretamente aos resultados
                    results.add(new valorLagrange(finalValue.getValor(), newValue.getX()));
                }

                else if (!finalValue.hasX() && newValue.hasX()) {
                    int newValueValor = finalValue.getValor() * newValue.getX();
                    int newValueX = finalValue.getX() + newValue.getX();
                    results.add(new valorLagrange(newValueValor, newValueX));
                }
            }

        }

        results.add(new valorLagrange(listFinalValues.get((listFinalValues.size() - 1)).getValor()
                * newValues.get((newValues.size() - 1)).getValor(), 0));

        // Aqui, você pode fazer o que quiser com a lista results, como imprimir ou
        // armazenar em outra lista.
        sameXType(results);
        System.out.println(results);
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
        listaFinal = new ArrayList<>(listP);
    }

    public int sumORSub(int v1, int v2) {
        if (v2 < 0) {
            return (v1) - (v2);
        } else
            return v1 + v2;

    }
}