package Problema1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static void scriere(Map<Integer,Carte> map) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        File file = new File("Lab7/src/main/resources/carti2.json");
        Map<String,Map<String,String>> rawCarti = new HashMap<>();
        map.forEach((ID, Carte) ->
        {
            Map<String,String> carti = new HashMap<>();
            carti.put("titlul", Carte.titlul());
            carti.put("autorul",Carte.autorul());
            carti.put("anul",String.valueOf(Carte.anul()));
            rawCarti.put(String.valueOf(ID),carti);

        });
        mapper.writeValue(file,rawCarti);
    }

    static Map<Integer, Carte> citire() throws IOException {
        File file = new File("Lab7/src/main/resources/carti.json");
        ObjectMapper mapper = new ObjectMapper();
        Map<Integer, Carte> carti = mapper.readValue(file, new TypeReference<Map<Integer, Carte>>() {
        });
        return carti;


    }

    public static void main(String[] args) throws IOException {
        Map<Integer, Carte> Colectie = citire();
        Colectie.forEach((id, Carte) -> {
            System.out.println("ID:" + id);
            System.out.println("Carte: " + Carte);
        });
        Colectie.remove(4);
        System.out.println("\n Cartea 4 Stearsa\n");
        Colectie.forEach((id, Carte) -> {
            System.out.println("ID:" + id);
            System.out.println("Carte: " + Carte);
        });
        System.out.println("\n Cartea 7 adaugata\n");
        Carte carte = new Carte("Generic", "Ion Creanga", 1700);
        Colectie.putIfAbsent(7, carte);
        Colectie.forEach((id, Carte) -> {
            System.out.println("ID:" + id);
            System.out.println("Carte: " + Carte);
        });
        System.out.println("\n Salvare Modificari\n");
        scriere(Colectie);
    }

}
