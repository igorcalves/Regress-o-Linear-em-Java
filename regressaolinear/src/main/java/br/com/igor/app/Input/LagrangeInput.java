package br.com.igor.app.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.igor.app.Lagrange.Resolving;
import br.com.igor.app.Objetos.ValorLagrange;
import br.com.igor.app.Objetos.x;

public class LagrangeInput {

    List<ValorLagrange> listX = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void addValuesInListX() {
        x valueOfX = new x("");
        int finalValueWithCorrectSignal = 0;
        System.out.print("Digite o valor de (X) ou 'proximo' para digitar o proximo parametro: ");
        while (!valueOfX.atribuirValorInt(sc.nextLine(), 'X')) {
            if (valueOfX.getInt() != null) {
                if (Integer.signum(valueOfX.getInt()) == -1) {
                    finalValueWithCorrectSignal = (~(valueOfX.getInt() - 1));
                } else {
                    finalValueWithCorrectSignal = ~(valueOfX.getInt() - 1);
                }

                listX.add(new ValorLagrange(finalValueWithCorrectSignal, 1));
            }
            valueOfX = new x("");
            System.out.println(listX);
        }
    }

    public void attList() {
        Resolving rs = new Resolving();
        rs.run(listX);
    }

}
