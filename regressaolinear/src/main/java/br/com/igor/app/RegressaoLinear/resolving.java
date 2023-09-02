package br.com.igor.app.RegressaoLinear;

import java.util.List;

public class resolving {

    private Double sigmaX = 0.0;
    private Double sigmaXPow = 0.0;


    private Double sigmaY = 0.0;
    //private Double sigmaYPow = 0.0;

    private Double sigmaXvSigmaY = 0.0;

    public void atomicCreate(List<Double> listX, List<Double> listY){
        simpleSumXOrFx(listX,'X');
        simpleSumXOrFx(listY,'Y');
        sumWithPowXOrFx(listX, 'X');
        xXFx(listX, listY);
        applyingTheMathematicalFormulaAndShow(listX);
        

    }

    public void simpleSumXOrFx(List<Double> list,char xOrFx){
    for (Double num: list) {
        if(xOrFx == 'X'){
        sigmaX +=num;
        }
        else{
        sigmaY +=num;
        }
    }
    }

    public void sumWithPowXOrFx(List<Double> list,char xOrFx){
        for (Double num: list) {
            if(xOrFx == 'X'){
            sigmaXPow +=Math.pow(num,2);
            }
            else{
          //sigmaYPow +=Math.pow(num,2);
            }
        }
    }

    public void xXFx(List<Double> listX, List<Double> listY){
        int i = 0;
        for (Double lX : listX) {
            sigmaXvSigmaY += lX * listY.get(i);
            i++;
        }
    }

    public void applyingTheMathematicalFormulaAndShow(List<Double> listX){
        double a = (sigmaX * sigmaXvSigmaY - sigmaXPow * sigmaY)/(Math.pow(sigmaX, 2) - listX.size() * sigmaXPow);
        double b = (sigmaX * sigmaY - listX.size() * sigmaXvSigmaY)/(Math.pow(sigmaX, 2) - listX.size() * sigmaXPow);
/*
 * 
 System.out.println("a = " + a
 + "b = " + b
 + "\nx(k) = " + sigmaX 
 + "\nf(x) = " + sigmaY
 + "\nf(x).x(k) = " + sigmaXvSigmaY
 + "\nx(k)^2 = " + sigmaXPow);
 */

        System.out.println("g(x) = " + String.format("%.4f", a) + " " + String.format("%.4f", b) + "x");

    }
}
