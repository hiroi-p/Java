package Exercitiu1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static class Parabola
    {
        private int a;
        private int b;
        private int c;
        Parabola (int a, int b, int c)
        {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        public double[] varf()
        {
            double x = (double)(-b / (2 * a));
            double y = (double)((-(b*b) + 4*a*c)/(4*a));
            return new double[]{x, y};
        }
        @Override
        public String toString() {
            return "f(x) =" + a + "x^2 + " + b +"x + " + c;
        }
        public double [] calculmijloc(Parabola p)
        {
            double []v1=this.varf();
            double []v2=p.varf();

            double xm =(v1[0]+v2[0])/2;
            double ym =(v1[1]+v2[1])/2;
            return new double[]{xm,ym};
        }
        public static double [] mijloc2 (Parabola p,Parabola p2)
        {
           double []v1 = p.varf();
           double []v2 = p2.varf();

           double xm =(v1[0]+v2[0])/2;
           double ym =(v1[1]+v2[1])/2;
           return new double[]{xm,ym};
        }
        public double lungime(Parabola p)
        {
            double []v1 = varf();
            double []v2 = p.varf();

            return (Math.hypot((v2[0]-v1[0]),(v2[1]-v1[1])));
        }
        public static double lungime2(Parabola p,Parabola p2)
        {
            double []v1 = p.varf();
            double []v2 = p2.varf();

            return (Math.hypot((v2[0]-v1[0]),(v2[1]-v1[1])));
        }
    }
    public static void adaugare(List<Parabola> lista) throws FileNotFoundException {
        Scanner sc=new Scanner(new File("src/Exercitiu1/in.txt"));
        while (sc.hasNext())
        {
            Parabola p=new Parabola(sc.nextInt(),sc.nextInt(),sc.nextInt());
            lista.add(p);
        }

    }
    public static void main(String[] args) throws FileNotFoundException {
        List<Parabola> lista= new ArrayList<Parabola>();
        adaugare(lista);
        for ( Parabola p : lista)
        {
           System.out.println(p);
        }
        System.out.println("");
        double []mijloc= lista.get(0).calculmijloc(lista.get(1));
        double lungime=lista.get(0).lungime(lista.get(1));
        System.out.println("Mijlocul dintre prima si a doua parabola");
        System.out.println(mijloc[0]+ " " +" " + mijloc[1]);
        System.out.println("Lungimea dintre prima si a doua parabola");
        System.out.println(lungime);
    }
}
