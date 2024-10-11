package Tema4;

/*
4. Să se determine cmmdc a două numere naturale, a căror valoare maximă este 30. Numerele
vor fi generate aleatoriu cu ajutorul unui obiect de tip Random și metodei nextInt();
 */

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int a=rand.nextInt(30);
        int b=rand.nextInt(30);
        while(a!=b)
        {
         if(a>b)
             a=a-b;
         else
             b=b-a;
        }
        System.out.println(a);
    }
}
