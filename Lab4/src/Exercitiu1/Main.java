package Exercitiu1;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void adaugare(List<Echipamente> lista) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("Lab4/src/Exercitiu1/echipamente.txt"));
        sc.useDelimiter("[; \n]");
        String line;

        while (sc.hasNextLine()) {
            line = sc.nextLine();
            String[] values = line.split("[;\n]");
            String nume = values[0];
            int nr_inv = Integer.parseInt(values[1]);
            float pret = Float.parseFloat(values[2]);
            String zona_mag = values[3];
            Stare_echipamente stare = Stare_echipamente.valueOf(values[4]);
            String clasa= values[5];
            
           if( clasa.equals("imprimanta"))
           {
               float ppm = Float.parseFloat(values[6]);
               String dpi = values[7];
               int pcar = Integer.parseInt(values[8]);
               mod_tiparire modTiparire = mod_tiparire.valueOf(values[9].toLowerCase());

           } else if (clasa.equals("copiatoar")) {
                float pton= Float.parseFloat(values[6]);
                Format_copiere format = Format_copiere.valueOf(values[7]);
           } else if (clasa.equals("sistem de calcul")) {
               String tip_mon= values[6];
               float vit_proc= Float.parseFloat(values[7]);
               int c_hdd= Integer.parseInt(values[8]);
               Sistem_operare sistem = Sistem_operare.valueOf(values[9]);
           }


        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        List<Echipamente> lista = new ArrayList<Echipamente>();
        Scanner sc = new Scanner(System.in);
        adaugare(lista);
        int opt;
        while(true) {
            System.out.println("Meniu:");
            System.out.println("1. Afişarea tuturor echipamentelor");
            System.out.println("2. Afişarea imprimantelor");
            System.out.println("3. Afişarea copiatoarelor");
            System.out.println("4. Afişarea sistemelor de calcul");
            System.out.println("5. Modificarea stării în care se află un echipament");
            System.out.println("6. Setarea unui anumit mod de scriere pentru o imprimantă");
            System.out.println("7. Setarea unui format de copiere pentru copiatoare");
            System.out.println("8. Instalarea unui anumit sistem de operare pe un sistem de calcul");
            System.out.println("9. Afişarea echipamentelor vândute");
            System.out.println("0. Ieșire");
            System.out.print("Alegeți o opțiune: ");
            opt = sc.nextInt();

            switch (opt) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 0:
                    System.out.println("Ieșire din program.");
                    exit(0);
                    break;
                default:
                    System.out.println("Opțiune invalidă.");
            }


        }
    }
}
