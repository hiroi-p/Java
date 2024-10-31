package Problema1;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static void scriere(List<PerecheNumere> listaPerechi) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        File file = new File("Lab5/src/main/resources/perecheNumere.json");
        mapper.writeValue(file,listaPerechi);
    }
    static List<PerecheNumere> citire() throws IOException {
       ObjectMapper mapper = new ObjectMapper();
       File file = new File("Lab5/src/main/resources/perecheNumere.json");
       List<PerecheNumere> listaPerechi = mapper.readValue(file,new TypeReference<List<PerecheNumere>>(){});
        return listaPerechi;
    }
    public static void main(String[] args) {
        List<PerecheNumere> listaPerechi = new ArrayList<>();

        // Adăugarea a trei perechi de numere în listă
        listaPerechi.add(new PerecheNumere(1, 2));
        listaPerechi.add(new PerecheNumere(3, 4));
        listaPerechi.add(new PerecheNumere(5, 6));

        // Afișarea perechilor de numere
        for (PerecheNumere pereche : listaPerechi) {
            System.out.println(pereche);
        }
    }
}
