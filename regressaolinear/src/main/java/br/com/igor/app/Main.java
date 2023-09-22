package br.com.igor.app;

import br.com.igor.app.Lagrange.Resolving;
import br.com.igor.app.Mocks.listLagrange;
import br.com.igor.app.Objetos.valorLagrange;

public class Main {
    public static void main(String[] args) {
        valorLagrange v1 = new valorLagrange(-2, 1);
        valorLagrange v2 = new valorLagrange (-3, 1);
        valorLagrange v3 = new valorLagrange (-4, 1);
        Resolving rs = new Resolving();

        rs.run(v1, v2,v3);

        /*
         * verificar uma forma de remover um valor de um array enquanto itera sobre ele
         * ajustar o metodo sameType para encontrar os valores com (X) igual e somalos ou subtrailos
         * implementar o metodo q altera os valores de v1 v2 e v3
         * 
         */
    }
}