package br.com.igor.app.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.igor.app.Objetos.fx;
import br.com.igor.app.Objetos.x;

public class input {


    private List<Double> listX = new ArrayList<>();

    private List<Double> listY = new ArrayList<>();

    private Scanner sc = new Scanner(System.in);

    public void atomicCreate() {
        addValuesInListX();
        addValuesInListY();
        showListx();
        sc.close();
    }

    public void addValuesInListX() {
        x valueOfX = new x("");
        System.out.print("Digite o valor de (X) ou 'proximo' para digitar o proximo parametro: ");
        while (!valueOfX.atribuirValor(sc.nextLine(), 'X')) {
            if (valueOfX.getDoubleValue() != null) {
                listX.add(valueOfX.getDoubleValue());
            }
            valueOfX = new x("");
        }
    }

    public void addValuesInListY() {
        fx valueOfX = new fx("");
        System.out.print("Digite o valor de (Y) ou 'proximo' para encerrar: ");
        while (!valueOfX.atribuirValor(sc.nextLine(), 'Y')) {
            if (valueOfX.getDoubleValue() != null) {
                listY.add(valueOfX.getDoubleValue());
            }
            valueOfX = new fx("");
        }
    }

    public void showListx() {
        int i = 0;
        for (Double x : listX) {
            System.out.println(x + "  " + listY.get(i));
            i++;
        }
    }
}
