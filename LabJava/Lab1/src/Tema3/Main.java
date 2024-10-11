package Tema3;

import java.util.Scanner;
import java.util.Vector;

/*
3. Să se scrie un program care citește un număr n natural de la tastatură și afișează toți
divizorii acestuia pe ecran. Dacă numărul este prim se va afișa un mesaj corespunzător.
 */
public class Main {
    static boolean isPrime (int n)
    {
        if(n<=1)
        {
            return false;
        }
        for(int i=2;i<n;i++)
        {
            if (n%i==0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N= ");
        int n = sc.nextInt();
        if(isPrime(n))
        {
            System.out.println("Numarul este prim");
            System.exit(0);
        }
        Vector<Integer> d = new Vector<>(100, 2);
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                d.addElement(i);
            }
        }
        for (int i = 0; i < d.size(); i++)
        {
           System.out.println(d.get(i));
        }
    }
}
