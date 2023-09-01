package br.com.igor.app.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.igor.app.Objetos.fx;
import br.com.igor.app.Objetos.x;

public class input {

    private boolean condition = false;

    private List<Double> listX = new ArrayList<>();

    private Scanner sc = new Scanner(System.in);

    public void atomicCreate() {
        addValuesInListX();
        showListx();
        sc.close();
    }

    public void addValuesInListX() {
        x valueOfX = new x("");
        System.out.print("Digite o valor de (X) ou 'proximo' para digitar o proximo parametro ou encerrar: ");
        while (!valueOfX.atribuirValor(sc.nextLine(), 'X')) {
            if (valueOfX.getDoubleValue() != null) {
                listX.add(valueOfX.getDoubleValue());
            }
            valueOfX = new x("");
        }
    }

    public void showListx() {
        for (Double x : listX) {
            System.out.println(x);
        }
    }
}
