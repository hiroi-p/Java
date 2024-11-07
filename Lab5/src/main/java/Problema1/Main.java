package Problema1;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static void scriere(List<PerecheNumere> lista) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        File file = new File("Lab5/src/main/resources/perecheNumere.json");
        mapper.writeValue(file, lista);
    }

    static List<PerecheNumere> citire() throws IOException {
        File file = new File("Lab5/src/main/resources/perecheNumere.json");
        ObjectMapper mapper = new ObjectMapper();
        List<PerecheNumere> lista = mapper.readValue(file, new TypeReference<List<PerecheNumere>>() {
        });
        return lista;
    }

    public static void main(String[] args) throws IOException {
        List<PerecheNumere> lista = new ArrayList<>();

        // Adăugarea a trei perechi de numere în listă
        lista.add(new PerecheNumere(1, 2));
        lista.add(new PerecheNumere(3, 4));
        lista.add(new PerecheNumere(5, 6));

        scriere(lista);

        // Afișarea perechilor de numere
        for (PerecheNumere p : citire()) {
            System.out.println("Pereche: " + p);
            System.out.println("Consecutive Fibonacci: " + p.suntConsecutiveFibonacci());
            System.out.println("Cmmmc: " + p.celMaiMicMultipluComun());
            System.out.println("Suma cifrelor egala: " + p.sumaCifrelorEgala());
            System.out.println("Acelasi nr cifre pare: " + p.acelasiNumarDeCifrePare());
            System.out.println();
        }
    }
}
