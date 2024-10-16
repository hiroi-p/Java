package Exercitiu3;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sir = "Asta e un string de caractere pe care eu o sa-l prelucrez in continuare";
        String sir2 = "Acesta este un string pe care trebuie sa-l pun in celalalt sir de mai sus";
        StringBuffer sb = new StringBuffer(sir);
        sb.insert(4,sir2);
        System.out.println("String inserat:");
        System.out.println(sb.toString());
        System.out.print("De unde porneste stergerea si cat de mult sa streaga dupa?");
        int a=Integer.parseInt(sc.nextLine());
        int b=Integer.parseInt(sc.nextLine());
        b+=a;
        System.out.println("String Sters:\n");
        sb.delete(a,b);
        System.out.println(sb.toString());
    }
}
