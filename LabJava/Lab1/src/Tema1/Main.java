package Tema1;

import java.util.Scanner;

/*
1. Se cere să se scrie un program Java care să calculeze şi să afişeze perimetru şi aria unui
dreptunghi. Valorile pentru lungime şi lățime se citesc de la tastatura. Sa se adauge un break
point pe prima linie care citește valoarea unei laturi si din acel punct să se ruleze programul
linie cu linie urmărind valorile variabilelor în memorie.
 */
public class Main {
    public static void main(String[] args) {
        int l, L;
        Scanner sc = new Scanner(System.in);
        System.out.print("l= ");
        l=sc.nextInt();
        System.out.print("L= ");
        L=sc.nextInt();
        System.out.println("Perimetru: "+(l+L));
        System.out.println("Aria: "+(l*L));


    }
}
