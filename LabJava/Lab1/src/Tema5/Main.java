package Tema5;

import java.util.Random;

/*
5. Să se scrie un program care generează aleatoriu un număr întreg cuprins între 0 și 20.
Programul va determina dacă numărul aparține șirului lui Fobonacci.
 */
public class Main {
    public static boolean perfect_square(int n) {
        int s = (int)Math.sqrt(n);
        return (s*s == n);
    }
    public static boolean fibonacci_check(int n) {
        return perfect_square(5*n*n +4) || perfect_square(5*n*n -4 );
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int a=rand.nextInt(20);
        if (fibonacci_check(a))
        {
            System.out.println(a+" is a Fibonacci number");
        }
        else {
            System.out.println(a+" is not a Fibonacci number");
            System.out.println(a+" is not a Fibonacci number");
        }

    }
}
