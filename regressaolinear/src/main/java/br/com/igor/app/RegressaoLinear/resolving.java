package br.com.igor.app.RegressaoLinear;

import java.util.List;

public class resolving {

    private Double sigmaX = 0.0;
    private Double sigmaXPow = 0.0;


    private Double sigmaY = 0.0;
    //private Double sigmaYPow = 0.0;

    private Double sigmaXvSigmaY = 0.0;

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
}
