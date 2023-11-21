package br.com.igor.app.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.igor.app.Lagrange.Resolving;
import br.com.igor.app.Objetos.ValorLagrange;
import br.com.igor.app.Objetos.x;

public class LagrangeInput {

    List<ValorLagrange> listX = new ArrayList<>();
    List<Double> listY = new ArrayList<>();

    private Scanner sc = new Scanner(System.in);

    public void addValuesInListX() {
        x valueOfX = new x("");
        Double finalValueWithCorrectSignal = 0.0;

        System.out.print("Digite o valor de (X) ou 'proximo' para digitar o proximo parametro: ");
        while (!valueOfX.atribuirValorDouble(sc.nextLine(), 'X')) {
            if (valueOfX.getDoubleValue() != null) {
                    finalValueWithCorrectSignal = valueOfX.getDoubleValue() * -1;;
                listX.add(new ValorLagrange(finalValueWithCorrectSignal, 1));
            }
            valueOfX = new x("");
            System.out.println(listX);
        }

        finalValueWithCorrectSignal = 0.0;
        System.out.print("Digite os valores de (Y) você deverá digitar "+listX.size()+ " valores "+" para obter o resultado: ");
        int c = 0;
        while (!valueOfX.atribuirValorDouble(sc.nextLine(), 'Y') ) {
            if (valueOfX.getDoubleValue() != null) {
                finalValueWithCorrectSignal = valueOfX.getDoubleValue() * -1;
                listY.add(finalValueWithCorrectSignal);
            }
            valueOfX = new x("");
            System.out.println(listY);
            c++;
            if(c == listX.size()) break;
        }




    }

    public void attList() {
        Resolving rs = new Resolving();
        rs.run(listX,listY);
    }

}
