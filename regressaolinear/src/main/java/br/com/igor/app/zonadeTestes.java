package br.com.igor.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class zonadeTestes {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();

        nomes.add("a");
        nomes.add("b");
        nomes.add("c");
        nomes.add("d");
        nomes.add("f");
        nomes.add("g");
        nomes.add("h");
        nomes.add("i");
        String a = "";
        for (String string : nomes) {
            a += string;
        }
        nomes.clear();
        nomes.add(a);
        System.out.println(nomes);
    }
}
