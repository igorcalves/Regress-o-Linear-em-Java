package br.com.igor.app.Objetos;

public class ValorLagrange {

    private Integer valor;
    private Integer x;

    public ValorLagrange(int valor, int x) {
        this.valor = valor;
        this.x = x;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public boolean hasX() {
        if (this.getX() == 0 || this.getX() == null)
            return false;
        else
            return true;
    }

    private boolean valueIsOne() {
        if (this.getValor() == 1)
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        if (hasX()) {
            if (getX() == 1) {
                if (getValor() == 1) {
                    return "X";
                } else
                    return valor + "X";
            } else if (getValor() == 1)
                return "X^" + getX();
            else
                return valor + "X^" + getX();
        } else
            return valor + "";
    }

    private int checkSignalValue(int value) {
        if (Integer.signum(value) == 1) {
            int negativeVal = (~(value - 1));
            return negativeVal;
        } else {
            int positiveValue = (~(value - 1));
            return positiveValue;
        }
    }

}
