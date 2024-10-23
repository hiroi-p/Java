package Exercitiu2;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;
class Produs
{
  private String nume;
  private float pret;
  private int cantitate;
  private LocalDate date;
  private float incasari=0;
  public Produs (String nume, float pret, int cantitate, LocalDate date)
  {
     this.nume = nume;
     this.pret = pret;
     this.cantitate = cantitate;
     this.date = date;
  }
  @Override
  public String toString()
  {
      return nume + " " + pret + " " + cantitate + " " + date;
  }

    public LocalDate getDate() {
        return date;
    }
    public float calculincasari() {
        if (cantitate > 0) {
            cantitate--;
            return (incasari += pret);
        } else {
            return 1;
        }
    }
    public int getCantitate() {
      return cantitate;
    }
    public String getNume()
    {
        return nume;
    }
}
public class Main {
    public static void adaugare(List<Produs> lista) throws FileNotFoundException {
        Scanner scf = new Scanner(new File("C:\\Users\\VM\\IdeaProjects\\Java\\Lab3\\src\\Exercitiu2\\in.csv"));
        scf.useDelimiter("[, \n]");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        while(scf.hasNext())
        {
            String nume = scf.next();
            float pret = Float.parseFloat(scf.next());
            int cantitate = Integer.parseInt(scf.next());
            LocalDate date = LocalDate.parse(scf.next().trim(), formatter);
            Produs p = new Produs(nume, pret, cantitate, date);
            lista.add(p);
        }
        scf.close();
    }
    public static void main(String[] args) throws FileNotFoundException {
       Scanner sc = new Scanner(System.in);
       List<Produs> lista= new ArrayList<Produs>();
       adaugare(lista);
       int opt;
       while(true){
           System.out.println("1.Afisare produse");
           System.out.println("2.Produse expirate");
           System.out.println("3.Vanzare produs");
           System.out.println("4.Afisare produse cu pret minim");
           System.out.println("5.Salvarea produselor care au o cantitate mai mica decat:");
           System.out.println("0.Iesire");
           opt = sc.nextInt();
           switch(opt){
               case 0:
                   exit(0);
               case 1: {
               for (Produs p : lista)
                   System.out.println(p.toString());
               System.out.println();
               }
               case 2:
               {
                   LocalDate today = LocalDate.now();
                   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                   for(Produs p : lista){
                       if (p.getDate().isBefore(today))
                           System.out.println(p.toString());
                   }
               }
               case 3:
                   System.out.println("Nume Produs:");
                   String prod = sc.next();
                   for (Produs p : lista)
                   {
                       if( p.getNume().equals(prod))
                       {
                           if (p.calculincasari()!=1)
                           {
                               System.out.println("Produs vandut, cantitate ramasa: "+p.getCantitate());
                               if (p.getCantitate()==0)
                               {
                                   lista.remove(p);
                                   break;
                               }
                           }
                           else
                           {
                               System.out.println("Produsul nu mai este in stoc!");
                           }

                       }
                   }

               case 4:
               case 5:
           }
       }
    }
}
