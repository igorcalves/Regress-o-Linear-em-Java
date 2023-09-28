package br.com.igor.app;

import java.util.ArrayList;
import java.util.List;

import br.com.igor.app.Input.LagrangeInput;
import br.com.igor.app.Lagrange.Resolving;
import br.com.igor.app.Objetos.ValorLagrange;

public class zonadeTestes {
    public static void main(String[] args) {

        LagrangeInput lgi = new LagrangeInput();

        lgi.addValuesInListX();
        lgi.attList();
    }
}
