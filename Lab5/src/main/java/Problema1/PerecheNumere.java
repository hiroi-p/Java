package Problema1;

import java.util.ArrayList;

public class PerecheNumere {
    private int numar1;
    private int numar2;

    public PerecheNumere(int numar1, int numar2) {
        this.numar1 = numar1;
        this.numar2 = numar2;
    }
    public PerecheNumere()
    {

    }

    public int getNumar1() {
        return numar1;
    }

    public void setNumar1(int numar1) {
        this.numar1 = numar1;
    }

    public int getNumar2() {
        return numar2;
    }

    public void setNumar2(int numar2) {
        this.numar2 = numar2;
    }

    @Override
    public String toString() {
        return "PerecheNumere{" +
                "numar1=" + numar1 +
                ", numar2=" + numar2 +
                '}';
    }

    // Metodă pentru a verifica dacă numerele sunt consecutive în șirul lui Fibonacci
    public boolean suntConsecutiveFibonacci() {
        return esteFibonacci(numar1) && esteFibonacci(numar2) &&
                (numar1 == fibonacciPrecedent(numar2) || numar2 == fibonacciPrecedent(numar1));
    }

    private boolean esteFibonacci(int numar) {
        int a = 0, b = 1;
        while (b < numar) {
            int temp = b;
            b = a + b;
            a = temp;
        }
        return b == numar;
    }

    private int fibonacciPrecedent(int numar) {
        int a = 0, b = 1;
        while (b < numar) {
            int temp = b;
            b = a + b;
            a = temp;
        }
        return a;
    }

    // Metodă pentru a calcula cel mai mic multiplu comun
    public int celMaiMicMultipluComun() {
        return (numar1 * numar2) / celMaiMareDivizorComun(numar1, numar2);
    }

    private int celMaiMareDivizorComun(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Metodă pentru a verifica dacă suma cifrelor este egală
    public boolean sumaCifrelorEgala() {
        return sumaCifrelor(numar1) == sumaCifrelor(numar2);
    }

    private int sumaCifrelor(int numar) {
        int suma = 0;
        while (numar != 0) {
            suma += numar % 10;
            numar /= 10;
        }
        return suma;
    }

    // Metodă pentru a verifica dacă numerele au același număr de cifre pare
    public boolean acelasiNumarDeCifrePare() {
        return numarCifrePare(numar1) == numarCifrePare(numar2);
    }

    private int numarCifrePare(int numar) {
        int count = 0;
        while (numar != 0) {
            if ((numar % 10) % 2 == 0) {
                count++;
            }
            numar /= 10;
        }
        return count;
    }
}