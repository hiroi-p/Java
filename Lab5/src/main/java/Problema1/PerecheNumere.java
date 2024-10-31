package Problema1;

import java.util.ArrayList;

public class PerecheNumere {
    private int a;
    private int b;

    public PerecheNumere(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public PerecheNumere() {
    }

    @Override
    public String toString() {
        return "PerecheNumere{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
    public boolean suntConsecutiveFibonacci() {
        List<Integer> fibonacci = new ArrayList<>();
        fibonacci.add(0);
        fibonacci.add(1);
        int a = 0, b = 1, c = a + b;
        while (c <= Math.max(numar1, numar2)) {
            fibonacci.add(c);
            a = b;
            b = c;
            c = a + b;
        }
        return fibonacci.contains(numar1) && fibonacci.contains(numar2) &&
                Math.abs(fibonacci.indexOf(numar1) - fibonacci.indexOf(numar2)) == 1;
    }
    public int celMaiMicMultipluComun() {
        return (numar1 * numar2) / cmmdc(numar1, numar2);
    }

    private int cmmdc(int a, int b) {
        if (b == 0) return a;
        return cmmdc(b, a % b);
    }
    private int numarCifrePare(int numar) {
        int nr = 0;
        while (numar != 0) {
            if ((numar % 10) % 2 == 0) nr++;
            numar /= 10;
        }
        return nr;
    }
    public boolean aceeasiNumarCifrePare() {
        return numarCifrePare(numar1) == numarCifrePare(numar2);
    }

    private int sumaCifrelor(int numar) {
        int suma = 0;
        while (numar != 0) {
            suma += numar % 10;
            numar /= 10;
        }
        return suma;
    }
    public boolean sumaCifrelorEgala() {
        return sumaCifrelor(numar1) == sumaCifrelor(numar2);
    }
}
