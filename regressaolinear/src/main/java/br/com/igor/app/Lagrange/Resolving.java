package br.com.igor.app.Lagrange;

import java.util.ArrayList;
import java.util.List;

import br.com.igor.app.Objetos.ValorLagrange;

public class Resolving {

    private ValorLagrange vl;

    private List<ValorLagrange> lagrangesUpSide = new ArrayList<>();
    private List<ValorLagrange> finalUpSideList;
    private List<ValorLagrange> finalUpDownList = new ArrayList<>();
    private List<ValorLagrange> auxUpSideList = new ArrayList<>();
    private List<Integer> auxDownSideList = new ArrayList<>();

    public void run(List<ValorLagrange> lagrangeList) {
        // resolvingUpSide(lagrangeList);
        resolvingDownSide(lagrangeList);
    }

    public void resolvingUpSide(List<ValorLagrange> lagrangeList) {
        for (int i = 0; i < lagrangeList.size(); i++) {
            List<ValorLagrange> auxLagrangeList = new ArrayList<>(lagrangeList);
            auxLagrangeList.remove(i);
            multplyXWithTwo(auxLagrangeList.get(0), auxLagrangeList.get(1));
            sameXType(finalUpSideList);
            auxLagrangeList.remove(0);
            auxLagrangeList.remove(0);
            lagrangesUpSide.addAll(auxLagrangeList);

            if (!lagrangesUpSide.isEmpty()) {
                while (true) {
                    if (lagrangesUpSide.isEmpty())
                        break;
                    auxUpSideList.add(0, lagrangesUpSide.get(0));
                    lagrangesUpSide.remove(0);
                    multiplyAll(finalUpSideList, auxUpSideList);
                    auxUpSideList.remove(0);
                }
            }
            System.out.println(finalUpSideList);
        }
    }

    public void resolvingDownSide(List<ValorLagrange> lagrangeList) {

        for (int i = 0; i < lagrangeList.size(); i++) {
            int x = 0;
            List<ValorLagrange> auxLagrangeList = new ArrayList<>(lagrangeList);
            x = invertSignalNumber(lagrangeList.get(i).getValor());
            auxLagrangeList.remove(i);
            for (ValorLagrange valorLagrange : auxLagrangeList) {
                auxDownSideList.add(invertSignalNumber(valorLagrange.getValor()) - x);
            }
            System.out.println(auxDownSideList.get(0) * auxDownSideList.get(1));
            int indexJ = auxDownSideList.size();
            // com 2 valores esta dando certo, oque deve ser feito é a estretegia de pegar o
            // valor que deu certo e ir multiplicando pelo resto da lista
            for (int j = 0; j < indexJ; j++) {
                if (auxDownSideList.isEmpty())
                    break;
                auxDownSideList.remove(0);
            }

        }

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
        finalUpSideList.clear();
        finalUpSideList.addAll(results);
    }

    public void multplyXWithTwo(ValorLagrange v1, ValorLagrange v2) {
        finalUpSideList = new ArrayList<>();
        // primeira distributiva (x) * (x)
        vl = new ValorLagrange(1, v1.getX() + v2.getX());
        finalUpSideList.add(vl);
        // segunda distributiva (x) * (n)
        vl = new ValorLagrange(v1.getX() * v2.getValor(), v1.getX());
        finalUpSideList.add(vl);
        // terceira distributiva (n) * (x)
        vl = new ValorLagrange(v1.getValor(), v1.getX());
        finalUpSideList.add(vl);
        // quarta distributiva (n) * (n)
        vl = new ValorLagrange(v1.getValor() * v2.getValor(), 0);
        finalUpSideList.add(vl);
        sameXType(finalUpSideList);
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
        finalUpSideList = new ArrayList<>(listP);
    }

    public int invertSignalNumber(int value) {
        if (Integer.signum(value) == -1) {
            int positiveValue = (~(value - 1));
            return positiveValue;
        } else {
            int negativeValue = ~(value - 1);
            return negativeValue;
        }
    }

}
