package br.com.igor.app.Objetos;

import br.com.igor.app.Validations.inputValidations;

public abstract class regras {

    protected String value;

    public regras(String value){
    }



    public Double getDoubleValue() {
        if(inputValidations.isValidDoubleNumeric(value)){
         return Double.parseDouble(value);
        }else{
            return null;
        }
    }

   

    
    
}
