package br.com.igor.app.Mocks;

import java.util.ArrayList;
import java.util.List;

public class lists {

    public static List<Double> listX = new ArrayList<>();
    public static List<Double> listY = new ArrayList<>();

    public static List<Double> getListX() {
        listX.add(-1.0);
        listX.add(-0.1);
        listX.add(0.2);
        listX.add(1.0);
        //listX.add(5.0);
        //listX.add(6.0);
        return listX;
    }

    public static List<Double> getListY() {
        listY.add(1.0);
        listY.add(1.099);
        listY.add(0.808);
        listY.add(1.0);
        //listY.add(83.9);
        //listY.add(85.0);
        return listY;
    }
    
    
}
