package br.com.igor.app;

import java.util.Scanner;

import br.com.igor.app.Objetos.x;

public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.print("Digite o valor de X: ");
            String a = sc.nextLine();
             x valueOfX = new x(a);
             if(valueOfX.getDoubleValue() == null);
             else break;
        }
    
        
        sc.close();
    }
}