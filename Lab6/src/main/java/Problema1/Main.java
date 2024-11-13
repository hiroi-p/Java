package Problema1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
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
        System.out.println("\nTransformarea numelor în majuscule și colectarea într-o listă\n");
        List<String> majuscule = lista
                .stream()
                .map(angajat -> angajat.getNume().toUpperCase())
                .collect(Collectors.toList());
        majuscule.forEach(System.out::println);
        System.out.println("\nSalarii scoase sub 3000 RON si puse in alta lista:\n");
        List<Float> salarii = lista
                .stream()
                .filter(s ->s.getSalar()<3000)
                .map(s -> s.getSalar())
                .collect(Collectors.toList());
       salarii.forEach(System.out::println);
       System.out.println("\nAfisarea primului angajat\n");
        Optional<Angajat>primulAngajat = lista
                .stream()
                .min((a1,a2) -> a1.getData_angajarii().compareTo(a2.getData_angajarii()));
        primulAngajat.ifPresentOrElse(System.out::println, System.out::println);
        if (primulAngajat.isPresent()) {
            System.out.println("Primul angajat al firmei: " + primulAngajat.get());
        }
        else
        {
            System.out.println("Nu există angajați în firmă.");
        }
        System.out.println("\nStatistici salarii\n");
        DoubleSummaryStatistics statistici_salarii = lista
                .stream()
                .collect(Collectors.summarizingDouble(Angajat::getSalar));
        System.out.println("Salar maxim: "+ statistici_salarii.getMax());
        System.out.println("Salar minim: "+ statistici_salarii.getMin());
        System.out.println("Salar Mediu: "+ statistici_salarii.getAverage());
        System.out.println("\nIoni\n");
        Optional<Angajat> Ioni = lista
                .stream()
                .filter(s -> s.getNume().toLowerCase().contains("ion"))
                .findAny();
        Ioni.ifPresentOrElse(
                s -> System.out.println("Exista cel putin un Ion"),
                () -> System.out.println("Nu exista niciun Ion"));

        System.out.println("\nAnotimpuri: Vara \n");
        int anulprecedent =LocalDate.now().getYear()-1;
        String Anotimpuri[] = {"Iarna","Iarna","Primavara","Primavara","Primavara","Vara","Vara","Vara","Toamna","Toamna","Toamna","Iarna"};
        long numar =lista
                .stream()
                .filter(s -> s.getData_angajarii().getYear()==anulprecedent)
                .filter(s -> Anotimpuri[s.getData_angajarii().getMonthValue()-1].equals("Vara"))
                .count();
        System.out.println(numar);
    }
}
