package br.com.igor.app;

import java.util.Scanner;

import br.com.igor.app.Input.input;
import br.com.igor.app.Lagrange.Resolving;
import br.com.igor.app.Mocks.listLagrange;
import br.com.igor.app.Objetos.fx;
import br.com.igor.app.Objetos.valorLagrange;
import br.com.igor.app.Objetos.x;

public class Main {
    public static void main(String[] args) {
        valorLagrange v1 = new valorLagrange(-3, 1);
        valorLagrange v2 = new valorLagrange (-4, 1);
        Resolving rs = new Resolving();
        rs.multplyXWithTwo(v1, v2);
        rs.sameXType();
        listLagrange.list();

    }
}