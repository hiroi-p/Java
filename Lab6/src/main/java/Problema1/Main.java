package Problema1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static void scriere(List<Angajat> lista) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        File file = new File("Lab6/src/main/resources/angajati.json");
        mapper.writeValue(file, lista);
    }

    static List<Angajat> citire() throws IOException {
        File file = new File("Lab6/src/main/resources/angajati.json");
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        List<Angajat> lista = mapper.readValue(file, new TypeReference<List<Angajat>>() {
        });
        return lista;
    }
    public static void main(String[] args) throws IOException {
        List<Angajat> lista = citire();
        lista.forEach(System.out::println);
        System.out.println("Afișarea angajaților care au salariul peste 2500 RON.\n");
        lista
                .stream()
                .filter((s) ->s.getSalar()>2500)
                .forEach(System.out::println);
        int ancurent=LocalDate.now().getYear();
        int anutrecut= ancurent-1;
        List<Angajat> aprilie = lista
                .stream()
                .filter((s) ->s.getPost().contains("sef") || s.getPost().contains("director"))
                .filter((s) ->s.getData_angajarii().getYear()==anutrecut)
                .filter((s) ->s.getData_angajarii().getMonth()== Month.APRIL)
                .collect(Collectors.toList());
        System.out.println("\nSefi si Directori din aprilie anul trecut:\n");
        aprilie.forEach(System.out::println);
        System.out.println("\n Angajati care nu sunt sefi sau directori descrescator\n");
        lista
                .stream()
                .filter((s) ->!(s.getPost().contains("sef") || s.getPost().contains("director")))
                .sorted(Comparator.comparing(Angajat::getSalar).reversed())
                .forEach(System.out::println);
    }
}
