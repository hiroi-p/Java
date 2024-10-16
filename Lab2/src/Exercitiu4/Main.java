package Exercitiu4;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static class Persoana
    {
       private String nume;
       private String cnp;
       Persoana( String nume, String cnp)
       {
           this.nume = nume;
           this.cnp = cnp;
       }
       int getVarsta()
       {
           String an = cnp.substring(1, 3);
           String luna = cnp.substring(3, 5);
           String zi = cnp.substring(5, 7);
           char a = cnp.charAt(0);
           switch (a) {
               case '1': case '2': an = "19" + an; break;
               case '3': case '4': an = "18" + an; break;
               case '5': case '6': an = "20" + an; break;
               default: throw new IllegalArgumentException("CNP invalid");
           }
           String Datanasterii=zi+"-"+luna+"-"+an;
           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
           LocalDate nastere = LocalDate.parse(Datanasterii, formatter);
           LocalDate actual = LocalDate.now();
           return Period.between(nastere, actual).getYears();
       }

    }
    public static void main(String[] args) {
        Vector<Persoana> Lista= new Vector<Persoana>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nr Persoane:");
        int nr = Integer.parseInt(sc.nextLine());
        for (int j = 0; j < nr; j++) {

            System.out.print("Nume:");
            String nume = sc.nextLine();
            System.out.print("CNP:");
            int v = 0;

            while (v == 0) {
                String cnp = sc.nextLine();
                if (cnp.length() == 13) {
                    int count = 0;
                    for (char c : cnp.toCharArray()) {
                        if ("1234567890".indexOf(c) != -1)
                            count++;
                        else
                            break;
                    }
                    if (count == 13) {
                        char c = cnp.charAt(0);
                        if ("1256".indexOf(c) != -1) {
                            int[] numar = {2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9};
                            int suma = 0;
                            for (int i = 0; i < 12; i++) {
                                int digit = Character.getNumericValue(cnp.charAt(i));
                                suma += digit * numar[i];
                            }
                            int cifra = suma % 11;
                            if (cifra == Character.getNumericValue(cnp.charAt(12))) {
                                v = 1;
                                Persoana p = new Persoana(nume, cnp);
                                Lista.add(p);
                            }
                        }

                    }
                }
            }
        }
        for (Persoana p : Lista) {
            System.out.println(p.nume);
            System.out.println(p.cnp);
            System.out.println("Varsta: "+p.getVarsta());
        }
    }

}
