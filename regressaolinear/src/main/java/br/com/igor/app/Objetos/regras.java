package br.com.igor.app.Objetos;

import br.com.igor.app.Validations.inputValidations;

public abstract class regras {

    protected String value;

    public regras() {
    }

    public regras(String value) {
        this.value = value;
    }

    public boolean atribuirValor(String value, char parameter) {
        if (value.equalsIgnoreCase("proximo"))
            return true;
        try {
            Double.parseDouble(value);
        } catch (Exception e) {
            System.out.print(
                    "o valor de (" + parameter + ") é invalido por favor digite um numero!\n" + "Digite o valor de ("
                            + parameter + ") ou 'proximo' para digitar o proximo parametro ou encerrar: ");
            return false;
        }
        this.value = value;
            System.out.print(
                "Digite o valor de (" + parameter + ") ou 'proximo' para digitar o proximo parametro ou encerrar: ");
        return false;
    }

    public Double getDoubleValue() {
        if (inputValidations.isValidDoubleNumeric(value)) {
            return Double.parseDouble(value);
        } else {
            return null;
        }
    }

}
